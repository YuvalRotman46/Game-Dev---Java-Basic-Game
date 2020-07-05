package game.guid_by_threads;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class StartPanel extends Game implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2325430959006291882L;
	RButton rb;
	private boolean isInSystem;
	public StartPanel() {
		super();
		rb = new RButton(13, 33, RButtonsType.LOG_IN);
		this.addMouseListener(this);
		isInSystem = false;
	}
	
	public StartPanel(boolean isInSystem) {
		super();
		rb = new RButton(13, 33, RButtonsType.LOG_IN);
		this.addMouseListener(this);
		this.isInSystem = isInSystem;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
	public boolean getIsInSystem() {
		return this.isInSystem;
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		ArrayList<RButton> myButtonsList = new ArrayList<RButton>();
		for(GameObject o : this.gameObjects) {
			if(o instanceof RButton)
				myButtonsList.add((RButton)o);
		}
		
		for(RButton rb : myButtonsList) {
			if(rb.isClicked(me.getX(), me.getY()))
				rb.onClick(isInSystem);
		}
	}

	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
