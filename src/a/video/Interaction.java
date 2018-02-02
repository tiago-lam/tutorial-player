package a.video;

public class Interaction {
	
	public String interaction;
	public String sprite1;
	public String sprite2;
	public int tick;
	
	public Interaction(int tick, String interaction, String sprite1, String sprite2)
	{
		this.interaction = interaction;
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
		this.tick = tick;
	}
	
	public Interaction()
	{
		
	}

}
