package a.video.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import a.video.FrameInteractionAssociation;

public class RetrieveButton extends JButton implements ActionListener{

	public FrameInteractionAssociation frameInteractionAssociation;
	public FrameLabel frameLabel;
	public JComboBox<String> interactionComboBox;
	public String[] frames;
	
	public RetrieveButton(String interactionFileName, JComboBox<String> interactionComboBox, FrameLabel frameLabel) throws FileNotFoundException, IOException, ParseException {
		
		addActionListener(this);
		this.frameLabel = frameLabel;
		this.frameInteractionAssociation = new FrameInteractionAssociation(interactionFileName);
		this.interactionComboBox = interactionComboBox;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String interaction = interactionComboBox.getSelectedItem().toString();
		JSONObject iteractionObject = this.frameInteractionAssociation.retrieveInteraction(interaction);
		frames = this.frameInteractionAssociation.retriveInteractionFrames(iteractionObject);
		this.frameLabel.updateFrame(frames[1]);
	}

	
}
