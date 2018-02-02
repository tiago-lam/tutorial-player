package a.video;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.javafx.scene.paint.GradientUtils.Parser;

public class FrameInteractionAssociation 
{
	
	public JSONArray interactionArray;
	
	public FrameInteractionAssociation(String interactionFileName) throws FileNotFoundException, IOException, ParseException
	{
		interactionArray = retrieveInteractionFile(interactionFileName);
	}
	
	public JSONObject retrieveInteraction(String interaction)
	{
		for (int i = 0; i < interactionArray.size(); i++) 
		{
			JSONObject interactionObject = (JSONObject)interactionArray.get(i);
			String interactionName = (String) interactionObject.get("interaction");
			if(interactionName.contains(interaction))
			{
				return interactionObject;
			}
		}
		return null;
	}
	
	public String[] retriveInteractionFrames(JSONObject interactionObject)
	{
		int tick = Integer.parseInt(interactionObject.get("tick").toString());
		
		String frame0 = "frames/frame" + (tick - 1) + ".png";
		String frame1 = "frames/frame" + (tick) + ".png";
		String frame2 = "frames/frame" + (tick + 1) + ".png";
		
		return new String[]{frame0, frame1, frame2};
	}
	
	public JSONArray retrieveInteractionFile(String interactionFileName) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();

		JSONArray interactionArray = (JSONArray) parser.parse(new FileReader(interactionFileName));
		
		return interactionArray;
	}
	
}
