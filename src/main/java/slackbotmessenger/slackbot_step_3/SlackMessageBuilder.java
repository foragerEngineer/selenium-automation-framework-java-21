package slackbotmessenger.slackbot_step_3;

public class SlackMessageBuilder {

    public static String buildParentMessage(String suiteName, String buildVersion, String environment) {
        return String.format(
                "*%s*\n" +
                        "Test Suite of %s\n" +
                        " - Build Version: %s\n" +
                        " - Test Environment: %s\n",
                suiteName, suiteName, buildVersion, environment
        );
    }

    public static String buildThreadMessage(String testClassName, String allureLink, int passed, int failed, int broken, int skipped) {
        return String.format(
                "<%s|%s>\n" +
                        ":large_green_circle: Passed: %d  " +
                        ":red_circle: Failed: %d  " +
                        ":large_yellow_circle: Skipped: %d  " +
                        ":small_orange_diamond: Broken: %d\n",
                allureLink, testClassName, passed, failed, skipped, broken
        );
    }

}
