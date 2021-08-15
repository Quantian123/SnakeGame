import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffectLoader {
    private static File file;
    private static AudioInputStream audioStream;
    private static Clip clip;
    public static void play(String fileName) {
        try {
            file = new File(fileName);
            audioStream = AudioSystem.getAudioInputStream(file);
            clip= AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){}
    }
}
