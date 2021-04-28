package model;

public class List {

	private char snakes;
	private char ladders;
	private char column;
	private int row;
	private String contentLeft;
	private String contentRight;
	private boolean found;
	private List prevList;
	private List nextList;
	private List downList;
	private List upList;

	public List(int row, char charColumn) {
		this.column= charColumn;
		this.row = row;
		snakes = ' ';
		ladders = ' ';
		contentLeft = "[";
		contentRight="]";
	}

	public char getColumn() {
		return column;
	}
	
	public void setColumn(char column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public List getPrevList() {
		return prevList;
	}

	public void setPrevList(List prevList) {
		this.prevList = prevList;
	}

	public List getNextList() {
		return nextList;
	}
	
	public void setNextList(List nextList) {
		this.nextList = nextList;
	}

	public List getDownList() {
		return downList;
	}

	public void setDownList(List downList) {
		this.downList = downList;
	}

	public List getUpList() {
		return upList;
	}

	public void setUpList(List upList) {
		this.upList = upList;
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

	public boolean getFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

}