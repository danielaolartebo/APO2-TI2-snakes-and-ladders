package model;

public class List {

	private char snakes;
	private char ladders;
	private char column;
	private int row;
	private String content;
	private boolean found;
	private List prevList;
	private List nextList;
	private List downList;
	private List upList;

	public List(int row) {
		this.row = row;
		snakes = ' ';
		ladders = ' ';
		setContent("[ ]");
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean getFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

}