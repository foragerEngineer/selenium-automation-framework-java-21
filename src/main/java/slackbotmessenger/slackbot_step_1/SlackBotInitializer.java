package slackbotmessenger.slackbot_step_1;

import com.slack.api.Slack;

public class SlackBotInitializer {

    private static Slack slackInstance;
    private static String token;
    private static String channelId;
    private static String webhookUrl;

    public static void initialize(String botToken, String channel, String webhookUrl) {
        token = botToken;
        channelId = channel;
        webhookUrl = webhookUrl;
        slackInstance = Slack.getInstance();
    }

    public static Slack getSlackInstance() {
        return slackInstance;
    }

    public static String getToken() {
        return token;
    }

    public static String getChannelId() {
        return channelId;
    }

    public static String getWebhookUrl() {
        return webhookUrl;
    }
}
