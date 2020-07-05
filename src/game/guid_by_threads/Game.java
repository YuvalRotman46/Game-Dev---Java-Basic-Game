package game.guid_by_threads;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Game extends Canvas implements Runnable {
	public static final long serialVersionUID = 8940887313534017948L;
	
	public static String backgroundImageLoc = "/images/background.jpg";
	
	/*
	 * static variables
	 */
	
	/*
	 * members
	 */
	protected ArrayList<GameObject> gameObjects;
	protected boolean running;
	protected Thread thread;

	public Game() {
		super();
		
		running = false;
		thread = new Thread(this);
		gameObjects = new ArrayList<GameObject>();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		drawBackground(g);
		
		for(GameObject go : this.gameObjects) {
			go.draw(g);
		}
	}
	
	public void update() {
		for(GameObject go : this.gameObjects) {
			go.update();
		}
	}
	
	public synchronized void start(){
		if(running) return;
		
		running = true;
		thread.start();
		
	}
	

	@Override
	public void run() {
		long lastTime = System.currentTimeMillis();
		int delay = 80;
		
		while(running) {
			long currentTime = System.currentTimeMillis();
			if((currentTime-lastTime)>=delay) {
				tick();
				lastTime = System.currentTimeMillis();
			}
		}
	}
	
	public void tick() {
		this.update();
		this.refresh();
	}
	
	public void stop() {
		running = false;
	}
	
	public boolean isAlive() {
		return thread.isAlive();
	}
	
	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(backgroundImageLoc));
		return i.getImage();
	}
	
	public void drawBackground(Graphics g) {
		Graphics2D graphics = (Graphics2D)g;
		graphics.drawImage(getBackgroundImage(),0,0,Window.WIDTH, Window.HEIGHT,null);
	}
	
	public  void refresh() {
		this.revalidate();
		this.repaint();
	}
	
	public synchronized void addGameObject(GameObject gameObject) {
		this.gameObjects.add(gameObject);
	}
	
	public synchronized void removeGameObject(GameObject gameObject) {
		this.gameObjects.remove(gameObject);
	}

}