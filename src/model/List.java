package model;

public class List {
	private char snakes;
	private char ladders;
	private int rowXcolumn;
	private String contentLeft;
	private String contentRight;
	private String players;
	private List nextList;
	//private List p;

	public List(int rowAndColumn) {
		this.rowXcolumn= rowAndColumn;
		contentLeft = "[";
		contentRight="]";
	}

	public char getSnakes() {
		return snakes;
	}

	public void setSnakes(char snakes) {
		this.snakes = snakes;
	}

	public char getLadders() {
		return ladders;
	}

	public void setLadders(char ladders) {
		this.ladders = ladders;
	}

	public int getRowXcolumn() {
		return rowXcolumn;
	}

	public void setRowXcolumn(int rowAndColumn) {
		this.rowXcolumn = rowAndColumn;
	}

	public String getContentLeft() {
		return contentLeft;
	}

	public void setContentLeft(String contentLeft) {
		this.contentLeft = contentLeft;
	}

	public String getContentRight() {
		return contentRight;
	}

	public void setContentRight(String contentRight) {
		this.contentRight = contentRight;
	}
	
	public List getNextList() {
		return nextList;
	}

	public void setNextList(List nextList) {
		this.nextList = nextList;
	}
	
	/*public List getParent() {
		return p;
	}
	
	public void setParent(List parent) {
		this.p=parent;
	}*/

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

}
	