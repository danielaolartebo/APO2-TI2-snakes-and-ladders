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
	public static final String POSITIONS_PATH = "data/ranking.jmpc";
	
	public UserManagement() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(POSITIONS_PATH);
		if (f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			root = (User) ois.readObject();
			positions = 0;
			ois.close();
		} else {
			root = null;
			positions = 0;
		}
	}

	public void addUser(User user) throws FileNotFoundException, IOException {
		if (root == null) {
			root = user;
			saveRoot();
		} else {
			addUser(root, user);
		}
	}

	private void addUser(User current, User u) throws FileNotFoundException, IOException {
	/*	if (current.getScore() >= u.getScore()) {
			if (current.getLeft() == null) {
				current.setLeft(u);
				u.setParent(current);
				saveRoot();
			} else {
				addUser(current.getLeft(), u);
			}
		} else {
			if (current.getRight() == null) {
				current.setRight(u);
				u.setParent(current);
				saveRoot();
			} else {
				addUser(current.getRight(), u);
			}
		} */
	}

	public void inOrder(User x) {
	/*	if (x != null) {
			inOrder(x.getRight());
			positions++;
			System.out.println(positions + "." + x.getData());
			inOrder(x.getLeft());
		}
	*/
	} 

	public User getRoot() {
		return root;
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
