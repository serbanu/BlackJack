
public class Table extends Game {
	
	public Table() {
		this.tableCard = Integer.parseInt(card[(int) (Math.random()*13)]);
	}

	public void chooseAce() {
		if(equalsOne()) {
			tableCard = 11;
		}
	}

	public void hitMe() {
		tableCard += Integer.parseInt(card[(int) (Math.random()*13)]);
		convertToTen();
	}

	public void stand() {}
	
	public boolean soft17() {
		if(tableCard >= 17) {
			return true;
		}
		return false;
	}
	
	public void convertToTen() {
		if(tableCard > 10) {
			tableCard = 10;
		}
	}
	
	public boolean equalsOne() {
		if(tableCard == 1) {
			return true;
		}
		return false;
	}
}
