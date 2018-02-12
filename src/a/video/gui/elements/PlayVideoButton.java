package a.video.gui.elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.json.simple.JSONObject;

public class PlayVideoButton extends JButton implements ActionListener
{
	public String [] frames;
	public FrameLabel frameLabel;
	public long timeDelay;
	public int frameIndex;
	
	public PlayVideoButton(String [] frames, FrameLabel frameLabel, long timeDelay)
	{
		super();
		addActionListener(this);
		this.setText("Play");
		this.frames = frames;
		this.frameLabel = frameLabel;
		this.timeDelay = timeDelay;
		this.frameIndex = 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try {
			Thread.sleep(timeDelay);
			frameLabel.updateFrame(this.frames[this.frameIndex++ % 3]);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}