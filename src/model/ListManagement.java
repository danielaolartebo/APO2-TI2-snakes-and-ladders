package model;

/**
 * 
 * @author Santiago Gutierrez // Daniela Olarte
 * ListManagement Class
 *
 */

public class ListManagement {
	
	private List start;
	private List end;
	private User first;
	private User last;
	private String table;
	private String table2;
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	/**
	 * Constructor of ListManagement class
	 * pre:
	 * pos: build a ListManagement instance
	 */
	
	public ListManagement() {
		start=null;
		end=null;
		table="";
		table2="";
	}
	
	/* ------------------------------------------------------WORKING WITH THE CELLS----------------------------------------------------------*/
	
	/**
	 * addList
	 * pre:
	 * pos: add list 
	 * @param rowXcolumns to add in matrix
	 */
	
	public void addList(int rowXcolumns) {  
		if(start==null) {
			List newList =  new List(rowXcolumns);
			start = newList;
			end = newList;
		}else {
			List newList =  new List(rowXcolumns);
			end.setNextList(newList);
			end=newList;
		}
	}
	
	/**
	 * searchList
	 * pre:
	 * pos: search in list 
	 * @param pos to search in list
	 * @return searchList
	 */
	
	public List searchList(int pos) {  
		return searchList(pos, start);
	}
	
	/**
	 * searchList
	 * pre:
	 * pos: search in list 
	 * @param pos to search in list
	 * @param temp in matrix
	 * @return searchList
	 */
	
	private List searchList(int pos, List temp) {
		if(temp.getRowXcolumn()==pos) {
			return temp;
		}else {
			temp=temp.getNextList();
			return searchList(pos, temp);
		}
	}
	
	/**
	 * assignSpaces
	 * pre:
	 * pos: i to assign in game
	 * @param i to assign
	 */
	
	public void assignSpaces(int i) {
		assignSpaces(i,start);
	}
	
	/**
	 * assignSpaces
	 * pre:
	 * pos: spaces to assign in game
	 * @param spaces to assign
	 */
	
	private void assignSpaces(int i, List temporal) {
		if(i>0) {
		temporal.setPlayers("");
		temporal=temporal.getNextList();
		assignSpaces(i=i-1,temporal);
		}
	}
	
	/**
	 * assignPlayer
	 * pre:
	 * pos: players to assign in game
	 * @param players to assign
	 */
	
	public void assignPlayer(String players) {
		end.setPlayers(players);
	}
	
	
	/* ------------------------------------------------------WORKING WITH SNAKES AND LADDERS----------------------------------------------------------*/
	
	/**
	 * checkLadder
	 * pre:
	 * pos: check ladder in matrix
	 * @param ladder to check in matrix
	 * @return boolean found
	 */
	
	public boolean checkLadder(List ladders) {
		boolean found = false;
		if(ladders.getLadders()==0) {
			found =true;
		}
		return found;
	}
	
	/**
	 * putLadder
	 * pre:
	 * pos: put ladder in matrix
	 * @param ladder to put in matrix
	 * @param pos in matrix
	 */
	
	public void putLadder(char ladder, List pos) {
		pos.setLadders(ladder);
	}
	
	/**
	 * checkSnake
	 * pre:
	 * pos: check snake in matrix
	 * @param snakes to check in matrix
	 * @return boolean found
	 */
	
	public boolean checkSnake(List snakes) {
		boolean found = false;
		if(snakes.getSnakes()==0) {
			found =true;
		}
		return found;
	}
	
	/**
	 * putSnake
	 * pre:
	 * pos: put snake in matrix
	 * @param snake to put in matrix
	 * @param pos in matrix
	 */
	
	public void putSnake(char snake, List pos) {
		pos.setSnakes(snake);
	}
	
	/**
	 * searchSnake
	 * pre:
	 * pos: search snake
	 * @param snake to search in matrix
	 * @return List searchSnake
	 */
	
	public List searchSnake(char snake) {
		return searchSnake(snake, start);
	}
	
	/**
	 * searchSnake
	 * pre:
	 * pos: search snake
	 * @param s to search in matrix
	 * @param temp in matrix
	 * @return List searchSnake
	 */
	
