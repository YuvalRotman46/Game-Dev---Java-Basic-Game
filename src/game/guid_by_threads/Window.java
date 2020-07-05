package game.guid_by_threads;
import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {
	public static final int WIDTH = 800;
	public static final int HEIGHT  = 600;
	
	private static final long serialVersionUID = -7367296798068251825L;
	
	private Game gamePanel;
	
	public Window(String title, Game gamePanel){
		super(title);
		
		this.gamePanel = gamePanel;
		
		setSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*The panel stuff*/
		add(gamePanel);
		
		/*showing the Frame*/
		setVisible(true);
		
		/*Staring threads*/
		gamePanel.start();
	}

	
	
	/*JFrame methods*/
	
	/*Getters & Setters*/
	public Game getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(Game gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void refresh() {
		this.revalidate();
		this.repaint();
	}
	
	public void removeGamePanel() {
		this.remove(gamePanel);
		refresh();
	}
	
	public void addGamePanel(Game gamePanel) {
		this.add(gamePanel);
		refresh();
	}
	
	public void swichGamePanel(Game panel) {
		this.removeGamePanel();
		this.addGamePanel(panel);
	}
	/*Inner classes*/
	
	public static void main(String[] args) {
		StartPanel sp = new StartPanel();
		sp.addGameObject(new RButton(274,150,RButtonsType.START));
		sp.addGameObject(new RButton(274, 250, RButtonsType.LOG_IN));
		
		sp.start();
		Window win = new Window("my game",sp );
	}
}
