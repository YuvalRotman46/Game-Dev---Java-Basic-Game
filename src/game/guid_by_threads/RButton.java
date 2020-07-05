package game.guid_by_threads;

import java.awt.*;
import javax.swing.*;

public class RButton extends GameObject {
	
	private RButtonsType type;
	private double sizeMul;
	
	private static int HEIGHT = 156;
	private static int WIDTH = 252;
	
	public RButton(int x, int y,RButtonsType type) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.type = type;
		sizeMul = 1;
		if(RButtonsType.RESTART == type)
			sizeMul = 0.6;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		((Graphics2D)g).drawImage(getImage(),super.lacation.x,super.lacation.y,(int)(WIDTH*sizeMul),(int)(HEIGHT*sizeMul),null);
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		if(type == RButtonsType.START) return new ImageIcon(getClass().getResource(ButtonsImageLoc.START_LOC)).getImage();
		
		if(type == RButtonsType.RESTART) return new ImageIcon(getClass().getResource(ButtonsImageLoc.RESTART_LOC)).getImage();
		
		if(type == RButtonsType.LOG_IN) return new ImageIcon(getClass().getResource(ButtonsImageLoc.LOG_IN_LOC)).getImage();
		
		if(type == RButtonsType.RETRAY) return new ImageIcon(getClass().getResource(ButtonsImageLoc.RESTART_LOC)).getImage();
		
		return null;
	}

	public RButtonsType getType() {
		return type;
	}
	
	public void onClick(boolean isInSystem) {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sizeMul += 0.03 ;
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sizeMul -= 0.03;
			}
		}); t.start();
		
		if(type == RButtonsType.START) {
			System.out.println("start button");
			if(isInSystem == false)
			{
				JOptionPane.showMessageDialog(null, "Please sign in...");
			}else {
				
			}
		}else if(type == RButtonsType.RESTART) {
			;
		}else if(type == RButtonsType.LOG_IN) {
			SignInPanel sip = new SignInPanel();
			;
		}else if(type == RButtonsType.RETRAY) {
			;
		}
		
		System.out.println("click");
		
	}
	
	public boolean isClicked(int x, int y) {
		if(between(super.lacation.x, super.lacation.x+WIDTH, x) && between(super.lacation.y, super.lacation.y+HEIGHT, y))
			return true;
		return false;
	}
	
	public boolean between(int min, int max, int value)
	{
		return (value<=max)&&(value>=min);
	}

}
