package model;

public class ListManagement {

	private List firstList;
	private List endFirstList;
	private List lastList;
	private List endLastList;
	private char charColumn;
	private int longitud;

	public ListManagement(int row) {
		List list = new List(row, 'A');
		firstList = list;
		endFirstList = list;
		lastList = list;
		endLastList = list;
		charColumn = 'B';
		longitud = 1;
	}

	public List getFirstList() {
		return firstList;
	}

	public void setFirstList(List firstList) {
		this.firstList = firstList;
	}

	public List getEndLastList() {
		return endLastList;
	}

	public List getLastList() {
		return lastList;
	}

	public List getEndFirstList() {
		return endFirstList;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public void setLastList(List lastList) {
		this.lastList = lastList;
	}

	public void setEndLastList(List endLastList) {
		this.endLastList = endLastList;
	}

	public void add(int row, int column) {
		List l = new List(row, charColumn);
		if (column > 1) {
			endFirstList.setNextList(l);
			l.setPrevList(endFirstList);
			endFirstList = l;
			longitud++;
			charColumn++;
			add(row, (column - 1));
		}
	}

	public List search(int row, int column, List temp) {

		if (row > 1) {
			temp = temp.getDownList();
			return search(row - 1, column, temp);
		} else if (column > 1) {
			temp = temp.getNextList();
			return search(row, column - 1, temp);
		}
		return temp;

	}

	private void showColumnsOdd(int column, List temp, int i) {
	
		if (column >= 1) {
			System.out.print(temp.getContentLeft()+i+temp.getContentRight());
			i++;
			if (temp.getNextList() != null) {
				temp = temp.getNextList();
				showColumnsOdd(column=column-1, temp, i);
			}
		}
	}
	
	private void showColumnsOddFinal(int column, List temp, int i) {
		
		if (column >= 1) {
			if(column==1) {
				System.out.print(temp.getContentLeft()+i+temp.getContentRight());
			}else {
				System.out.print(temp.getContentLeft()+i+temp.getContentRight());
			}
			i++;
			if (temp.getNextList() != null) {
				temp = temp.getNextList();
				showColumnsOdd(column=column-1, temp, i);
			}
		}
	}
	
	private void showColumnsEven(int column, List temp, int i) {
		
		if (column >= 1) {
			System.out.print(temp.getContentLeft()+i+temp.getContentRight());
			i--;
			if (temp.getNextList() != null) {
				temp = temp.getNextList();
				showColumnsEven(column=column-1, temp, i);
			}
		}
	}
	
	
	public void showContent(int row, int column, List temp, int iteration) {
		int odd = row%2;
		if (row > 0) {
			if(odd !=0) {
				iteration= iteration-column+1;
				if(row==1){
					showColumnsOddFinal(column, temp, iteration);
				}else {
				showColumnsOdd(column, temp,iteration);
				System.out.println();
				}
				if (temp.getDownList() != null) {
					temp = temp.getDownList();
					iteration=iteration-1;
					showContent(row=row-1, column, temp, iteration);
					}
			}else {
				showColumnsEven(column, temp,iteration);
				System.out.println();
				if (temp.getDownList() != null) {
					temp = temp.getDownList();
					iteration=iteration-column;
					showContent(row=row-1, column, temp, iteration);
				}
			}
		}
	}
	
	
}

