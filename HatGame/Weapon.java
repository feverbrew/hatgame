//Weapon class, describes the damage a weapon adds as well as any special abilities it conveys
//also contains name of the weapon

public class Weapon{
	
	private String name;
	private int power;
	private String[] abilities;
	
	public Weapon(String name, int power){
		this.name = name;
		this.power = power;
	}
	
	public String name(){
		return name;
	}
	
	public int pwr(){
		return power;
	}

	//need to implement some system that handle attributes, not sure if I can do extends here but maybe that would do it?
	public Ability getAbilities(){
		return null;
	}
	
}
