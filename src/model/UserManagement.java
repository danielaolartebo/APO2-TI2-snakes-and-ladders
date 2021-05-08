package model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UserManagement {
	private User root;
	private int positions;
	public static final String POSITIONS_PATH = "data/ranking.dob";
	
	public UserManagement() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(POSITIONS_PATH);
		if (f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			root = (User) ois.readObject();
			positions = 0;
			ois.close();
		}else{
			root = null;
			positions = 0;
		}
	}

	public void addUser(String nickname, int score, int columns, int rows, int snakes, int ladders, int players, char symbols) throws FileNotFoundException, IOException {
		User u = new User(nickname, score, columns, rows, snakes, ladders, players, symbols);
		if (root == null) {
			root = u;
			saveRoot();
		} else {
			addUser(root, u);
		}
	}

	private void addUser(User current, User newUser) throws FileNotFoundException, IOException {
		if (newUser.getScore() <= current.getScore()) {
			if (current.getRight() != null) {
				addUser(current.getRight(), newUser);
				saveRoot();
			} else {
				current.setRight(newUser);
				newUser.setParent(current);
			}
		} else {
			if (current.getLeft() != null) {
				addUser(current.getLeft(), newUser);
				saveRoot();
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
			System.out.println(positions + "." + toString());
			inOrder(u.getRight());
		}
	}

	public String toString() {
		String msg="";
		if(root == null) {
			msg = "There's no winner";
		}else {
			msg = root.toString(root);
		}
		return msg;
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

	private void saveRoot() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(POSITIONS_PATH));
		oos.writeObject(root);
		oos.close();
	}
}
