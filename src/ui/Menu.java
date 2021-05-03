package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import model.ListManagement;

public class Menu {
	static BufferedReader br;
	static final String principalMenu = "WELCOME TO SNAKES AND LADDERS GAME \n1:PLAY \n2:TABLE OF POSITIONS \n3:EXIT";
	private ListManagement listM;
	
	
	public void showMenu() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(principalMenu);
		int option = Integer.parseInt(br.readLine());
		switch (option) {
		case 1:
			creationTable();
		//	playOption(countSnakes, countLadders);
			break;
		case 2:
			System.out.println();
			System.out.println("PLAYER|DICE QUANTITY");
		//	table.inOrder(table.getRoot());
		//	table.restartPositions();
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
		

		if (Integer.parseInt(data[1]) <= 26 && Integer.parseInt(data[2]) <= iteration && Integer.parseInt(data[3]) <= iteration) {
			createList(iteration);
			assignPlayers(iteration, data[5]);
			putLaddersDown(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[3]), 49);
			putLaddersUp(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[3]), 49);
			putSnakesDown(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), 65);
			putSnakesUp(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), 65);
			createUser(data[5], Integer.parseInt(data[4])-1);
			playGame();
			listM.show();
			continuePlaying(0, Integer.parseInt(data[4]));
			
			
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
			int part_1= total/2;
			int posDown = 2+random.nextInt(part_1+1);
		
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
			int part_1= (total/2)+1;
			int posUp =random.nextInt(total-part_1+1)+part_1;
			System.out.println(posUp);
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
			int part_1= total/2;
			int posDown = 2+random.nextInt(part_1+1);
		
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
			int total = rows*columns;
			int part_1= (total/2)+1;
			int posUp = random.nextInt(total-part_1+1)+part_1;
			
			System.out.println(posUp);
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
	

	public void playGame() throws IOException {
		String starting = br.readLine();
		if(starting.isEmpty()) {
		}
	}
	
	public void continuePlaying(int turn, int amountPlayers) throws IOException {
		if(turn<amountPlayers) {
			String next =br.readLine();
			if(next.isEmpty()) {
				char player = listM.searchUser(turn).getPlayer();		
				Random rdm = new Random();
				int dice = 1+rdm.nextInt(6);
				System.out.println(" El jugador "+player+" ha lanzado el dado y obtuvo el puntaje "+dice);
				listM.countMovements(turn);
				if(listM.movePlayers(player, turn, dice)) {
					System.out.println("¡El jugador " +player+" ha ganado!" );
					String nickname = br.readLine();
					listM.addPosition(nickname, listM.totalMovements(listM.searchUser(turn))); // CALLING THE ADD OF THE BINARY TREE
					showMenu();
				}else {
					listM.show();
					continuePlaying(turn=turn+1, amountPlayers);
				}
			}
		}else {
			continuePlaying(0, amountPlayers);
		}
	}
}


