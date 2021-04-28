package ui;

import model.*;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

	static BufferedReader br;
	static final int PLAY = 1;
	static final int SHOW_POSITIONS = 2;
	static final int EXIT = 3;
	static int countRows = 1;
	static int countMovements = 1;
	static int countSnakes;
	static int countLadders;
	private User user;
	private UserManagement table;
	static final String principalMenu = "WELCOME TO SNAKES AND LADDERS GAME \n1:PLAY \n2:TABLE OF POSITIONS \n3:EXIT";
	private ListManagement square;
	private ListManagement temporal;

	public Menu() throws FileNotFoundException, ClassNotFoundException, IOException {
		table = new UserManagement();
	}

	public void showMenu() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		square = new ListManagement(1);
		temporal = square;
		System.out.println(principalMenu);
		int option = Integer.parseInt(br.readLine());
		switch (option) {
		case PLAY:
			creationTable();
		//	playOption(countSnakes, countLadders);
			break;
		case SHOW_POSITIONS:
			System.out.println();
			System.out.println("PLAYER|DICE QUANTITY");
		//	table.inOrder(table.getRoot());
		//	table.restartPositions();
			System.out.println();
			showMenu();
			break;

		case EXIT:
			System.out.println("THANKS FOR PLAY, SEE YOU LATER");
			break;
		default:
			System.err.println("INSERT A VALID OPTION");
			showMenu();
		}
	}

	private void creationTable() throws IOException{
		System.out.println("INSERT ROW|COLUMNS|NUMBER SNAKES|NUMBER OF LADDERS|NUMBER OF PLAYERS|NAME OF PLAYERS");
		String[] data = br.readLine().split(" ");
		int iteration = Integer.parseInt(data[0]) * Integer.parseInt(data[1]);
		if (Integer.parseInt(data[0]) > 0 && Integer.parseInt(data[1]) <= iteration) {
			createList(Integer.parseInt(data[0]), Integer.parseInt(data[1]), countRows);
		/*	putSnakes(Integer.parseInt(data[2]));
			putLadders(Integer.parseInt(data[3]));
			countSnakes = Integer.parseInt(data[2]);
			countLadders = Integer.parseInt(data[3]);  */
			int score = ((Integer.parseInt(data[0]) * Integer.parseInt(data[1])) * countMovements);
			user = new User(data[0], score, Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
			square.showContent(Integer.parseInt(data[0]), Integer.parseInt(data[1]), square.getFirstList());
		}
	}
	
	private void createList(int row, int column, int countRows) {
		if (countRows == 1) {
			square.add(countRows, column);
			createList(row, column, countRows + 1);
		} else if (countRows <= row && countRows > 1) {
			ListManagement temp = new ListManagement(countRows);
			temp.add(countRows, column);
		//	linkWithOtherList(temporal.getFirstList(), temp.getFirstList());
			temporal = temp;
			square.setLastList(temp.getFirstList());
			square.setEndLastList(temp.getEndFirstList());
			createList(row, column, countRows + 1);
		}
	}
}