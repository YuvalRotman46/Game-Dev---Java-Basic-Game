package game.guid_by_threads;

public class Location {
	int x;
	int y;

	public Location(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	
	
	
	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+x+","+y+"]";
	}

}
