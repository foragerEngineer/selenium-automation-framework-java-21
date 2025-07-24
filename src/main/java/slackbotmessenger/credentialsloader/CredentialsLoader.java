package slackbotmessenger.credentialsloader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import slackbotmessenger.slackbot_step_1.SlackBotInitializer;
import slackbotmessenger.userwebhookenums.UserWebhooks;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CredentialsLoader {

    public static void loadCredentials(UserWebhooks userWebhook) {
        try {
            // Locate the user's .m2/webhooksettings.xml file
            String userHome = System.getProperty("user.home");
            File settingsFile = new File(userHome + "/.m2/webhooksettings.xml");

            if (!settingsFile.exists()) {
                throw new IllegalArgumentException("settings.xml not found in user's .m2 directory.");
            }

            // Parse the settings.xml file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document settingsDoc = dBuilder.parse(settingsFile);
            settingsDoc.getDocumentElement().normalize();

            // Locate the active profile <properties>
            NodeList profiles = settingsDoc.getElementsByTagName("profile");
            Element propertiesElement = null;
            for (int i = 0; i < profiles.getLength(); i++) {
                Element profile = (Element) profiles.item(i);
                if ("github".equals(profile.getElementsByTagName("id").item(0).getTextContent())) {
                    propertiesElement = (Element) profile.getElementsByTagName("properties").item(0);
                    break;
                }
            }

            if (propertiesElement == null) {
                throw new IllegalArgumentException("<properties> section for 'github' profile not found in settings.xml.");
            }

            // Fetch token, webhook URL, and channel ID
            String token = getTagValue(propertiesElement, "slack.token");
            String webhookUrl = getTagValue(propertiesElement, userWebhook.getWebhookTag());
            String channelId = getTagValue(propertiesElement, userWebhook.getChannelIdTag());

            // Initialize SlackBot with the loaded credentials
            SlackBotInitializer.initialize(token, channelId, webhookUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTagValue(Element parent, String tagName) {
        if (parent.getElementsByTagName(tagName).getLength() == 0) {
            throw new IllegalArgumentException("Tag <" + tagName + "> not found in settings.xml.");
        }
        return parent.getElementsByTagName(tagName).item(0).getTextContent();
    }
}
