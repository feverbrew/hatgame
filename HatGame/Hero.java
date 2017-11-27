//Main hero class, the is the player character
//Able to wear a hat and wield a weapon. Stats are health,  attack, armour, mp, and mana


public class Hero extends Monster{

//these stats need to be balanced, monster stats tbd though
	private int mp = 1;
	private int mana = 10;
	private Weapon w;
	private Hat h;
	private final int myhealth;

	//Constructs hero without a starting point, almost never used
	public Hero(){
		w=null;
		h=null;
		this.myhealth=100;
		this.Attacks[0]="Punch";
		this.Attacks[1]="Nada";
		this.Attacks[2]="Nada";
		this.Attacks[3]="Nada";
	}
	
	//Constructs hero with location (x,y)
	public Hero(int x,int y){
		w=null;
		h=null;
		this.l = new Location(x,y);
		this.myhealth=100;
		this.chealth=100;
		this.attack=2;
		this.defense=1;
		this.Attacks[0]="Punch";
		this.Attacks[1]="Nada";
		this.Attacks[2]="Nada";
		this.Attacks[3]="Nada";
	}
		

	@Override
	public int getHealth(){
		return myhealth;
	}
	@Override	
	public int getAttack(){
		return this.attack; //+ this.w.pwr();
	}
	@Override
	public int getDefense(){
		return this.defense + this.h.amr();
	}
	
	public int mp(){
		return mp+this.h.mp();
	}
	
	public int getMana(){
		return mana;
	}
	
	public String wpnname(){
		return this.w.name();
	}
	
	public String hatname(){
		return this.h.name();
	}
	
	public void giveWeapon(Weapon w) {
		this.w = w;
	}
	
	public void giveHat(Hat h) {
		this.h = h;
	}
	
	
}

