package slackbotmessenger.userwebhookenums;

public enum UserWebhooks {

    PERSONAL_USER_SLACK_WEBHOOK("automationUser", "automationUser.webhook", "automationUser.channelId");

    private final String userTag;
    private final String webhookTag;
    private final String channelIdTag;

    UserWebhooks(String userTag, String webhookTag, String channelIdTag) {
        this.userTag = userTag;
        this.webhookTag = webhookTag;
        this.channelIdTag = channelIdTag;
    }

    public String getUserTag() {
        return userTag;
    }

    public String getWebhookTag() {
        return webhookTag;
    }

    public String getChannelIdTag() {
        return channelIdTag;
    }

}
