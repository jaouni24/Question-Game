
import java.util.*;

public class Driver{
	
	static Scanner input = new Scanner(System.in);
	static final int numberOfCompeters = 2;
	static final int numberOfQuestions = 4;
	static double [][]dataTable = new double[4][];
	static char []questions = new char[9];
	
	public static void main(String[] args) {
		double avarageHight = 0;
		
		defenition();  //define what the game would be like
		
		dataTable = Player.fillDataTable();  //fill the numbers that will be used in asking questions 
		questions = Player.fillQuestions();  //fill the keys of the questions 
		
		System.out.println("Please enter number of Players: ");
		int N = input.nextInt();
		
		System.out.println("Please enter number of teams: ");
		int K = input.nextInt();
		
		Player [][]game = new Player[K][];  

		//establish ragged array that will each team contain random number of players 
		game = findNumberOfPlayersInEachTeam(game,N,K);   
		
		//create instance of each each cell in the ragged array
		defineArray(game);
		
		//fill array with players data
		//FillArray(game);
		
		//find average height for all players 
		avarageHight = avgHight(game,N);
		
		System.out.printf("\nThe avarage hieght for all players: %.2f\n",avarageHight);
		
		//starting the game 
		startTheGame(game);
		
	}
	
	public static void startTheGame(Player [][]game) {
		Player []competer = new Player[numberOfCompeters]; //array of type player that will contain the two competers 
		int []result = new int[numberOfCompeters]; //array that will hold the result of each player 
		char stop = ' ';
		
		//create instance for each cell in the array
		for (int i = 0; i < competer.length; i++) {
			competer[i] = new Player();
		}
		
		//display the game until the user enters 's' of 'S'
		while(true) {
			//choose two players randomly from the table
			System.out.println("\nThe two player that were chosen randomly are: ");
			competer = choosePlayer(game);
			
			System.out.println();
			
			//ask the players the questions and determine the result 
			result = askPlayer(competer);
			
			//print the players' result
			System.out.println(competer[0].getName()+"'s result is "+result[0]);
			System.out.println(competer[1].getName()+"'s result is "+result[1]);
			
			//determine which of the two competers are the winner
			if(result[0] > result[1])
				System.out.println("So "+competer[0].getName()+" is the winner.");
			else if(result[0] == result[1])
				System.out.println("So the two competers have the same result.");
			else 
				System.out.println("So "+competer[1].getName()+" is the winner.");
			
			//enter 's' or 'S' to stop the program (if wanted)
			System.out.println();
			System.out.println("Enter 's' or 'S' to stop the game, else enter any other charachter.");
			stop = input.next().charAt(0);
			if(stop == 's' || stop == 'S')
				break;
		}
		System.out.println("\nThe game ended!");
		System.out.println("Good Luck.");
	}
	
	public static int[] askPlayer(Player []competer) {
		int []result = new int[numberOfCompeters]; //array that will hold the result 
		int index;   //index for the random operation that I'm going to choose
		int counter = 0; 
		char choice; //key of the question 
		
		while(counter < 2 * numberOfQuestions) {
			if(counter == 0)
				System.out.println("The questions for Player 1:");
			else if (counter == 4)
				System.out.println("\nThe questions for Player 2:");
			index = (int)(Math.random() * questions.length); //index of the random operation 
			choice = questions[index];  //character that is the key of the question that will be asked 
			result[counter/4] = swtichStatement(result[counter/4],choice);  
			counter++;
		}
		
		return result;
	}
	
