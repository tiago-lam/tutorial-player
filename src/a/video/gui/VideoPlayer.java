package a.video.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextField;

import org.json.simple.parser.ParseException;

import a.video.constants.InteractionsList;
import a.video.utils.Utils;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VideoPlayer extends JFrame{
	
	public FrameLabel frameLabel;
	public RetrieveButton retrieveButton;
	public String interactionFileName;
	public JComboBox comboBoxInteractions;
	
	public VideoPlayer() throws FileNotFoundException, IOException, ParseException 
	{
		getContentPane().setLayout(null);
		interactionFileName = "interaction/interaction.json";
		
		startComboBoxes();
		startLabels();
		startButtons();
		
		setVisible(true);
	}
	
	public void startButtons() throws FileNotFoundException, IOException, ParseException
	{
		retrieveButton = new RetrieveButton(interactionFileName, comboBoxInteractions, frameLabel);
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
		JLabel label = new JLabel("<<");
		label.setBounds(6, 176, 27, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel(">>");
		label_1.setBounds(944, 176, 27, 16);
		getContentPane().add(label_1);
		
		JLabel lblInteractionType = new JLabel("Interaction Type");
		lblInteractionType.setBounds(141, 11, 139, 16);
		getContentPane().add(lblInteractionType);
		
		frameLabel = new FrameLabel();
		frameLabel.setBounds(27, 47, 918, 457);
		getContentPane().add(frameLabel);	
		
	}
	
	public static void main(String [] args) throws FileNotFoundException, IOException, ParseException
	{
		VideoPlayer vp = new VideoPlayer();
	}
}