# DEMO: Selenium Automation Framework With Java 21

## Getting Started

### Prerequisites
1. Ensure you have Java 21 installed
2. Ensure you set java 21 within your environment variables
3. This project records with `ffmpeg`, installed from `Brew`, so be sure to install this. Otherwise, comment out the recording functionality in the `BaseTest.java` class under the @BeforeMethod setup and comment out `MonteScreenRecUtil.stopRecording();`.
4. This project utilizes slackbot reporting.
   a. If you want to report to your own Slack channel, use must obtain your your slack channel webhook, your slack channel Id and your own personal slack bot token.
   b. Sample preview below
<img width="272" height="167" alt="image" src="https://github.com/user-attachments/assets/c2d18701-a8d0-4e34-8930-b58996b1c58e" />


## Running a Test
To run a test, simply navigate to any of the test folders under `test/java/tests` and click on the TestNG play button.

<img width="469" height="202" alt="image" src="https://github.com/user-attachments/assets/4f6d3f85-35da-4f0f-8693-2c2ed398fb8f" />
