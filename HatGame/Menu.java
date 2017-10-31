// Menu class, useable for any game needing a basic menu system
// Lucas Culley 2017
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;

public class Menu{

	private String item;
	private Menu up = null;
	private Menu down = null;
	private Menu right = null;
	private Menu left = null;
	
	public Menu(String item){
		this.item = item;
	}
	
	public Menu(String item, Menu down){
		this.item = item;
		this.down = down;
		down.addUp(this);
	}
	
	public Menu(String item, Menu down, Menu up){
		this.item = item;
		this.down = down;
		this.up = up;
	}
	
	public void subMenu(Menu right){
		this.right = right;
		right.superMenu(this);
	}
	
	public void superMenu(Menu left){
		this.left = left;
	}
	
	public void addDown(Menu down){
		this.down = down;
		down.addUp(this);
	}
	
	public void addUp(Menu up){
		this.up = up;
	}
	
	public String getItem(){
		return item;
	}
	
	public Menu goRight(){
		return this.right;
	}
	public Menu goLeft(){
		return this.left;
	}
	public Menu goUp(){
		return this.up;
	}
	public Menu goDown(){
		return this.down;
	}
	
	public void paintMenu(Graphics g, int x, int y, int width, int height, Font font){
		g.setFont(font);
		g.setColor(Color.red);
		g.drawRect(x,y,width,height);
		g.setColor(Color.black);
		g.drawString(this.item, x+10, y+20);
		Menu d=this.down;
		int h=y+height+10;
		while(d!=null){
			g.drawRect(x,h,width,height);
			g.drawString(d.getItem(), x+10, h+20);
			h+=height+10;
			d=d.goDown();
		}
		
		Menu u=this.up;
		h=y-height-10;
		while(u!=null){
			g.drawRect(x,h,width,height);
			g.drawString(u.getItem(), x+10, h+20);
			h-=(height+10);
			u=u.goUp();
		}
		
	}
}