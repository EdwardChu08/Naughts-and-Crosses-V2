import java.util.*;

class Board{

//initial variables
	ArrayList<String> board = new ArrayList<String>();
	ArrayList<Integer> pickedNums = new ArrayList<Integer>();
	private int turn = 0;
	Scanner in = new Scanner(System.in);
 
 //setup board
 void setup(){
	 for(int i = 1; i < 10; i++){
		 board.add(String.valueOf(i));
	}
 }
 
 //print out the current state of the board
 void printBoard(){
	 System.out.println(" ");
	 System.out.println("-----------");
	 System.out.println(" ");
	 System.out.println("Pick a spot!");
	 for(int j = 0; j < 7; j = j+3){
		 System.out.println(board.get(j)+" "+board.get(j+1)+" "+board.get(j+2));
	}
 }
 
 //Allows a player to pick a spot on the board
 void playerPick(int player){
	 printBoard();
	 int pickedNum = 0;
	
	//Input validation
	while(pickedNum < 1 || pickedNum > 9 ||pickedNums.contains(pickedNum)){
		try{
			System.out.print("Player "+player+": ");
			pickedNum = in.nextInt();
			if(pickedNums.contains(pickedNum)){
				System.out.println("That spot is already chosen!");
				
			}
			if(pickedNum < 1 || pickedNum > 9){
				System.out.println("Number is outside range!");
			}
		}
		catch(Exception e){
			System.out.println("This is not a valid input!");
			in.next();
		}		
	}
		
	pickedNums.add(pickedNum);	 
	
	//Insert pick into board state
	if(player == 1){
		board.set(pickedNum-1, "O"); 	
	} else if(player == 2){
		board.set(pickedNum-1, "X");		
	}
	
  turn++;
 }
 
 //Check if anyone has won the game
 int checkWin(){
	 int winPerson = 0;
	 String check;
	 
	 //check horizontal
	 for(int i = 0; i < 7; i = i+3){
		check = board.get(i)+board.get(i+1)+board.get(i+2);
		if(Objects.equals(check, "OOO")){
			winPerson = 1;
			}
		else if(Objects.equals(check, "XXX")){
			winPerson = 2;
			}
	}
	 
	 //check vertical
	 for(int i = 0; i < 3; i++){
		 check = board.get(i)+board.get(i+3)+board.get(i+6);
		 if(Objects.equals(check, "OOO")){
			 winPerson = 1;
			 }
		 else if(Objects.equals(check, "XXX")){
			 winPerson = 2;
			 }
	}
	 
	 //check diagonal
	 check = board.get(0)+board.get(4)+board.get(8); 
	 if(Objects.equals(check, "OOO")){
		 winPerson = 1;
		 }
	 else if(Objects.equals(check, "XXX")){
		 winPerson = 2;
		 }
	 
	 check = board.get(2)+board.get(4)+board.get(6);	 
	 if(Objects.equals(check, "OOO")){
		 winPerson = 1;
		 }
	 else if(Objects.equals(check, "XXX")){
		 winPerson = 2;
		 }
	 
	 //check if game is draw
	 if(turn > 8){
		 winPerson = 3;
	 }
	
	return winPerson; 
  }
 

 //Prints results to console
 void printResults(){
	 switch(checkWin()){
	 	case 1: printBoard(); System.out.println("Player 1 wins!");
	 		break;
	 	case 2: printBoard(); System.out.println("Player 2 wins!");
	 		break;
	 	default: printBoard(); System.out.println("It's a draw!");
	 }
 }
 
 ArrayList<String> getBoardState(){
	return board;	 
 }
 
 ArrayList<Integer> getTakenSpots(){
	Collections.sort(pickedNums);
	return pickedNums;	 
 }
 
 
 	 	 
}