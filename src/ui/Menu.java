package ui;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import model.ListManagement;
import model.UserManagement;

public class Menu {
	static BufferedReader br;
	static final String principalMenu = "WELCOME TO SNAKES AND LADDERS GAME \n1:PLAY \n2:TABLE OF POSITIONS \n3:EXIT";
	private ListManagement listM;
	private UserManagement table;
	
	public Menu() throws FileNotFoundException, ClassNotFoundException, IOException {
		table = new UserManagement();
	}
	
	public void showMenu() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(principalMenu);
		int option = Integer.parseInt(br.readLine());
		switch (option) {
		case 1:
			creationTable();
			break;
		case 2:
			System.out.println();
			System.out.println("PLAYER|DI");
			table.inOrder(table.getRoot());
			table.restartPositions();
			System.out.println();
			showMenu();
			break;

		case 3:
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
		listM = new ListManagement();
		int snakeAndLadders = (Integer.parseInt(data[2])*2)+(Integer.parseInt(data[3])*2);
		
		if(snakeAndLadders<iteration) {
			if (Integer.parseInt(data[1]) <= 26 && Integer.parseInt(data[2]) <= iteration && Integer.parseInt(data[3]) <= iteration) {
				createList(iteration);
				assignPlayers(iteration, data[5]);
				putLaddersDown(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[3]), 49);
				putLaddersUp(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[3]), 49);
				putSnakesDown(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), 65);
				putSnakesUp(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), 65);
				createUser(data[5], Integer.parseInt(data[4])-1);
				playGame(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
				continuePlaying(0, Integer.parseInt(data[4]), Integer.parseInt(data[0]), Integer.parseInt(data[1]), 
					Integer.parseInt(data[2]), Integer.parseInt(data[3]), false);
			

			}
		}else {
			System.out.println("The amount of the snakes and ladders cant be equal or greater to the total amount of cells. \n");
			creationTable();
		}
	}
	
	private void createList(int iteration) {
		if(iteration>= 1) {	
			listM.addList(iteration);
			iteration=iteration-1;
			createList(iteration);
		}
	}
	
	private void assignPlayers(int i, String players) {
		listM.assignSpaces(i);
		listM.assignPlayer(players);
	}
	
	private void putLaddersDown(int rows, int columns, int ladders, int type) {
		
		if(ladders>0) {
			Random random = new Random();
			int total = rows*columns;
			int part_1= (total/2)-1;
			int posDown = 2+random.nextInt(part_1);
		
			if(listM.checkLadder(listM.searchList(posDown))) {
				char ladder_down = (char)(type);
				listM.putLadder(ladder_down, listM.searchList(posDown));
			
				putLaddersDown(rows, columns, ladders=ladders-1, type=type+1);
			}else {
				putLaddersDown(rows, columns, ladders, type);
			}		
		}
	}
	
	
	private void putLaddersUp(int rows, int columns, int ladders, int type) {
		
		if(ladders>0) {
			Random random = new Random();
			int total = rows*columns;
			int part_1= (total/2)+2;
			int posUp =random.nextInt(total-part_1+1)+part_1;
			
			if(listM.checkLadder(listM.searchList(posUp))) {
				char ladder_up = (char)(type);
				listM.putLadder(ladder_up, listM.searchList(posUp));
				
				putLaddersUp(rows, columns, ladders=ladders-1, type=type+1);
			}else {
				putLaddersUp(rows, columns, ladders, type);
			}
		}
	}
	
	private void putSnakesDown(int rows, int columns, int snakes, int type) {
		
		if(snakes>0) {
			Random random = new Random();
			int total = rows*columns;
			int part_1= (total/2)-1;
			int posDown = 2+random.nextInt(part_1);
		
			if(listM.checkLadder(listM.searchList(posDown)) && listM.checkSnake(listM.searchList(posDown))) {
				char snake_down = (char)(type);
				listM.putSnake(snake_down, listM.searchList(posDown));
				
				putSnakesDown(rows, columns, snakes=snakes-1, type=type+1);
			}else {
				putSnakesDown(rows, columns, snakes, type);
			}
		}
	}
	
	private void putSnakesUp(int rows, int columns, int snakes, int type) {
		
		if(snakes>0) {
			Random random = new Random();
			int total = (rows*columns)-1;
			int part_1= (total/2)+2;
			int posUp = random.nextInt(total-part_1+1)+part_1;
			
			
			if(listM.checkLadder(listM.searchList(posUp)) && listM.checkSnake(listM.searchList(posUp))) {
				char snake_down = (char)(type);
				listM.putSnake(snake_down, listM.searchList(posUp));
				putSnakesUp(rows, columns, snakes=snakes-1, type=type+1);
			}else {
				putSnakesUp(rows, columns, snakes, type);
			}	
		}
	}
	
	private void createUser(String users, int amountUser) {
		if(amountUser>=0){
			listM.addPlayer(users.charAt(amountUser), amountUser);
			amountUser=amountUser-1;
			createUser(users, amountUser);
		}
	}
	

	public void playGame(int row, int column) throws IOException {
		String starting = br.readLine();
		if(starting.isEmpty()) {
			System.out.println(listM.showContentPrincipal(row, column));
		}
	}
	
	public void continuePlaying(int turn, int amountPlayers, int row, int column, int snake, int ladders, boolean simul) throws IOException {
		
		if(!simul) {
			if(turn<amountPlayers) {
				String next =br.readLine();
				if(next.isEmpty()) {
					char player = listM.searchUser(turn).getPlayer();		
					Random rdm = new Random();
					int dice = 1+rdm.nextInt(6);
					System.out.println("Player "+player+" has a score of "+dice);
					listM.countMovements(turn);
					if(listM.movePlayers(player, turn, dice)) {
						System.out.println(listM.showContent(row, column));
						System.out.println("Player " +player+" has won!" );
						System.out.println("Now, put your name: ");
						String nickname = br.readLine();
					
						System.out.println(nickname+"-"+ listM.totalMovements(listM.searchUser(turn))*(row*column)+"-"+ column+"-"+ row+"-"+ snake+"-"+ ladders+"-"+ amountPlayers+"-"+ player);
					
					
						table.addUser(nickname, listM.totalMovements(listM.searchUser(turn))*(row*column), column, row, snake, ladders, amountPlayers, player);// CALLING THE ADD OF THE BINARY TREE
						System.out.println("Player: "+nickname+"\n" +"Score: " +listM.totalMovements(listM.searchUser(turn))*(row*column)+"\n");
						showMenu();
					}else {
						System.out.println(listM.showContent(row, column));
						continuePlaying(turn=turn+1, amountPlayers, row,column, snake, ladders, simul);
					}
				}else if(next.equalsIgnoreCase("num")){
					System.out.println(listM.showContentPrincipal(row, column));
					continuePlaying(turn, amountPlayers, row, column, snake, ladders, simul);
				}else if(next.equalsIgnoreCase("menu")){
					showMenu();
				}else if(next.equalsIgnoreCase("simul")) {
					System.out.println("Wait 2 seconds . . .");
					simul = true;
					continuePlaying(turn, amountPlayers, row,column, snake, ladders, simul);
				}
			}else {
				continuePlaying(0, amountPlayers,row , column, snake, ladders, simul);
			}
		}else {
			if(turn<amountPlayers) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				pressEnter();
				String next =br.readLine();
				if(next.isEmpty()) {
					char player = listM.searchUser(turn).getPlayer();		
					Random rdm = new Random();
					int dice = 1+rdm.nextInt(6);
					System.out.println("Player "+player+" has a score of "+dice);
					listM.countMovements(turn);
					if(listM.movePlayers(player, turn, dice)) {
						System.out.println(listM.showContent(row, column));
						System.out.println("Player " +player+" has won!" );
						System.out.println("Now, put your name: ");
						releaseEnter();
						String nickname = br.readLine();
						table.addUser(nickname, listM.totalMovements(listM.searchUser(turn))*(row*column), column, row, snake, ladders, amountPlayers, player);// CALLING THE ADD OF THE BINARY TREE
						System.out.println("Player: "+nickname+"\n" +"Score: " +listM.totalMovements(listM.searchUser(turn))*(row*column)+"\n");
						showMenu();
					}else {
						System.out.println(listM.showContent(row, column));
						continuePlaying(turn=turn+1, amountPlayers, row,column, snake, ladders, simul);
					}
				}
			}else {
				continuePlaying(0, amountPlayers,row , column, snake, ladders, simul);
			}
		}
	}
	
	public void pressEnter() {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		} 
	}
	
	public void releaseEnter() {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		} 
	}
	
}


