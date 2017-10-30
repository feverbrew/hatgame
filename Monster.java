//Monster class, this will be the class that all enemies are made from.
//note: consider just meshing monster and hero class. no reason to separate really other than clarity for me
public class Monster{

	//variables are protected to allow the Hero extension access
	protected boolean alive = true;
	protected int health;
	protected int attack;
	protected int defense;
	protected Location l;
	
	//Constructs a monster with no location (probably never used)
	public Monster(){
		this.health=50;
		this.attack=1;
		this.defense=1;
	}
	
	//Constructs a monster at location (x,y)
	public Monster(int x, int y){
		this.health=50;
		this.attack=1;
		this.defense=1;
		this.l= new Location(x,y);
	}
	
	public Location getLoc(){
		return l;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getAttack(){
		return attack;
	}
	
	public int getDefense(){
		return defense;
	}
	
	public boolean isAlive(){
		return alive;
	}
	
	//when something should die, this method can be called. Need to implement deletion of dead things
	public void kill(){
		alive = false;
	}
	
	public void giveLoc(int x,int y){
		this.l= new Location(x,y);
	}
	
	//At some point should unify terminology, move calls shift method in location class, but there is also a move method in location
	public void move(int x, int y){
		this.l.shift(x,y);
	}
	
}