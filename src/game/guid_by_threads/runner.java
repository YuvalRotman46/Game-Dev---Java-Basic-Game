package game.guid_by_threads;

public class runner {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Game firstGamePanel = new Game();
		Window window = new Window("My Game !!",firstGamePanel);
		Thread.sleep(3500);
		window.removeGamePanel();
		Thread.sleep(500);
		Game g = new Game();
		window.addGamePanel(g);
		
	}

}
