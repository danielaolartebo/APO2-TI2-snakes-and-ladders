package model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1;
	private char player;
	private int order;
	private int moves;
	private User nextUser;
	private int score;
	
	public User(char p, int o) {
		this.player=p;
		this.order=o;
		moves=0;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public char getPlayer() {
		return player;
	}

	public void setPlayer(char player) {
		this.player = player;
	}

	public User getNextUser() {
		return nextUser;
	}

	public void setNextUser(User nextUser) {
		this.nextUser = nextUser;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}
	
}