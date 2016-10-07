import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

public class NaughtsandCrosses {
 public static int turn = 0;
	
 public static void main(String[] args){
 Scanner in = new Scanner(System.in);
 int pickedNum;
 
 Board board1 = new Board();
 board1.setup();
 
 	loop:{
	 while(true){
		 board1.printBoard();
		 System.out.print("Player 1: ");
		 pickedNum = in.nextInt();
		 board1.pick(1, pickedNum);
		 turn++;
		 if(board1.checkWin() != 0||board1.ended()){break loop;}
		 board1.printBoard();
		 System.out.print("Player 2: "); 
		 pickedNum = in.nextInt();
		 board1.pick(2, pickedNum);
		 turn++;
		 if(board1.checkWin() != 0||board1.ended()){break loop;}
 	 }
 	}
 
 switch(board1.checkWin()){
 case 1: board1.printBoard(); System.out.println("Player 1 wins!");
 break;
 case 2: board1.printBoard(); System.out.println("Player 2 wins!");
 break;
 default: System.out.println("It's a draw!");
 }
 	
 } 
 
 

}

class Board{

//Set up board
 ArrayList<String> board = new ArrayList<String>();
 String check;
 int winPerson = 0;
 
 
 void setup(){
 for(int i = 1; i < 10; i++){
 board.add(String.valueOf(i));}
 }
 
 void printBoard(){
 System.out.println("Pick a spot!");
 for(int j = 0; j < 7; j = j+3){
 System.out.println(board.get(j)+" "+board.get(j+1)+" "+board.get(j+2));}
 }
 
 void pick(int player, int k){
 if(player == 1){board.set(k-1, "O"); 
 } else if(player == 2){board.set(k-1, "X");}
 }
 
 int checkWin(){
	 //check horizontal
	 for(int i = 0; i < 7; i = i+3){
		check = board.get(i)+board.get(i+1)+board.get(i+2);
		if(Objects.equals(check, "OOO")){winPerson = 1;}
		else if(Objects.equals(check, "XXX")){winPerson = 2;}
	}
	 
	 //check vertical
	 for(int i = 0; i < 3; i++){
		 check = board.get(i)+board.get(i+3)+board.get(i+6);
		 if(Objects.equals(check, "OOO")){winPerson = 1;}
		 else if(Objects.equals(check, "XXX")){winPerson = 2;}
	}
	 
	 //check diagonal
	 check = board.get(0)+board.get(4)+board.get(8);
	 if(Objects.equals(check, "OOO")){winPerson = 1;}
	 else if(Objects.equals(check, "XXX")){winPerson = 2;}
	 check = board.get(2)+board.get(4)+board.get(6);
	 if(Objects.equals(check, "OOO")){winPerson = 1;}
	 else if(Objects.equals(check, "XXX")){winPerson = 2;}
	
	 //no one wins
	return winPerson; 
  }
 
 boolean ended(){
	 if(NaughtsandCrosses.turn > 8){return true;}
	 else{return false;}
 
 }
 
 	
 	
	 
}