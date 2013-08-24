package gui;

import javax.sound.sampled.*;

import java.io.File;

public class SoundFactory {
	private SourceDataLine speakerBox;

	public void playSound(String filename) {
		AudioFormat format = null;

		AudioInputStream soundStream = null;
		try {
			soundStream = AudioSystem.getAudioInputStream(new File(filename));

			format = soundStream.getFormat();
			DataLine.Info dataline = new DataLine.Info(SourceDataLine.class, format);

			speakerBox = (SourceDataLine) AudioSystem.getLine(dataline);
		} catch (Exception e) {
			System.out.println("Something went wrong loading the sound "+filename);
		}

		new AudioThread(soundStream, format).start();
	}

	private class AudioThread extends Thread {
		byte tempBuffer[] = new byte[10000];
		public AudioInputStream stream;
		public AudioFormat format;

		public AudioThread(AudioInputStream stream, AudioFormat format) {
			this.stream = stream;
			this.format = format;
		}

		public void run() {
			try {
				speakerBox.open(format);
				speakerBox.start();

				int cnt = stream.read(tempBuffer, 0, tempBuffer.length);

				while (cnt != -1) {
					if (cnt > 0) {
						speakerBox.write(tempBuffer, 0, cnt);
					}

					cnt = stream.read(tempBuffer, 0, tempBuffer.length);
				}

				speakerBox.drain();
				speakerBox.close();

			} catch (Exception e) {
				System.out.println("Something went wrong playing the sound");
			}
		}
	}
}
