
import java.util.Scanner;

public class Player {
	Scanner input = new Scanner(System.in);
	private String name;
	private int age;
	private double hight;
	
	private Player [][]game;
	
	public Player(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}
	
	public void fillArrayWithData(Player [][]game,int row,int column) {
		
			System.out.println("Please enter information for player "+(column + 1) + " in team "+(row + 1)+":");
			System.out.println("Name: ");
			name = input.next();
			game[row][column].setName(name);
			System.out.println("Age: ");
			age = input.nextInt();
			game[row][column].setAge(age);
			System.out.println("Height(cm): ");
			hight = input.nextDouble();
			game[row][column].setHight(hight);
			
			System.out.println();
	}
	
	public static void print(Player game) {
		System.out.println("Name: "+game.getName()+", Age: "+game.getAge()+", Height: "+game.getHight()+"cm");
	}
	
	public static double[][] fillDataTable() {
		double dataTable[][] = {{2,3,1,5,9,8,4,7,6},
				{1.8,2.5,-2.9,-1.5,1.3,1.4,2.9,3.6,4.5},
				{30,45,60,90,180,270,135,180,0},
				{2,4,8,16,32,64,128,256,512}};
		return dataTable;
	}
	
	public static char[] fillQuestions() {
		char questions[] = {'m','d','o','p','i','f','s','c','l'};
		return questions;
	}
	
}