	//this will ask player different mathematical questions according to the char key 
	public static int swtichStatement(int result,char choice) {
		switch (choice) {
			case 'm': {
				int index1,index2; //column index of the data in the data table
				int x,y; 
				int mulResult;
				
				//choose two random indexes from the data table 
				index1 = (int)(Math.random() * questions.length);
				index2 = (int)(Math.random() * questions.length); 
				
				//save the data in a variable 
				x = (int)dataTable[0][index1];
				y = (int)dataTable[0][index2];
							
				System.out.println("What is the multiplication between "+x+" and "+y+"?");
				mulResult = input.nextInt();
				
				//compare user's result with the real result and increment result if they are equal 
				if(mulResult == (x * y))
					result++;
				break;
			}
			
			case 'd':{
				int index1,index2; //column index of the data in the data table
				int x,y; 
				int divResult;
				
				//choose two random indexes from the data table
				index1 = (int)(Math.random() * questions.length);
				index2 = (int)(Math.random() * questions.length); 
				
				//save the data in a variable
				x = (int)dataTable[0][index1];
				y = (int)dataTable[0][index2];
							
				System.out.println("What is the division between "+x+" and "+y+" ("+x+" div "+y+")?");
				divResult = input.nextInt();
				
				//compare user's result with the real result and increment result if they are equal 
				if(divResult == (x / y))
					result++;
				break;
			}
			
			case 'o':{
				int index1,index2; //column index of the data in the data table
				int x,y; 
				int modResult;
				
				//choose two random indexes from the data table
				index1 = (int)(Math.random() * questions.length);
				index2 = (int)(Math.random() * questions.length); 
				
				//save the data in a variable
				x = (int)dataTable[0][index1];
				y = (int)dataTable[0][index2];
							
				System.out.println("What is the modulus between "+x+" and "+y+" ("+x+" mod "+y+")?");
				modResult = input.nextInt();
				
				//compare user's result with the real result and increment result if they are equal
				if(modResult == (x % y))
					result++;
				break;
			}
			
			case 'p':{
				int index1,index2; //column index of the data in the data table
				int x,y; 
				int powResult;
				
				//choose two random indexes from the data table
				index1 = (int)(Math.random() * questions.length);
				index2 = (int)(Math.random() * questions.length); 
				
				//save the data in a variable
				x = (int)dataTable[0][index1];
				y = (int)dataTable[0][index2];
							
				System.out.println("What is "+x+" to power "+y+" ("+x+" pow "+y+")?");
				powResult = input.nextInt();
				
				//compare user's result with the real result and increment result if they are equal
				if(powResult == ((int)Math.pow(x,y)))
					result++;
				break;
			}
			
			case 'i':{
				int index1; //column index of the data in the data table
				double x; 
				double ceilResult;
				
				//choose random index from the data table
				index1 = (int)(Math.random() * questions.length);
				
				//save the data in a variable
				x = dataTable[1][index1];
							
				System.out.println("What is the ceil of "+x+"?");
				ceilResult = input.nextInt();
				
				//compare user's result with the real result and increment result if they are equal
				if((int)ceilResult == (int)(Math.ceil(x)))
					result++;
				break;
			}
			
			case 'f':{
				int index1; //column index of the data in the data table
				double x; 
				double floorResult;
				
				//choose random index from the data table
				index1 = (int)(Math.random() * questions.length);
				
				//save the data in a variable
				x = dataTable[1][index1];
							
				System.out.println("What is the floor of "+x+"?");
				floorResult = input.nextInt();
				
				//compare user's result with the real result and increment result if they are equal
				if((int)floorResult == (int)(Math.floor(x)))
					result++;
				break;
			}
			
			case 's':{
				int index1; //column index of the data in the data table
				double x; 
				double sinResult;
				
				//choose random index from the data table
				index1 = (int)(Math.random() * questions.length);
				
				//save the data in a variable
				x = dataTable[2][index1];
							
				System.out.println("What is the sin of "+(int)x+" (#.##)?");
				sinResult = input.nextDouble();
				
				//estimate the result to 0.2f
				x = Math.toRadians(x);
				x = Math.sin(x);
				x = x * 100;
				x = Math.rint(x);
				
				//compare user's result with the real result and increment result if they are equal
				if(sinResult == (x/100))
					result++;
				break;
			}
			
			case 'c':{
				int index1; //column index of the data in the data table
				double x; 
				double cosResult;
				
				//choose random index from the data table
				index1 = (int)(Math.random() * questions.length);
				
				//save the data in a variable
				x = dataTable[2][index1];
							
				System.out.println("What is the cos of "+(int)x+" (#.##)?");
				cosResult = input.nextDouble();
				
				//estimate the result to 0.2f
				x = Math.toRadians(x);
				x = Math.cos(x);
				x = x * 100;
				x = Math.rint(x);
				
				//compare user's result with the real result and increment result if they are equal
				if(cosResult == (x / 100))
					result++;
				break;
			}
			
			case 'l':{
				int index1; //column index of the data in the data table
				int x; 
				double logResult;
				
				//choose random index from the data table
				index1 = (int)(Math.random() * questions.length);
				
				//save the data in a variable
				x = (int)dataTable[3][index1];
							
				System.out.println("What is the logarithm of "+x+" to base 2?");
				logResult = input.nextInt();
				
				//compare user's result with the real result and increment result if they are equal
				if(logResult == (Math.log(x) / Math.log(2)))
					result++;
				break;
			}
			
		}
		return result;
	}
	
