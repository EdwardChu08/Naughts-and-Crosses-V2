import java.util.Scanner;

class menu {
	
	Scanner scanner = new Scanner(System.in);
	
	/*mode 0: mode not yet chosen
	 *mode 1: player vs player
	 *mode 2: easy mode
	 *mode 3: medium
	 *mode 4: impossible
	 */
	int mode = 0;
	
	void printTitleMenu(){
		System.out.println("OO    NAUGHTS    OO");
		System.out.println("        AND");
		System.out.println("XX    CROSSES    XX");
		promptEnterKey();
	}
	
	//Prompts enter key to continue
	void promptEnterKey(){
			System.out.println(" ");
			System.out.println("-----------");
		   System.out.println("Press \"ENTER\" to continue");	
		   System.out.println("-----------");
		   scanner.nextLine();
	}
	
	//Prompts player to select mode
	void selectMode(){
		System.out.println(" ");
		System.out.println("-----------");
		System.out.println(" ");
		while(mode < 1 || mode > 2){
			try{
				System.out.println("Type \"1\" for single player vs AI");
				System.out.println("Type \"2\" for two players");
				mode = scanner.nextInt();
				if(mode < 1 || mode > 2){
					System.out.println("Invalid input!");
				} 			
			} catch(Exception e){
				System.out.println("Invalid input!");
				scanner.next();
			}

		}
		if(mode == 1){
			mode = 0;
			while(mode < 2 || mode > 4){
			try{
				System.out.println("Type \"2\" for easy mode");
				System.out.println("Type \"3\" for medium-ish difficulty");
				System.out.println("Type \"4\" for impossibru");
				mode = scanner.nextInt();
				if(mode < 2 || mode > 4){
					System.out.println("Invalid input!");
				} 			
			} catch(Exception e){
				System.out.println("Invalid input!");
				scanner.next();
			}

			}
		} else{mode = 1;}

	}
	
	//returns current mode
	int getCurrentMode(){
		return mode;
	}

}
