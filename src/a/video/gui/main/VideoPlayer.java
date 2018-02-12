package a.video.gui.main;

import javax.swing.JFrame;
import javax.swing.JLabel;

import a.video.gui.elements.FrameLabel;
import a.video.gui.elements.PlayVideoButton;
import javax.swing.JButton;

/**
 * Code written by Tiago Machado (tiago.machado@nyu.edu)
 * Date: 06/02/2018
 * @author Tiago Machado
 */

public class VideoPlayer extends JFrame
{
	
	public String [] frames;
	public FrameLabel frameToShow;
	public int delayTime;
	public PlayVideoButton playVideoButton;
	
	public VideoPlayer(String [] frames, int delayTime)
	{
		setBounds(0, 0, 444, 270);
		getContentPane().setLayout(null);
		frameToShow = new FrameLabel(6, 6, 438, 266);
		getContentPane().add(frameToShow);
		
		this.playVideoButton = new PlayVideoButton(frames, frameToShow, delayTime);
		this.playVideoButton.setBounds(165, 281, 117, 29);
		
		setVisible(true);	
	}
	
	public static void main(String [] args)
	{
		
	}
}
