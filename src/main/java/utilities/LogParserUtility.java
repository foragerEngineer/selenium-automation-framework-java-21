package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LogParserUtility {

    /**
     * Parses test logs and returns as Map where key is test name and value is List of lines.
     *
     * @return Map of Lists per test
     */
    private static Map<String, List<String>> parseLogFile() {
        Map<String, List<String>> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("target/logs/log.log"))) {

            String readLine;
            String currentThread = null;
            Set<String> threads = new HashSet<>();

            while ((readLine = br.readLine()) != null) {
                if (readLine.contains("thread")) {
                    currentThread = readLine.split("\\s+")[3];
                    threads.add(currentThread);

                    if (readLine.contains("TEST METHOD:")) {
                        if (map.containsKey(currentThread)) {
                            storeLogsWithCorrectKey(map, currentThread);
                        }
                        map.put(currentThread, new ArrayList<>());
                    }
                }
                if (currentThread != null && map.containsKey(currentThread)) {
                    map.get(currentThread).add(readLine);
                }
            }
            for (String thread : threads) {
                if (map.containsKey(thread)) {
                    storeLogsWithCorrectKey(map, thread);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * "Renames" a key in map to match test name.
     * If key with this name already exists, appends log to it.
     *
     * @param map    Map with log Lists
     * @param oldKey Key in map to "rename"
     */
    private static void storeLogsWithCorrectKey(Map<String, List<String>> map, String oldKey) {
        List<String> testLog = map.remove(oldKey);
        int index = testLog.get(0).lastIndexOf(' ') + 1;
        String testName = testLog.get(0).substring(index);
        if (map.containsKey(testName)) {
            map.get(testName).addAll(testLog);
        } else {
            map.put(testName, testLog);
        }
    }

    /**
     * Parses log file based on the test method name.
     *
     * @param testName test method name
     * @return log entries for specific test
     */
    public static String getParsedTestLog(String testName) {
        Map<String, List<String>> parsedTestLogs = parseLogFile();
        List<String> testLog = parsedTestLogs.get(testName);
        return String.join(System.lineSeparator(), (testLog == null) ? Collections.emptyList() : testLog);
    }

}
