package game.guid_by_threads;

import java.awt.*;
import java.util.UUID;

public abstract class GameObject {
	
	public String ID;
	public Location lacation;
	
	public GameObject(Location location) {
		// TODO Auto-generated constructor stub
		this.lacation = location;
		this.ID = UUID.randomUUID().toString();
	}
	
	public GameObject(int x, int y) {
		this.lacation = new Location(y,x);
		this.ID = UUID.randomUUID().toString();
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics g);
	
	public abstract Image getImage();
}
