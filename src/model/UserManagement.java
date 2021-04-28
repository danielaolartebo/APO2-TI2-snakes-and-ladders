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
	//public static final String POSITIONS_PATH = "data/ranking.jmpc";

	public UserManagement(){
		
	}

	public void addUser(String nickname, int pos, int row, int column, int movements){
		User newUser = new User(nickname, pos, row, column, movements);
		if (root == null) {
			root = newUser;
		} else {
			addUser(root, newUser);
		}
	}
	
	private void addUser(User current, User u) {
		if (current.getPos() >= u.getPos()) {
			if (current.getLeft() == null) {
				current.setLeft(u);
				u.setParent(current);
			} else {
				addUser(current.getLeft(), u);
			}
		} else {
			if (current.getRight() == null) {
				current.setRight(u);
				u.setParent(current);
			} else {
				addUser(current.getRight(), u);
			}
		}
	}
	
	public User searchUser(int pos) {
		return searchUser(root, pos);
	}
	
	public User searchUser(User current, int pos) {
		if(current ==null || current.getPos()==pos) {
			return current;
		}else if(current.getPos()<pos){
			return searchUser(current.getRight(), pos);
		}else {
			return searchUser(current.getLeft(),pos);
		}
	}
	
	public void inOrder(User x) {
		if (x != null) {
			inOrder(x.getRight());
			positions++;
			System.out.println(positions + "." + x.getData());
			inOrder(x.getLeft());
		}

	}
	
	public User getRoot() {
		return root;
	}
	
	public void restartPositions() {
		positions = 0;
	}

	/*private void saveRoot() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(POSITIONS_PATH));
		oos.writeObject(root);
		oos.close();
	}*/
}

