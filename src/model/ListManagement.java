package model;

public class ListManagement {
	
	private List start;
	private List end;
	
	private User first;
	private User last;
	
	public ListManagement() {
		start=null;
		end=null;
	}
	/* ------------------------------------------------------WORKING WITH THE CELLS----------------------------------------------------------*/
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
	
	public List searchList(int pos) {  
		return searchList(pos, start);
	}
	
	private List searchList(int pos, List temp) {
		if(temp.getRowXcolumn()==pos) {
			return temp;
		}else {
			temp=temp.getNextList();
			return searchList(pos, temp);
		}
	}
	
	public void assignSpaces(int i) {
		assignSpaces(i,start);
	}
	private void assignSpaces(int i, List temporal) {
		if(i>0) {
		temporal.setPlayers("");
		temporal=temporal.getNextList();
		assignSpaces(i=i-1,temporal);
		}
	}
	
	public void assignPlayer(String players) {
		end.setPlayers(players);
	}
	
	
	/* ------------------------------------------------------WORKING WITH SNAKES AND LADDERS----------------------------------------------------------*/
	
	public boolean checkLadder(List ladders) {
		boolean found = false;
		if(ladders.getLadders()==0) {
			found =true;
		}
		return found;
	}
	
	public void putLadder(char ladder, List pos) {
		pos.setLadders(ladder);
	}
	
	public boolean checkSnake(List snakes) {
		boolean found = false;
		if(snakes.getSnakes()==0) {
			found =true;
		}
		return found;
	}
	
	public void putSnake(char snake, List pos) {
		pos.setSnakes(snake);
	}
	
	public List searchSnake(char snake) {
		return searchSnake(snake, start);
	}
	
	private List searchSnake(char s, List temp) {
		if(temp.getSnakes()==s) {
			return temp;
		}else {
			temp=temp.getNextList();
			return searchSnake(s, temp);
		}
	}
	
	public List searchLadder(char ladder) {
		return searchLadder(ladder, start);
	}
	
	private List searchLadder(char l, List temp) {
		if(temp.getLadders()==l) {
			return temp;
		}else {
			temp=temp.getNextList();
			return searchLadder(l, temp);
		}
	}
	
	/* ------------------------------------------------------WORKING WITH THE PARTICIPANTS/PLAYERS----------------------------------------------------------*/
	
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
	
	public User searchUser(int pos) {
		return searchUser(pos, first);
	}
	
	public User searchUser(int pos, User temp) {
		if(temp.getOrder()==pos) {
			return temp;
		}else {
			temp=temp.getNextUser();
			return searchUser(pos, temp);
		}
	}
	
	public boolean someWinner(User user) {
		boolean found=false;
		if(start.getPlayers()==String.valueOf(user.getPlayer())) {
			found=true;
		}
		return found;
	}
	
	private boolean samePlayer(User p, List same, int c) {
		boolean found = false;
		System.out.println(same.getPlayers());
		char users = same.getPlayers().charAt(c);
			if(users==p.getPlayer()) {
				found=true;
				return found;
			}
			else {
				found=false;
				return found;
			}
		
	}
	
	/* ------------------------------------------------------MOVING THE PARTICIPANTS/PLAYERS----------------------------------------------------------*/
	
	public void movePlayers(char p, int pos, int moves) {
		movePlayers(p, pos, moves, start);
	}
	
	public void movePlayers(char p, int pos, int moves, List temporal) {
		User player = new User(p, pos);
		
		if(temporal.getPlayers()!="") {
			if(samePlayer(player,temporal,0)) {
				temporal.setPlayers(temporal.getPlayers().replace(String.valueOf(player.getPlayer()), ""));
				int currentPos = temporal.getRowXcolumn();
				int newPos = currentPos+moves;
				searchList(newPos);
				if(checkLadder(searchList(newPos))) {  //**-------------------------------PLAYER IN THE NORMAL ROAD--------------------------------------**//
					if(checkSnake(searchList(newPos))) { 
						temporal= searchList(newPos);
						if(temporal.getPlayers()!="") {	
							temporal.setPlayers(temporal.getPlayers().replace(temporal.getPlayers(), temporal.getPlayers()+String.valueOf(player.getPlayer())));
						}else {
							temporal.setPlayers(String.valueOf(player.getPlayer()));
						}
					}else { //**-------------------------------------PLAYER FELL ON SNAKE--------------------------------------------**//
						temporal= searchList(newPos);
						moveAnotherSnake(temporal, player);
					}
				}else {  //**-----------------------------------PLAYER FELL ON LADDER--------------------------------------------**//
					temporal=searchList(newPos);
					moveAnotherLadder(temporal, player);
				}
			}else {
				temporal=temporal.getNextList();
				movePlayers(p, pos, moves, temporal);
			}
		}else {
			temporal=temporal.getNextList();
			movePlayers(p,pos, moves, temporal);
		}
	}
	
	private void moveAnotherSnake(List snake, User player) {
		char snake_1 = snake.getSnakes();
		List foundSnake = searchSnake(snake_1);
		if(foundSnake.getRowXcolumn()==snake.getRowXcolumn()) {
			foundSnake = searchList(snake_1, foundSnake.getNextList());
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
	
	private void moveAnotherLadder(List ladder, User player) {
		char ladder_1 = ladder.getLadders();
		List foundLadder = searchLadder(ladder_1);
		if(foundLadder.getRowXcolumn()!=ladder.getRowXcolumn()) {
			if(foundLadder.getPlayers()!="") {
				foundLadder.setPlayers(foundLadder.getPlayers().replace(foundLadder.getPlayers(), foundLadder.getPlayers()+String.valueOf(player.getPlayer())));
			}else {
				foundLadder.setPlayers(String.valueOf(player.getPlayer()));
			}
		}else {
			if(ladder.getPlayers()!="") {
				ladder.setPlayers(ladder.getPlayers().replace(ladder.getPlayers(), ladder.getPlayers()+String.valueOf(player.getPlayer())));
			}else {
				ladder.setPlayers(String.valueOf(player.getPlayer()));
			}
		}
	}
	
	
	public void show() {
		if(start==null) {
			System.out.println("La lista esta vacia");
		}else {
			List temporal;
			temporal=start;
			while(temporal!=null) {
				System.out.println(temporal.getRowXcolumn()+""+temporal.getLadders()+""+temporal.getSnakes()+""+temporal.getPlayers());
				temporal=temporal.getNextList();
			}
		}
	}
	
	public void showUser() {
		if(first==null) {
			System.out.println("La lista esta vacia");
		}else {
			User temporal;
			temporal=first;
			while(temporal!=null) {
				System.out.println(temporal.getOrder()+ ""+ temporal.getPlayer());
				temporal=temporal.getNextUser();
			}
		}
	}
	
}
