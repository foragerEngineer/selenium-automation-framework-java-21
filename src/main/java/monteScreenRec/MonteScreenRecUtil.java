package monteScreenRec;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import utilities.UiHelper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;

/***
 * >>>>>>>>>>>>>>>>>>>>>>>> READ ME <<<<<<<<<<<<<<<<<<<<<<<<<<<<
 *
 * Monte Screen Recorder does not support multiple formats and is not thread-safe.
 * This utility class provides a way to create a screen recorder instance, however, method are not being used
 * but rather stored here for documentation purposes. This tool still works, it's just not that friendly.
 */
public class MonteScreenRecUtil extends ScreenRecorder {

    public static ScreenRecorder screenRecorder;

    public MonteScreenRecUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                              Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        } else if (!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        return new File(movieFolder,
                dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }

    public static void startVideoRec() {
        try {
            File file = new File("target/videos");
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = screenSize.width;
            int height = screenSize.height;

            Rectangle captureSize = new Rectangle(0, 0, width, height);

            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                    getDefaultScreenDevice()
                    .getDefaultConfiguration();
            screenRecorder = new MonteScreenRecUtil(gc, captureSize,
                    new Format(MediaTypeKey,
                            FormatKeys.MediaType.FILE,
                            MimeTypeKey,
                            MIME_AVI),
                    new Format(MediaTypeKey,
                            MediaType.VIDEO,
                            EncodingKey,
                            ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey,
                            ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            DepthKey,
                            24,
                            FrameRateKey,
                            Rational.valueOf(15), QualityKey,
                            1.0f,
                            KeyFrameIntervalKey,
                            15 * 60),
                    new Format(MediaTypeKey,
                            MediaType.VIDEO,
                            EncodingKey,
                            "black",
                            FrameRateKey,
                            Rational.valueOf(30)),
                    null, file);
            screenRecorder.start();
        } catch (HeadlessException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void stopRecording() {
        try {
            screenRecorder.stop();
            UiHelper uiHelper = new UiHelper();
            uiHelper.waitAndSleep();
            File videoDirectory = new File("target/videos");
            File[] videoFiles = videoDirectory.listFiles((dir, name) -> name.endsWith(".avi"));
            if (videoFiles != null && videoFiles.length > 0) {
                for (File videoFile : videoFiles) {
                    System.out.println("Found .avi file: " + videoFile.getAbsolutePath());
                    System.out.println("Converting file to .webm...");
                    String newFilePath = convertVideoToWebm(videoFile.getAbsolutePath());
                    System.out.println("Converted file path: " + newFilePath);
                }
            } else {
                System.out.println("No .avi files found in directory: " + videoDirectory.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String convertVideoToWebm(String videoPath) {
        File videoFile = new File(videoPath);
        String newFilePath = null;
        if (videoFile.exists() && videoFile.getName().endsWith(".avi")) {
            newFilePath = videoPath.replace(".avi", ".webm");
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(
                        "ffmpeg", "-i", videoPath, "-c:v", "libvpx", "-b:v", "1M", "-c:a", "libvorbis", newFilePath);
                processBuilder.inheritIO();
                Process process = processBuilder.start();
                process.waitFor();
                System.out.println("File converted to .webm: " + newFilePath);

                // Delete the original .avi file
                if (videoFile.delete()) {
                    System.out.println("Deleted original .avi file: " + videoPath);
                } else {
                    System.out.println("Failed to delete original .avi file: " + videoPath);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                System.out.println("Failed to convert file to .webm: " + videoPath);
            }
        } else {
            System.out.println("No .avi file found at: " + videoPath);
        }
        UiHelper uiHelper = new UiHelper();
        uiHelper.waitAndSleep();
        return newFilePath;
    }
}
