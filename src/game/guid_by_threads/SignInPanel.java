package game.guid_by_threads;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;

public class SignInPanel extends JFrame {
	public static String backgroundImageLoc = "/images/background.jpg";
	
	public static final int WIDTH = 400;
	public static final int HEIGHT  = 300;

	public SignInPanel() {
		// TODO Auto-generated constructor stub
		
		setSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JLabel j;
				add(j = new JLabel("Please enter user name and password..."), BorderLayout.NORTH);
				/*add(new JPanel(),BorderLayout.CENTER);
				
				j.setForeground(Color.white);*/
				
				j.repaint();;
				
				
			}
		});
		t.start();
		
		
		this.setVisible(true);
	}
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paint(g);
		drawBackground(g);
	}
	
	
	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(backgroundImageLoc));
		return i.getImage();
	}
	
	public void drawBackground(Graphics g) {
		Graphics2D graphics = (Graphics2D)g;
		graphics.drawImage(getBackgroundImage(),0,0,Window.WIDTH, Window.HEIGHT,null);
	}

}
