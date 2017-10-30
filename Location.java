//basic position class, takes two variables and returns the ordered pair
public class Location{

	private int x;
	private int y;
	
	public Location(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	//X position for map where each square is 100 by 100
	public int getGridX(){
		return x*100-100;
	}
	
	//Y position for map where each square is 100 by 100
	public int getGridY(){
		return y*100-100;
	}
	
	//Methods that alter this location
	
	public void move(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public void shift(int x, int y){
		this.x=this.x+x;
		this.y=this.y+y;
	}

}