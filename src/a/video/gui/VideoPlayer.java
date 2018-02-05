package a.video.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JTextField;
import org.json.simple.parser.ParseException;

import a.video.FrameInteractionAssociation;
import a.video.constants.InteractionsList;
import a.video.utils.Utils;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VideoPlayer extends JFrame{
	
	public FrameInteractionAssociation frameInteractionAssociation;
	public FrameLabel [] frameLabel;
	public RetrieveButton retrieveButton;
	public String interactionFileName;
	public JComboBox comboBoxInteractions;
	
	public VideoPlayer() throws FileNotFoundException, IOException, ParseException 
	{
		getContentPane().setLayout(null);
		setBounds(10,10,1080,720);
		interactionFileName = "interaction/interaction.json";
		frameInteractionAssociation = new FrameInteractionAssociation(interactionFileName);
		
		startComboBoxes();
		startLabels();
		startButtons();
		
		setVisible(true);
	}
	
	public void startButtons() throws FileNotFoundException, IOException, ParseException
	{
		retrieveButton = new RetrieveButton(frameInteractionAssociation, comboBoxInteractions, frameLabel);
		retrieveButton.setBounds(544, 6, 117, 29);
		getContentPane().add(retrieveButton);
	}
	
	public void startComboBoxes()
	{
		comboBoxInteractions = new JComboBox();
		Utils.feedComboBox(comboBoxInteractions, InteractionsList.interactionList);
		comboBoxInteractions.setBounds(258, 7, 276, 27);
		getContentPane().add(comboBoxInteractions);
	}
	
	public void startLabels()
	{
		JLabel lblInteractionType = new JLabel("Interaction Type");
		lblInteractionType.setBounds(141, 11, 139, 16);
		getContentPane().add(lblInteractionType);
		
		startingFrameLabels();
		
	}

	/**
	 * 
	 */
	public void startingFrameLabels() {
		frameLabel = new FrameLabel[3];
		
		frameLabel[0] = new FrameLabel(27, 47, 300, 200);
		frameLabel[1] = new FrameLabel(337, 47, 300, 200);
		frameLabel[2] = new FrameLabel(647, 47, 300, 200);
		
		getContentPane().add(frameLabel[0]);
		getContentPane().add(frameLabel[1]);
		getContentPane().add(frameLabel[2]);
	}
	
	public static void main(String [] args) throws FileNotFoundException, IOException, ParseException
	{
		VideoPlayer vp = new VideoPlayer();
	}
}