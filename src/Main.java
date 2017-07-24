import java.awt.Color;
import java.awt.Graphics;
import java.io.ByteArrayOutputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	AudioFormat format = new AudioFormat(44100, 16, 1, true, true);
	
	double x1 = 0, y1 = 250, x2 = 0, y2 = 0;
	
	public Main() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(true);
		this.setVisible(true);
		this.add(new Panel());
		TargetDataLine line = null;
		SourceDataLine speakers = null;
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		if (!AudioSystem.isLineSupported(info)) {

		}
		// Obtain and open the line.
		try {
		    line = (TargetDataLine) AudioSystem.getLine(info);
		    line.open(format);
		} catch (LineUnavailableException ex) {
		    // Handle the error ... 
		}
		
		ByteArrayOutputStream out  = new ByteArrayOutputStream();
		int numBytesRead = 0;
		double amp = 50;
		double acc = 0;
		byte[] data = new byte[line.getBufferSize() / 5];

		// Begin audio capture.
		line.start();
		
		DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, format);
        try {
			speakers = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
			speakers.open(format);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
        
        speakers.start();
        
        int pos = 0;
		while (speakers.getMicrosecondPosition() < 5000000) {
			pos++;
		   // Read the next chunk of data from the TargetDataLine.
		   numBytesRead = line.read(data, 0, data.length);
		   // Save this chunk of data.
		   out.write(data, 0, numBytesRead);
		   speakers.write(data, 0, numBytesRead);
		   x1 = speakers.getMicrosecondPosition()/100000;
		   y2 = data[pos];
		   repaint();
		   acc += Math.abs((data[pos+1] << 8 | data[pos] & 0xFF ) / 32767.0);
		   System.out.println(x1);
		   //y2 = amp;
		}
		System.out.println(data.length);
		amp /= (data.length / 2);
		System.out.println(amp);
	}
		
	public class Panel extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawLine((int) x1, (int) y1, (int) x1, (int) y2);
		}
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
