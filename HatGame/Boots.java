//Boot class, another piece of clothing the hero can wear. Provides speed (and maybe abilities later)

public class Boots{
	
	private String name;
	private int speed;
	private Ability abil;
	
	public Boots(String name, int speed, Ability abil){
		this.name = name;
		this.speed = speed;
		this.abil = abil;
	}
	
	public int spd(){
		return speed;
	}
	
	public String name(){
		return name;
	}



}
