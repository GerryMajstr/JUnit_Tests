package utils;

public class VideoRecorder {

    public static void startRecording() {
        System.out.println("Video recording started");
    }

    public static String stopRecording() {

        // stop recording logic
        System.out.println("Video recording stopped");
        return "target/videos/test-video.mp4";
    }
}
