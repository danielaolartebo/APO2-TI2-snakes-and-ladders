package model;
import java.io.IOException;
import java.io.FileNotFoundException;

public class UserManagement {
	private User root;
	private int positions;
	public static final String POSITIONS_PATH = "data/ranking.dob";
	
	public UserManagement() throws FileNotFoundException, IOException, ClassNotFoundException {
			root = null;
			positions = 0;
	}

	public void addUser(String nickname, int score, int columns, int rows, int snakes, int ladders, int players, char symbols) throws FileNotFoundException, IOException {
		User u = new User(nickname, score, columns, rows, snakes, ladders, players, symbols);
		if (root == null) {
			root = u;
		} else {
			addUser(root, u);
		}
	}

	private void addUser(User current, User newUser) throws FileNotFoundException, IOException {
		if (newUser.getScore() <= current.getScore()) {
			if (current.getRight() != null) {
				addUser(current.getRight(), newUser);
			} else {
				current.setRight(newUser);
				newUser.setParent(current);
			}
		} else {
			if (current.getLeft() != null) {
				addUser(current.getLeft(), newUser);
			} else {
				current.setLeft(newUser);
				newUser.setParent(current);
			}
		} 
	}
	
	public void inOrder(User u) {
		if (u != null) {
			inOrder(u.getLeft());
			positions++;
			System.out.println(positions + "." + toString(u));
			inOrder(u.getRight());
		}
	}

	private String toString(User u) {
		String msg="";
		if(u == null) {
			msg = "There's no winner";
			return msg;
		}else {
			msg = u.getNickname() + " " + u.getScore() + " " + u.getColumns() + " " + u.getRows() + " " + u.getSnakes() + " " + u.getLadders() + " " + u.getPlayers()+ " " + u.getSymbols();
			return msg;
		}
	}

	public User getRoot() {
		return root;
	}
	
	public void setRoot(User root) {
		this.root=root;
	}

	public void restartPositions() {
		positions = 0;
	}

}
