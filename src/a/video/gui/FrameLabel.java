package a.video.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FrameLabel extends JLabel
{
	public FrameLabel() {
		super();
	}
	
	public void updateFrame(String frame)
	{
		ImageIcon imgThisImg = new ImageIcon(frame);
		this.setIcon(imgThisImg);
	}
	
}
