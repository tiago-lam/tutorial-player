package a.video.gui.elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import a.video.gui.main.VideoPlayer;

public class ShowVideoPlayerButton extends JButton implements ActionListener
{
	public String [] frames;
	public int delayTime;
	
	public ShowVideoPlayerButton(String [] frames, int delayTime) {
		addActionListener(this);
		this.frames = frames;
		this.delayTime = delayTime;
		setText("Video");
	}
	
	public ShowVideoPlayerButton() {
		addActionListener(this);
		setText("Video");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new VideoPlayer(frames, delayTime);
	}

}