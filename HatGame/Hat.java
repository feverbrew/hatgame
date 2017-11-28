//Hat class, the version of wearable armor in this game. Hats can also add magic power.
// has hat name as well.
//also special ability

public class Hat{

	private String name;
	private int armour;
	private int mp;
	private Ability abil;
	
	public Hat(String name, int armour, int mp, Ability abil){
		this.name = name;
		this.armour = armour;
		this.mp = mp;
		this.abil = abil;
	}
	
	public String name(){
		return name;
	}
	
	public int amr(){
		return armour;
	}
	
	public int mp(){
		return mp;
	}


}