	private List searchSnake(char s, List temp) {
		if(temp.getSnakes()==s) {
			return temp;
		}else {
			temp=temp.getNextList();
			return searchSnake(s, temp);
		}
	}
	
	/**
	 * searchLadder
	 * pre:
	 * pos: search ladder
	 * @param ladder to search in matrix
	 * @return List searchLadder
	 */
	
	public List searchLadder(char ladder) {
		return searchLadder(ladder, start);
	}
	
	/**
	 * searchLadder
	 * pre:
	 * pos: search ladder
	 * @param l ladder to search in matrix
	 * @param temp in matrix
	 * @return List searchLadder
	 */
	
	private List searchLadder(char l, List temp) {
		if(temp.getLadders()==l) {
			return temp;
		}else {
			temp=temp.getNextList();
			return searchLadder(l, temp);
		}
	}
	
	/* ------------------------------------------------------WORKING WITH THE PARTICIPANTS/PLAYERS----------------------------------------------------------*/
	
	/**
	 * addPlayer
	 * pre:
	 * pos: add player to the game
	 * @param user to add
	 * @param order to add
	 */
	
	public void addPlayer(char user, int order) {
		if(first==null) {
			User newUser =  new User(user, order);
			first = newUser;
			last = newUser;
		}else {
			User newUser =  new User(user, order);
			last.setNextUser(newUser);
			last=newUser;
		}
	}
	
	/**
	 * Search user
	 * pre:
	 * pos: return the searched user
	 * @param pos of the user to search
	 * @return User searchUser
	 */
	
	public User searchUser(int pos) {
		return searchUser(pos, first);
	}
	
	/**
	 * searchUser
	 * pre:
	 * pos: search user
	 * @param pos of user of the game
	 * @param temp of the game
	 * @return User temp
	 */
	
	public User searchUser(int pos, User temp) {
		if(temp.getOrder()==pos) {
			return temp;
		}else {
			temp=temp.getNextUser();
			return searchUser(pos, temp);
		}
	}
	
	/**
	 * findUser
	 * pre:
	 * pos: find users
	 * @param winner of the game
	 * @return boolean win
	 */
	
	public boolean findUsers(List winner) {
		boolean win= true;
		if(winner.getPlayers()==start.getPlayers()) {
			win=false;
		}
		return win;
	}
	
	/**
	 * win
	 * pre:
	 * pos: found winner of the game
	 * @param f found winner of the game
	 * @return boolean f
	 */
	
	public boolean win(boolean f) {
		return f;
	}
	
	/**
	 * someWinner
	 * pre:
	 * pos: some winner of the game
	 * @param user of the game
	 * @return boolean found
	 */
	
	public boolean someWinner(User user) {
		boolean found=true;
		if(user!=null) {
			if(start.getPlayers()==String.valueOf(user.getPlayer())) {
				
				found=false;
			}else {
				user = user.getNextUser();
				someWinner(user);
			}
		}
		return found;
	}
	
	/**
	 * winner
	 * pre:
	 * pos: winner of the game
	 * @return String start
	 */
	
	public String winner() {
		return start.getPlayers();
	}
	
	/**
	 * samePlayer
	 * pre:
	 * pos: same player
	 * @param p in game
	 * @param same in game
	 * @return boolean found
	 */
	
	private boolean samePlayer(User p, List same) {
		boolean found = false;
		char users = 0;
		if(same.getPlayers().isEmpty()) {
		}else {
			users = same.getPlayers().charAt(0);
		}
	
		if(users==p.getPlayer()) {
				found=true;
				return found;
		}else {
			found=false;
			return found;
		}
	}
	
	/**
	 * countMovements
	 * pre:
	 * pos: turn of each user in the game
	 * @param turn in game 
	 */
	
	public void countMovements(int turn) {
		User temp = searchUser(turn);
		int amountMove = temp.getMoves()+1;
		temp.setMoves(amountMove);
	}
	
	/**
	 * totalMovements
	 * pre:
	 * pos: move snake
	 * @param p in game
	 * @return int p
	 */
	
	public int totalMovements(User p) {
		return p.getMoves();
	}
	
	/* ------------------------------------------------------MOVING THE PARTICIPANTS/PLAYERS----------------------------------------------------------*/
	
