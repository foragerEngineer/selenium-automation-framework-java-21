# DEMO: Selenium Automation Framework With Java 21

### Prerequisites
1. Ensure you have Java 21 installed
2. Ensure you set java 21 within your environment variables
3. This project records with `ffmpeg`, installed from `Brew`, so be sure to install this. Otherwise, comment out the recording functionality in the `BaseTest.java` class under the @BeforeMethod setup and comment out `MonteScreenRecUtil.stopRecording();`.

### Slackbot Reporting
1. This project utilizes Slackbot API for reporting
2. If you want to report to your own Slack channel, you must obtain your your slack channel webhook, your slack channel Id and your own personal slack bot token.
3. Within your `.m2` folder, add a new file called `webhooksettings.xml`
<img width="272" height="214" alt="image" src="https://github.com/user-attachments/assets/cb0ba55b-01e0-470a-8c11-9410ce897785" />


4. Add the following properties
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">

    <activeProfiles>
        <activeProfile>automation</activeProfile>
    </activeProfiles>

    <profiles>
        <profile>
            <id>automation</id>
            <properties>
                <!-- Automation User -->
                <automationUser.webhook>YOUR_SLACK_CHANNEL_WEBHOOK</automationUser.webhook> <!-- EXAMPLE: https://hooks.slack.com/services/4q45n98c9nq98adjs398qq9q89a83n23kn -->
                <automationUser.channelId>YOUR_CHANNEL_ID</automationUser.channelId> <!-- EXAMPLE: C038793DFG -->
                <slack.token>your-slack-token-here</slack.token>
            </properties>
        </profile>
    </profiles>
</settings>
```

#### SAMPLE OUTPUT
<img width="272" height="167" alt="image" src="https://github.com/user-attachments/assets/c2d18701-a8d0-4e34-8930-b58996b1c58e" />


## Running a Test
To run a test, simply navigate to any of the test folders under `test/java/tests` and click on the TestNG play button.

<img width="469" height="202" alt="image" src="https://github.com/user-attachments/assets/4f6d3f85-35da-4f0f-8693-2c2ed398fb8f" />
