//Map class, makes the part of the map you are currently on.

import java.util.Random;
import java.util.ArrayList;

public class Map{
	private int height= 5; //how tall the map is, change later to be random
	private int width= 5; //how wide the map is, change later to be random 
	private int numMon; //how many monsters spawn on this map
	private boolean objective= true; //this will change later but for now just one screen I think, so objective must be on this screen
	private ArrayList<Monster> m = new ArrayList<Monster>();
	private Hero h;
	
	//Constructors
	
	public Map(){
		Random rand = new Random();
		this.numMon= rand.nextInt(10)+1;
		int mon=0;
		h = new Hero(3,5);
		m.add(h);
		while(mon<numMon){
			for (int i=0; i<height; i++){
				for (int j=0; j<width; j++){
					if ((rand.nextInt(100)%3==0) && (i!=3 && j!=5)){
						m.add(new Monster(i,j));
						mon++;
					}
				}
			}
		}
		
	}
	
	public Map(int height, int width){
		this.height=height;
		this.width=width;
		Random rand = new Random();
		this.numMon= rand.nextInt(10)+1;
		int mon=0;
		h = new Hero(3,5);
		m.add(h);
		while(mon<numMon){
			for (int i=0; i<height; i++){
				for (int j=0; j<width; j++){
					if (rand.nextInt(100)%3==0 && (i!=3 && j!=5)){
						m.add(new Monster(i,j));
						mon++;
					}
				}
			}
		}
		
	}
	
	//Values
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public ArrayList<Monster> getMonsters(){
		return m;
	}
	
	public Hero getHero(){
		return h;
	}
	
}