	/**
	 * movePlayers
	 * pre:
	 * pos: move snake
	 * @param p in matrix
	 * @param pos in matrix
	 * @param moves in matrix
	 * @return boolean movePlayers
	 */
	
	public boolean movePlayers(char p, int pos, int moves) {
		return movePlayers(p, pos, moves, start);
	}
	
	/**
	 * movePlayers
	 * pre:
	 * pos: move snake
	 * @param p in matrix
	 * @param pos in matrix
	 * @param moves in matrix
	 * @param temporal in matrix
	 * @return boolean temporal
	 */
	
	public boolean movePlayers(char p, int pos, int moves,List temporal) {
		User player = new User(p, pos);
		
		if(temporal.getPlayers()!="") {
			if(samePlayer(player,temporal)) {
				temporal.setPlayers(temporal.getPlayers().replace(String.valueOf(player.getPlayer()), ""));
				int currentPos = temporal.getRowXcolumn();
				int newPos = currentPos+moves;
				if(searchList(maxCells(newPos))!=start) {
					if(checkLadder(searchList(newPos))) {  //**-------------------------------PLAYER IN THE NORMAL ROAD--------------------------------------**//
						if(checkSnake(searchList(newPos))) { 
							temporal= searchList(newPos);
							if(temporal.getPlayers()!="") {	
								temporal.setPlayers(temporal.getPlayers().replace(temporal.getPlayers(), temporal.getPlayers()+String.valueOf(player.getPlayer())));
								return false;
							}else {
								temporal.setPlayers(String.valueOf(player.getPlayer()));
								return false;
							}
						}else { //**-------------------------------------PLAYER FELL ON SNAKE--------------------------------------------**//
						temporal= searchList(newPos);
						moveAnotherSnake(temporal, player);
						return false;
						}
					}else {  //**-----------------------------------PLAYER FELL ON LADDER--------------------------------------------**//
						temporal=searchList(newPos);
						
						return moveAnotherLadder(temporal, player);
					}
				}else {
					temporal = start;
					temporal.setPlayers(String.valueOf(player.getPlayer()));
					return true;
				}	
			}else {
				temporal=temporal.getNextList();
				return movePlayers(p, pos, moves,temporal);
			}
		}else {
			temporal=temporal.getNextList();
			return movePlayers(p,pos, moves,temporal);
		}
	}
	
	/**
	 * moveAnotherSnake
	 * pre:
	 * pos: move snake
	 * @param snake placed in matrix
	 * @param player placed in matrix
	 */
	
	private void moveAnotherSnake(List snake, User player) {
		char snake_1 = snake.getSnakes();
		List foundSnake = searchSnake(snake_1);
		if(foundSnake.getRowXcolumn()==snake.getRowXcolumn()) {
			foundSnake = searchSnake(snake_1, foundSnake.getNextList());
			if(foundSnake.getPlayers()!="") {
				foundSnake.setPlayers(foundSnake.getPlayers().replace(foundSnake.getPlayers(), foundSnake.getPlayers()+String.valueOf(player.getPlayer())));
			}else {
				foundSnake.setPlayers(String.valueOf(player.getPlayer()));
			}
		}else {
			if(snake.getPlayers()!="") {
				snake.setPlayers(snake.getPlayers().replace(snake.getPlayers(), snake.getPlayers()+String.valueOf(player.getPlayer())));
			}else {
				snake.setPlayers(String.valueOf(player.getPlayer()));
			}
		}
	}
	
	/**
	 * moveAnotherLadder
	 * pre:
	 * pos: move ladder
	 * @param ladder placed in matrix
	 * @param player placed in matrix
	 * @return boolean ladders_1
	 */
	
