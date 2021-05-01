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
	
	public List searchList(int pos, List temporal) {
		if(temporal.getRowXcolumn()==pos) {
			return temporal;
		}else {
			temporal=temporal.getNextList();
			return searchList(pos, temporal);
		}
	}
	
	public void assignPlayer(String players) {
		end.setPlayers(players);
	}
	
	public boolean checkLadder(List l) {
		boolean found = false;
		if(l.getLadders()==0) {
			found =true;
		}
		return found;
	}
	
	public void putLadder(char ladder, List pos) {
		pos.setLadders(ladder);
	}
	
	public boolean checkSnake(List l) {
		boolean found = false;
		if(l.getSnakes()==0) {
			found =true;
		}
		return found;
	}
	
	public void putSnake(char snake, List pos) {
		pos.setSnakes(snake);
	}
	
	public void addPlayer(char user, int order) {
		if(first==null) {
			User newUser =  new User(user, order);
			start.setUser(newUser);
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
	
	public User searchUser(int pos, User temporal) {
		if(temporal.getPlayer()==pos) {
			return temporal;
		}else {
			temporal=temporal.getNextUser();
			return searchUser(pos, temporal);
		}
	}
	
	public boolean someWinner(User user) {
		boolean found=false;
		if(start.getPlayers()==String.valueOf(user.getPlayer())) {
			found=true;
		}
		return found;
	}
}
