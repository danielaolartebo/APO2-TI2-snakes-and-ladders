package model;

/**
 * 
 * @author Santiago Gutierrez // Daniela Olarte
 * List Class
 *
 */

public class List {
	private char snakes;
	private char ladders;
	private int rowXcolumn;
	private String contentLeft;
	private String contentRight;
	private String players;
	private List nextList;
	

	/**
	 * Create a List instance
	 * pre:
	 * pos:build a List instance
	 * @param row and column of the list
	 */

	public List(int rowAndColumn) {
		this.rowXcolumn= rowAndColumn;
		contentLeft = "[";
		contentRight="]";
	}
	
	/**
	 * get snakes
	 * pre:
	 * pos: get snakes of table
	 * @return char snakes
	 */

	public char getSnakes() {
		return snakes;
	}
	
	/**
	 * set snakes
	 * pre:
	 * pos: set snakes of table
	 * @param snakes of table 
	 */

	public void setSnakes(char snakes) {
		this.snakes = snakes;
	}
	
	/**
	 * get ladders
	 * pre:
	 * pos: get ladders of table
	 * @return char ladders
	 */

	public char getLadders() {
		return ladders;
	}
	
	/**
	 * set ladders
	 * pre:
	 * pos: set ladders of table
	 * @param ladders of table
	 */

	public void setLadders(char ladders) {
		this.ladders = ladders;
	}
	
	/**
	 * get row and column
	 * pre:
	 * pos: get row x column
	 * @return int rowXcolumn
	 */

	public int getRowXcolumn() {
		return rowXcolumn;
	}
	
	/**
	 * set row and column
	 * pre:
	 * pos: set row x column
	 * @param rowXcolumn of list
	 */

	public void setRowXcolumn(int rowAndColumn) {
		this.rowXcolumn = rowAndColumn;
	}
	
	/**
	 * get left
	 * pre:
	 * pos: get left
	 * @return String contentLeft
	 */

	public String getContentLeft() {
		return contentLeft;
	}
	
	/**
	 * set left
	 * pre:
	 * pos: set left
	 * @param contentLeft of table
	 */

	public void setContentLeft(String contentLeft) {
		this.contentLeft = contentLeft;
	}
	
	/**
	 * get right
	 * pre:
	 * pos: get right
	 * @return String contentRight
	 */

	public String getContentRight() {
		return contentRight;
	}
	
	/**
	 * set right
	 * pre:
	 * pos: set right
	 * param contentRight of table
	 */

	public void setContentRight(String contentRight) {
		this.contentRight = contentRight;
	}
	
	/**
	 * get next
	 * pre:
	 * pos: get next
	 * @return List nextList
	 */
	
	public List getNextList() {
		return nextList;
	}
	
	/**
	 * set next
	 * pre:
	 * pos: set next
	 * @param nextList of table
	 */

	public void setNextList(List nextList) {
		this.nextList = nextList;
	}
	
	/**
	 * get players
	 * pre:
	 * pos: get players
	 * @return String players
	 */

	public String getPlayers() {
		return players;
	}
	
	/**
	 * set players
	 * pre:
	 * pos: set next
	 * @param players of list
	 */

	public void setPlayers(String players) {
		this.players = players;
	}

}
	