	private boolean moveAnotherLadder(List ladder, User player) {
		char ladder_1 = ladder.getLadders();
		List foundLadder = searchLadder(ladder_1);
		if(foundLadder.getRowXcolumn()!=ladder.getRowXcolumn()) {
			if(foundLadder!=start) {
				if(foundLadder.getPlayers()!="") {
					foundLadder.setPlayers(foundLadder.getPlayers().replace(foundLadder.getPlayers(), foundLadder.getPlayers()+String.valueOf(player.getPlayer())));
					return false;
				}else {
					foundLadder.setPlayers(String.valueOf(player.getPlayer()));
					return false;
				}
			}else {
				foundLadder.setPlayers(String.valueOf(player.getPlayer()));
				return true;
			}
		}else {
			if(ladder.getPlayers()!="") {
				ladder.setPlayers(ladder.getPlayers().replace(ladder.getPlayers(), ladder.getPlayers()+String.valueOf(player.getPlayer())));
				return false;
			}else {
				ladder.setPlayers(String.valueOf(player.getPlayer()));
				return false;
			}
		}	
	}
	
	/**
	 * maxCells
	 * pre:
	 * pos: predetermine max cells of matrix
	 * @param newPos new position of list
	 * @return int newPos
	 */
	
	public int maxCells(int newPos) {
		int maxCell = start.getRowXcolumn();
		if(newPos>maxCell) {
			newPos=maxCell;
		}
		return newPos;
	}
	

	/* ------------------------------------------------------SHOW THE TABLES AND EACH POSITION----------------------------------------------------------*/
	
	/**
	 * showColumnsPrincipal
	 * pre:
	 * pos: show principal columns of the list in console
	 * @param row the rows to show
	 * @param column the columns to show
	 * @param temp the list to show the columns
	 * @param i the i to show
	 * @return int oddOrEven
	 */
	
	private String showColumnsPrincipals(int column, int row,List temp, int i) {
		int oddOrEven=row%2;
		
		if(row!=0) {
			if(column>=1){
				if (oddOrEven==0) {
					i=i+1;
					table=table+"[ "+temp.getRowXcolumn()+/*ANSI_BLACK+*/temp.getLadders()+/*ANSI_RESET*/temp.getSnakes()+"]";
					return showColumnsPrincipals(column=column-1, row, temp.getNextList(), i);
				}else {
					i=i+1;
					int n=temp.getRowXcolumn()-column+i;
					table=table+"[ "+searchList(n).getRowXcolumn()+/*ANSI_BLACK+*/searchList(n).getLadders()+/*ANSI_RESET*/
							searchList(n).getSnakes()+"]";
					return showColumnsPrincipals(column=column-1, row, temp.getNextList(), i);
				}
			}else {
				table=table+"\n";
				return showColumnsPrincipals(i, row=row-1, temp,0);
			}
		}else {
			return table;
		}
	}
	
	/**
	 * showColumns
	 * pre:
	 * pos: show the columns of the list
	 * @param column the columns to show
	 * @param row the row to show
	 * @param temp the list to show the columns
	 * @param i the i to show
	 * @return String table2
	 */
	
	private String showColumns(int column, int row,List temp, int i) {
		int oddOrEven=row%2;
		
		if(row!=0) {
			if(column>=1){
				if (oddOrEven==0) {
					i=i+1;
					table2=table2+"["+/*ANSI_BLACK+*/temp.getLadders()+/*ANSI_RESET*/temp.getSnakes()+temp.getPlayers()+"]";
					return showColumns(column=column-1, row, temp.getNextList(), i);
				}else {
					i=i+1;
					int n=temp.getRowXcolumn()-column+i;
					table2=table2+"["+/*ANSI_BLACK+*/searchList(n).getLadders()+/*ANSI_RESET*/
							searchList(n).getSnakes()+searchList(n).getPlayers()+"]";
					return showColumns(column=column-1, row, temp.getNextList(), i);
				}
			}else {
				table2=table2+"\n";
				return showColumns(i, row=row-1, temp,0);
			}
		}else {
			return table2;
		}
	}
	
	/**
	 * showContentPrincipal
	 * pre:
	 * pos: show principal content of the list in console
	 * @param row the rows to show
	 * @param column the columns to show
	 * @return String showColumsPrincipals
	 */
	
	public String showContentPrincipal(int row, int column) {
		table="";
		return showColumnsPrincipals(column, row, start, 0);
	}
	
	/**
	 * showContent
	 * pre:
	 * pos: show the content of the list in console
	 * @param row the rows to show
	 * @param column the columns to show
	 * @return String showColumns 
	 */
	
	public String showContent(int row, int column) {
		table2="";
		return showColumns(column, row, start, 0);
	}
	
}
