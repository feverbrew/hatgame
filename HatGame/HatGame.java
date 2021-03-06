import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

enum GameState{
	MENU, MAP, BATTLE, GAMEOVER
}

public class HatGame extends JComponent implements ActionListener, KeyListener
{
//initializing the map, this should be moved to a method of hatgame that creates a new map so that we can have multiple maps in a game (for later)
  public Map map1 = new Map();

//initializing gamestate
  GameState state = GameState.MAP;
  Font font0 = new Font("arial",Font.BOLD,15);
  
  //Menu initializing
  Menu Attack = new Menu("Attack");
  Menu Defend = new Menu("Defend",Attack);
  Menu Items = new Menu("Items",Defend);
  Menu hat = new Menu("HAT",Items);
  Menu current = Attack;
  //current monster fighting
  Monster mon;
  //hero
  Monster hero = this.map1.getMonsters().get(0);
  
  //Setting up game things like timer, window, and keylistener
  public static void main(String[] args)
  {
    JFrame f = new JFrame("HatRPG");
    HatGame game = new HatGame();
    f.add(game);
    f.pack();
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    
    Timer t = new Timer(100, game);
    t.start();
    
    f.addKeyListener(game);
  }
  
  //window dimension, should make this variable at some point so user can change screen size (full screen, windowed, etc). If variable, need to relate all graphics to these variables I think.
  public Dimension getPreferredSize()
  {
    return new Dimension(500, 500);
  }
  
  //Graphics, drawing stuff on screen
  protected void paintComponent(Graphics g)
  {
	//Switches what is displayed based on gamestate
  	switch(state){
  	case MAP:
		//background is green
		g.setColor(new Color(0, 175, 0));
		g.fillRect(0, 0, 500, 500);
		
		//draws all monsters as black (index starts at 1 because hero is index 0)
		g.setColor(new Color(0, 0, 0));
		for (int i = 1; i < this.map1.getMonsters().size(); i++) {
			if (this.map1.getMonsters().get(i).isAlive())
				g.fillRect(this.map1.getMonsters().get(i).getLoc().getGridX(), this.map1.getMonsters().get(i).getLoc().getGridY(), 100, 100);
		}
		//draws hero in blue
		g.setColor(new Color(0, 0, 100));
		g.fillRect(this.map1.getMonsters().get(0).getLoc().getGridX(), this.map1.getMonsters().get(0).getLoc().getGridY(), 100, 100);
		break;
		
	case BATTLE:
		//background is white
		g.setColor(new Color(255,255,255));
		g.fillRect(0,0,500,500);
		
		//setting font and color for text
		//Font font0 = new Font("arial",Font.BOLD,15);
		g.setFont(font0);
		g.setColor(Color.black);
		
		//always present on battle screen, health and mana
		g.drawString("Health:",25,400);
		g.drawString("Mana",25,450);
		g.drawString(this.map1.getMonsters().get(0).getchealth()+"/"+this.map1.getMonsters().get(0).getHealth(),100,400);
		
		//need to fix this, not loading image...
		BufferedImage enemy1 = null;
		try {
		enemy1 = ImageIO.read(new File("/home/feverbrew/Documents/Projects/HatGame/Images/cowboyswordsman.png"));
		} catch (IOException e) {
			}
		g.drawImage(enemy1, 350, 25, null);
		
		g.drawString(mon.getchealth() + "/" + mon.getHealth(),100,100);
		
		
		//first menu, items and attack lead to second menu, others just do action
		
		current.paintMenu(g,300,375,75,25,font0);
		break;
		
	case GAMEOVER:
		g.setColor(new Color(0,0,0));
		g.fillRect(0,0,500,500);
		g.setColor(new Color(255,255,255));
		g.setFont(font0);
		g.drawString("Game Over",200,200);
		break;
		
	}
  }
  
  //triggers on action, problematic (I think) because it checks when the action happens and not after things are updated.
  public void actionPerformed(ActionEvent e)
  {
  	switch(state){
  	case MAP:
  		
		break;
		
	case BATTLE:
		if (!hero.isAlive())
			state = GameState.GAMEOVER;
			repaint();
		break;
		
	}
  
  }
  
  //triggers on key being pressed
  public void keyPressed(KeyEvent e)
  {
  	char key = e.getKeyChar();
  	switch(state){
  	case MAP:
		
		//move hero by pressing w,a,s,d
		if ((key == 'w') && (hero.getLoc().getY() != 1)) {
		  ((Monster)hero).move(0, -1);
		}
		if ((key == 'a') && (hero.getLoc().getX() != 1)) {
		  ((Monster)hero).move(-1, 0);
		}
		if ((key == 's') && (hero.getLoc().getY() != 5)) {
		  ((Monster)hero).move(0, 1);
		}
		if ((key == 'd') && (hero.getLoc().getX() != 5)) {
		  ((Monster)hero).move(1, 0);
		}
		repaint();
		
		//checking if hero occupies the same spot as monster, if so switches to battle gamestate
		for (int i = 1; i < this.map1.getMonsters().size(); i++) {
			if (hero.getLoc().equals(this.map1.getMonsters().get(i).getLoc()) && this.map1.getMonsters().get(i).isAlive()) {
				//probably not implementing special moves right now, this is just going to be busy work and optimizing mostly.
				/*
				Menu Attack1 = new Menu(hero.getAttacks()[0]);
				Menu Attack2 = new Menu((hero.getAttacks()[1]),Attack1);
				Menu Attack3 = new Menu((hero.getAttacks()[2]),Attack2);
				Menu Attack4 = new Menu((hero.getAttacks()[3]),Attack3);
				Attack1.superMenu(Attack);
				*/
				
				mon=this.map1.getMonsters().get(i);
				state = GameState.BATTLE;
			}
		}
		
		break;
	case BATTLE:
		//navigate through menu with w,a,s,d, select with x
		if ((key == 'w') && (current.goUp()!=null)) {
		  this.current=current.goUp();
		}
		if ((key == 'a') && (current.goLeft()!=null)) {
		  this.current=current.goLeft();
		}
		if ((key == 's') && (current.goDown()!=null)) {
		  this.current=current.goDown();
		}
		if ((key == 'd') && (current.goRight()!=null)) {
		  this.current=current.goRight();
		}
		if ((key == 'x') && (current.equals(Attack))) {
			if (hero.getSpeed()>=mon.getSpeed()){
				mon.takeDamage(hero.getAttack());
				if (!mon.isAlive())
					state = GameState.MAP;
				else 
					hero.takeDamage(mon.getAttack());
			} else{
				hero.takeDamage(mon.getAttack());
				mon.takeDamage(hero.getAttack());
				if (!mon.isAlive())
					state = GameState.MAP;
			}
				
		}
		if ((key == 'x') && (current.equals(Defend))) {
			hero.takeDamage(mon.getAttack()/hero.getDefense());
		}
		if ((key == 'x') && (current.equals(hat))) {
			//placeholder but needs to use hat ability
		}
		
		repaint();
		break;
	case GAMEOVER:
		
		break;
		
	}
  }
  
  public void keyReleased(KeyEvent e) {
  	  
  }
  
  public void keyTyped(KeyEvent e) {
  
  }
}

