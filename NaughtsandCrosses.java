
public class NaughtsandCrosses {
	static Board board1 = new Board();
	
 public static void main(String[] args){
 
  menu menu1 = new menu();
  menu1.printTitleMenu();
  menu1.selectMode();
  board1.setup();
  
  if(menu1.getCurrentMode() == 1){
	//player vs player, main game phase
	 	loop:{
		 while(true){				
			 board1.playerPick(1);
			 if(board1.checkWin() != 0){break loop;}
			 board1.playerPick(2);
			 if(board1.checkWin() != 0){break loop;}
	 	 }
	 	}
  } else if(menu1.getCurrentMode() == 2){
	  //easy AI
	  easyAI easy = new easyAI();
  }
  	
 	
 
 
 
 	
 
 //Results
 board1.printResults();
 	
 } 
 
 
}


 
 
