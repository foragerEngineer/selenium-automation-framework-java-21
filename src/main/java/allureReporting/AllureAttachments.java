package allureReporting;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class AllureAttachments {

    /***
     * This is the main method that orchestrates the process.
     */
    @Step("Video Attachment")
    public static void fetchAndAttachVideoToAllure() {
        try {
            Path videoDir = Paths.get("target/videos");
            Optional<Path> latestVideo = findLatestVideo(videoDir);

            if (latestVideo.isPresent()) {
                Path videoPath = latestVideo.get();
                System.out.println(">>>>>>>>>>>>>>>> Video path: " + videoPath);
                attachVideoToAllure(videoPath);
            } else {
                throw new RuntimeException("No video files found in target/videos directory");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch video file", e);
        }
    }

    /***
     * A helper method to find the latest video file.
     * @param videoDir The directory where the video files are stored.
     * @return The latest video file.
     * @throws IOException If an I/O error occurs.
     */
    private static Optional<Path> findLatestVideo(Path videoDir) throws IOException {
        try (Stream<Path> paths = java.nio.file.Files.list(videoDir)) {
            return paths
                    .filter(java.nio.file.Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".webm"))
                    .max(Comparator.comparingLong(path -> path.toFile().lastModified()));
        }
    }

    /***
     * A helper method to attach the video to the Allure report.
     * @param videoPath The path to the video file.
     */
    private static void attachVideoToAllure(Path videoPath) {
        try (FileInputStream fis = new FileInputStream(videoPath.toFile());
             FileChannel fileChannel = fis.getChannel()) {
            fileChannel.force(true);
            Allure.addAttachment("Test Video", "video/webm", new ByteArrayInputStream(java.nio.file.Files.readAllBytes(videoPath)), "webm");
        } catch (IOException e) {
            throw new RuntimeException("Failed to attach video to Allure report", e);
        }
    }

}
