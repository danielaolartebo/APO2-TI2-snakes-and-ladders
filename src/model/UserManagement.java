package model;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * 
 * @author Santiago Gutierrez // Daniela Olarte
 * UserManagement Class
 *
 */

public class UserManagement {
	private User root;
	private int positions;
	public static final String POSITIONS_PATH = "data/ranking.dob";
	
	/**
	 * the constructor of UserManagement Class
	 * pre:
	 * pos: create root of user
	 * @throws FileNotFoundException file not found
	 * @throws IOException an ioexception
	 * @throws ClassNotFoundException the classNotFound
	 */
	
	public UserManagement() throws FileNotFoundException, IOException, ClassNotFoundException {
			root = null;
			positions = 0;
	}

	/**
	 * add user
	 * pre:
	 * pos: add a user into the list
	 * @param nickname to add to list score, columns, rows, snakes, ladders, players, symbols to add the user
	 * @param score to add list 
	 * @param columns to add list 
	 * @param rows to add list 
	 * @param snakes to add list 
	 * @param ladders to add list 
	 * @param players to add list   
	 * @param symbols to add list   
	 * @throws FileNotFoundException the file dont found
	 * @throws IOException an ioexception
	 */
	
	public void addUser(String nickname, int score, int columns, int rows, int snakes, int ladders, int players, char symbols) throws FileNotFoundException, IOException {
		User u = new User(nickname, score, columns, rows, snakes, ladders, players, symbols);
		if (root == null) {
			root = u;
		} else {
			addUser(root, u);
		}
	}

	/**
	 * add user
	 * pre:
	 * pos: add user to the list
	 * @param current the current list user
	 * @param u the user to add
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
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
	
	/**
	 * walk list in order
	 * pre:
	 * pos: walk list in order and show list in console
	 * @param u the root of the list
	 */
	
	public void inOrder(User u) {
		if (u != null) {
			inOrder(u.getLeft());
			positions++;
			System.out.println(positions + "." + toString(u));
			inOrder(u.getRight());
		}
	}

	/**
	 * print winner
	 * pre:
	 * pos: show winner's list in console
	 * @param u to print winner
	 */
	
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

	/**
	 * get root
	 * pre:
	 * pos: get the root of the list
	 * @return User root
	 */
	
	public User getRoot() {
		return root;
	}


	/**
	 * restartPositions
	 * pre:
	 * pos: put the positions in 0
	 */
	
	public void restartPositions() {
		positions = 0;
	}

}