	public static Player[] choosePlayer(Player [][]game) {
		Player []competer = new Player[numberOfCompeters];
		
		int randomRow = 0;
		int randomColumn = 0;
		
		int randomRowCopy = 0; 
		
		//choose the first random player 
		for (int i = 0; i < game.length; i++) {
			randomRow = (int)(Math.random() * game.length);
			
			for (int j = 0; j < game.length; j++) {
				randomColumn = (int)(Math.random() * game[randomRow].length);
			}
		}
	
		competer[0] = game[randomRow][randomColumn];
		System.out.print("Player #1: #team "+(randomRow + 1)+", ");
		Player.print(competer[0]);
		
		randomRowCopy = randomRow; //copy the row number in a different variable for not to loose it's value
		
		//find the second random player
		for (int i = 0; i < game.length; i++) {
			randomRow = (int)(Math.random() * game.length);
			
			for (int j = 0; j < game.length; j++) {
				randomColumn = (int)(Math.random() * game[randomRow].length);
			}
		}
		
		//if the two players are from the same team 
		//we chose another player 
		while(randomRow == randomRowCopy) {
				
			for (int i = 0; i < game.length; i++) {
				randomRow = (int)(Math.random() * game.length);
					
				for (int j = 0; j < game.length; j++) {
					randomColumn = (int)(Math.random() * game[randomRow].length);
				}
			}
		}
		
		competer[1] = game[randomRow][randomColumn];
		System.out.print("Player #2: #team "+(randomRow + 1)+", ");
		Player.print(competer[1]);
		
		return competer;
	}
	
	//find average height 
	public static double avgHight(Player [][]game,int numberOfPlayers) {
		double sum = 0;
		for (int i = 0; i < game.length; i++)
			for (int j = 0; j < game[i].length; j++) 
				sum += game[i][j].getHight();
		return sum / numberOfPlayers;
	}
	
	//make instance from each cell in the array of type player 
	public static void defineArray(Player [][]game) {
		for (int i = 0; i < game.length; i++) 
			for (int j = 0; j < game[i].length; j++) 
				game[i][j] = new Player();
	}
	
	//fill the array with data 
	public static void FillArray(Player [][]game) {
		System.out.println();
		for (int i = 0; i < game.length; i++) {
			System.out.println("#Team "+(i+1));
			for (int j = 0; j < game[i].length; j++) 
				game[i][j].fillArrayWithData(game,i,j);
			System.out.println();
		}
	}
	
	public static Player[][] findNumberOfPlayersInEachTeam(Player [][]game,int N,int K){
		int min = 0;
		int max = 0;
		int random = 0;
		int sum = 0;
		int Ncopy = N;
			
		for (int i = 0;N > 0 && i < game.length ; i++) {
			min = (int)(N / K) - 1; //minimum value
			max = (int)(N / K) + 1;  //maximum value 
	
			random = (int)(min + Math.random() * max);  //choose random number between the above range
			
			if(K == 1) //if we reached the last team, we put the remain players in it
				random = Ncopy - sum;
			
			N = N - random; //reset for number of players
			K--; ////reset for number of teams 
			sum = sum + random;
			
			game[i] = new Player[random]; //create a ragged array
			
			System.out.println("number of players in team "+(i+1)+" is "+random);
		}
			
		return game;
	}
	
	public static void defenition() {
		System.out.println("Welocme to Hiba Jaouni's Game");
		System.out.println();
		System.out.println("The concepet of my game is that two players are going to compete aginst each other; ");
		System.out.println("both players will be chosen randomly but they must be from differant teams. \nEach Player will "
				+ "be asked four mathmatical questions randomly and the one who answers "
				+ "\nmore correct question will win that round, note that if both had the same result, \nthey will "
				+ "get the same grade so they are both winners.");
		System.out.println("\nLet's start with the game.");
		System.out.println();
	}
	
}