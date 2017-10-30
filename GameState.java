
public class GameState{
	public enum GameState{
  	  MENU, MAP, BATTLE	
  	}
  	
  	public static GameState getState(){
  		return GameState;
  	}
  	
  	public static void changeState(GameState state){
  		GameState=state;
  	}
}