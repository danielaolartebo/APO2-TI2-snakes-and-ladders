package model;

public class User {
	
	/**
	 * 
	 * @author Santiago Gutierrez // Daniela Olarte
	 * User Class
	 *
	 */

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
	
	/**
	 * constructor of User class
	 * pre:
	 * pos: create a User instance
	 * @param players of game
	 * @param order of game
	 */
	
	public User(char p, int o) {
		this.player=p;
		this.order=o;
		moves=0;
	}
	
	/**
	 * User class
	 * pre:
	 * pos: create a User instance
	 * @param nickname the nickname of the user
	 * @param score the score of the user
	 * @param columns the columns played by the user
	 * @param rows the rows played by the user
	 * @param snakes the snakes put by the user
	 * @param ladders the ladders put by the user
	 * @param players the players put by the user
	 * @param symbols the symbols put by the user
	 */

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
	
	/**
	 * get nickName
	 * pre:
	 * pos: get the nickName of the user
	 * @return String nickname
	 */
	
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * set nickName
	 * pre:
	 * pos: set the nickName of the user
	 * @param nickname the nickname to set
	 */

	private void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * get player
	 * pre:
	 * pos: get the players of the game
	 * @return char player
	 */

	public char getPlayer() {
		return player;
	}
	
	/**
	 * set player
	 * pre:
	 * pos: set the player of the game
	 * @param player the player to set
	 */

	public void setPlayer(char player) {
		this.player = player;
	}
	

	/**
	 * get nextUser
	 * pre:
	 * pos: get the next user of the game
	 * @return User nextUser
	 */

	public User getNextUser() {
		return nextUser;
	}
	
	/**
	 * set next user
	 * pre:
	 * pos: set next user of the game
	 * @param nextUser the next user to set
	 */

	public void setNextUser(User nextUser) {
		this.nextUser = nextUser;
	}
	
	/**
	 * get order
	 * pre:
	 * pos: get order of the list
	 * @return int order
	 */

	public int getOrder() {
		return order;
	}
	
	/**
	 * set order
	 * pre:
	 * pos: set order of the list
	 * @param order the order of list
	 */

	public void setOrder(int order) {
		this.order = order;
	}
	
	/**
	 * get moves
	 * pre:
	 * pos: get moves of the user
	 * @return int moves
	 */

	public int getMoves() {
		return moves;
	}
	
	/**
	 * set moves
	 * pre:
	 * pos: set moves of the user
	 * @param moves the moves of user
	 */

	public void setMoves(int moves) {
		this.moves = moves;
	}
	
	/**
	 * get score
	 * pre:
	 * pos: get the score of the user
	 * @return int score
	 */

	public int getScore() {
		return score;
	}
	
	/**
	 * set score
	 * pre:
	 * pos: set the score
	 * @param score the score to set
	 */

	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * get row
	 * pre:
	 * pos: get the row of the user
	 * @return int row
	 */
	
	public int getRows() {
		return rows;
	}
	
	/**
	 * set row
	 * pre:
	 * pos: set the row of the user
	 * @param row the row to set
	 */
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	/**
	 * get column
	 * pre:
	 * pos: get the column of the user
	 * @return int column
	 */
	
	public int getColumns() {
		return columns;
	}
	
	/**
	 * set column
	 * pre:
	 * pos: set the column of the user
	 * @param column the column to set
	 */
	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	/**
	 * get snakes
	 * pre:
	 * pos: get the snakes
	 * @return int snakes
	 */
	
	public int getSnakes() {
		return snakes;
	}
	
	/**
	 * set the snakes
	 * pre:
	 * pos: set the snakes of the user
	 * @param snakes the quantity of snakes to set
	 */

	public void setSnakes(int snakes) {
		this.snakes = snakes;
	}
	
	/**
	 * get players
	 * pre:
	 * pos: get the players
	 * @return int players
	 */
	
	public int getPlayers() {
		return players;
	}
	
	/**
	 * set the players
	 * pre:
	 * pos: set the players of the game
	 * @param players the quantity of players to set
	 */

	public void setPlayers(int players) {
		this.players = players;
	}
	
	/**
	 * get ladders
	 * pre:
	 * pos: get the ladders
	 * @return int ladders
	 */
	
	public int getLadders() {
		return ladders;
	}
	
	/**
	 * set the ladders
	 * pre:
	 * pos: set the ladders of the user
	 * @param ladders the quantity of mirror to set
	 */

	public void setLadders(int ladders) {
		this.ladders = ladders;
	}
	
	/**
	 * get symbols
	 * pre:
	 * pos: get the symbols
	 * @return char symbols
	 */
	
	public char getSymbols() {
		return symbols;
	}
	
	/**
	 * set the symbols
	 * pre:
	 * pos: set the symbols of the user
	 * @param symbols the quantity of symbols to set
	 */

	public void setSymbols(char symbols) {
		this.symbols = symbols;
	}
	
	/**
	 * get leftUser
	 * pre:
	 * pos: get leftUser
	 * @return User left
	 */
	
	public User getLeft() {
		return left;
	}
	
	/**
	 * set left
	 * pre:
	 * pos: set the leftUser of the list
	 * @param left the leftUser to set
	 */
	
	public void setLeft(User left) {
		this.left = left;
	}
	
	/**
	 * get right list
	 * pre:
	 * pos: get the right list
	 * @return User right
	 */
	
	public User getRight() {
		return right;
	}
	
	/**
	 * set right list
	 * pre:
	 * pos: set the right list
	 * @param right the right list
	 */
	
	public void setRight(User right) {
		this.right = right;
	}
	
	/**
	 * get Parent
	 * pre:
	 * pos: get the parent
	 * @return User parent
	 */
	
	public User getParent() {
		return parent;
	}
	
	/**
	 * set the parent
	 * pre:
	 * pos: set the parent
	 * @param parent the parent to set
	 */
	
	public void setParent(User parent) {
		this.parent = parent;
	}
}