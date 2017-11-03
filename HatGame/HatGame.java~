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

enum GameState{
	MENU, MAP, BATTLE
}

public class HatGame extends JComponent implements ActionListener, KeyListener
{
  public Map map1 = new Map();

  GameState state = GameState.MAP;
  
  Menu Attack = new Menu("Attack");
  Menu Defend = new Menu("Defend",Attack);
  Menu Items = new Menu("Items",Defend);
  Menu Hat = new Menu("HAT",Items);
  Menu current = Attack;
  
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
  
  public Dimension getPreferredSize()
  {
    return new Dimension(500, 500);
  }
  
  protected void paintComponent(Graphics g)
  {
  	switch(state){
  	case MAP:
		g.setColor(new Color(0, 175, 0));
		g.fillRect(0, 0, 500, 500);
		
		g.setColor(new Color(0, 0, 0));
		for (int i = 1; i < this.map1.getMonsters().size(); i++) {
		  g.fillRect(this.map1.getMonsters().get(i).getLoc().getGridX(), this.map1.getMonsters().get(i).getLoc().getGridY(), 100, 100);
		}
		g.setColor(new Color(0, 0, 100));
		g.fillRect(this.map1.getMonsters().get(0).getLoc().getGridX(), this.map1.getMonsters().get(0).getLoc().getGridY(), 100, 100);
		break;
		
	case BATTLE:
		g.setColor(new Color(255,255,255));
		g.fillRect(0,0,500,500);
		
		Font font0 = new Font("arial",Font.BOLD,15);
		g.setFont(font0);
		g.setColor(Color.black);
		
		//always present on battle screen
		g.drawString("Health:",25,400);
		g.drawString("Mana",25,450);
		g.drawString(this.map1.getMonsters().get(0).getchealth()+"/"+this.map1.getMonsters().get(0).getHealth(),100,400);
		
		
		//first menu, items and attack lead to second menu, others just do action
		
		current.paintMenu(g,300,375,75,25,font0);
		
		
		/*
		g.drawString("Attack",300,400);
		g.drawString("Defend",400,400);
		g.drawString("Items",300,450);
		g.drawString("HAT",400,450);
		*/
		
	}
  }
  
  public void actionPerformed(ActionEvent e)
  {
  	/*
    for (int i = 1; i < this.map1.getMonsters().size(); i++) {
      if (this.map1.getMonsters().get(0).getLoc() == this.map1.getMonsters().get(i).getLoc()) {
      	  state = GameState.BATTLE;
      
      }
    }
    */
  }
  
  public void keyPressed(KeyEvent e)
  {
  	char key = e.getKeyChar();
  	switch(state){
  	case MAP:
		
		if ((key == 'w') && (this.map1.getMonsters().get(0).getLoc().getY() != 1)) {
		  ((Monster)this.map1.getMonsters().get(0)).move(0, -1);
		}
		if ((key == 'a') && (this.map1.getMonsters().get(0).getLoc().getX() != 1)) {
		  ((Monster)this.map1.getMonsters().get(0)).move(-1, 0);
		}
		if ((key == 's') && (this.map1.getMonsters().get(0).getLoc().getY() != 5)) {
		  ((Monster)this.map1.getMonsters().get(0)).move(0, 1);
		}
		if ((key == 'd') && (this.map1.getMonsters().get(0).getLoc().getX() != 5)) {
		  ((Monster)this.map1.getMonsters().get(0)).move(1, 0);
		}
		repaint();
		for (int i = 1; i < this.map1.getMonsters().size(); i++) {
			if (this.map1.getMonsters().get(0).getLoc().equals(this.map1.getMonsters().get(i).getLoc())) {
				state = GameState.BATTLE;
			}
		}
		break;
	case BATTLE:
		//This is gonna require a tutorial prob, need to figure out how to implement a menu with an arrow, might need arrow class...
		
		
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
		  this.current=current.goLeft();
		}
		repaint();
		break;
	  }
  }
  
  public void keyReleased(KeyEvent e) {
  	  
  }
  
  public void keyTyped(KeyEvent e) {
  
  }
}

class Panel extends JPanel {

    public Panel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(20,10);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw Text
        g.drawString("Punch",10,20);
    }  
}
