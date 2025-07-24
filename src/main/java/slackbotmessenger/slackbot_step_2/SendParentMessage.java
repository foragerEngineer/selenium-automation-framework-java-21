package slackbotmessenger.slackbot_step_2;

import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import slackbotmessenger.slackbot_step_1.SlackBotInitializer;

import java.io.IOException;

public class SendParentMessage {

    public String sendParentMessage(String message) {
        try {
            ChatPostMessageResponse response = SlackBotInitializer.getSlackInstance().methods(SlackBotInitializer.getToken()).chatPostMessage(req -> req
                    .channel(SlackBotInitializer.getChannelId())
                    .text(message));

            if (response.isOk()) {
                System.out.println("Message posted successfully! Status code: 200");
                return response.getTs(); // Return the timestamp of the sent message
            } else {
                System.out.println("Failed to post message. Error: " + response.getError());
            }

        } catch (IOException | SlackApiException e) {
            e.printStackTrace();
        }
        return null;
    }

}
