package model;
import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private char player;
	private int order;
	private int moves;
	
	private User nextUser;
	private String nickname;
	private int score;
	private int columns;
	private int rows;
	private int snakes;
	private int ladders;
	private int players;
	private char symbols;
	private User left;
	private User right;
	private User parent;
	
	public User(char p, int o) {
		this.player=p;
		this.order=o;
		moves=0;
	}

	public User(String nickname, int score, int columns, int rows, int snakes, int ladders, int players, char symbols) {
		this.setNickname(nickname);
		this.score = score;
		this.columns = columns;
		this.rows = rows;
		this.snakes = snakes;
		this.ladders = ladders;
		this.players = players;
		this.symbols = symbols;
	}
	
	public String getNickname() {
		return nickname;
	}

	private void setNickname(String nickname) {
		this.nickname = nickname;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public int getSnakes() {
		return snakes;
	}

	public void setSnakes(int snakes) {
		this.snakes = snakes;
	}
	
	public int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}
	
	public int getLadders() {
		return ladders;
	}

	public void setLadders(int ladders) {
		this.ladders = ladders;
	}
	
	public char getSymbols() {
		return symbols;
	}

	public void setSymbols(char symbols) {
		this.symbols = symbols;
	}
	public User getLeft() {
		return left;
	}
	
	public void setLeft(User left) {
		this.left = left;
	}
	
	public User getRight() {
		return right;
	}
	
	public void setRight(User right) {
		this.right = right;
	}
	
	public User getParent() {
		return parent;
	}
	
	public void setParent(User parent) {
		this.parent = parent;
	}

	public String toString(User u) {
		String msg = "";
		if (u != null) {
			msg += toString(u.left);
			msg += nickname + " " + score + " " + columns + " " + rows + " " + snakes + " " + ladders + " " + players + " " + symbols;
			msg += toString(u.right);
		}
		return msg;
	}
	
}