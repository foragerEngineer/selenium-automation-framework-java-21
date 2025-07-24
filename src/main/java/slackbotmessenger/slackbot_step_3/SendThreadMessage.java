package slackbotmessenger.slackbot_step_3;

import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import slackbotmessenger.slackbot_step_1.SlackBotInitializer;

import java.io.IOException;

public class SendThreadMessage {

    public void sendThreadMessage(String parentMessageTs, String message) {
        try {
            ChatPostMessageResponse response = SlackBotInitializer.getSlackInstance().methods(SlackBotInitializer.getToken()).chatPostMessage(req -> req
                    .channel(SlackBotInitializer.getChannelId())
                    .text(message)
                    .threadTs(parentMessageTs));

            if (response.isOk()) {
                System.out.println("Thread message posted successfully! Status code: 200");
            } else {
                System.out.println("Failed to post thread message. Error: " + response.getError());
            }

        } catch (IOException | SlackApiException e) {
            e.printStackTrace();
        }
    }

}
