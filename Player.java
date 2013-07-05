
public class Player extends Game {
	
	public int sumCumulated;
	
	public Player() {
		this.card1 = Integer.parseInt(card[(int) (Math.random()*13)]);
		this.card2 = Integer.parseInt(card[(int) (Math.random()*13)]);
		sumCumulated = 0;
	}
	
	public void hitMe() {
		sumCumulated += generateCard();
	}

	public void stand() {}
	
	public boolean checkSumCumulated() {
		if(getSumCumulated() < 16) {
			return true;
		} else {
			return false;
		}
	}
	
	public void gameAtStart() {
		sumCumulated += sumCards();
	}
	
	public void chooseAce() {
		equalToOne();
	}

	public void equalToOne() {
		if(card1 == 1 || card2 == 1) {
			greaterThanSix();
		}
	}

	public void greaterThanSix() {
		if(sumCards() > 6) {
			oneCardEqualsOne();
		}
	}

	public boolean oneCardEqualsOne() {
		if(card1 == 1) {
			card1 = 11;
			return true;
		} 
		if(card2 == 1) {
			card2 = 11;
			return true;
		}
		return false;
	}
	
	public int sumCards() {
		return card1 + card2;
	}
	
	public int getSumCumulated() {
		return sumCumulated;
	}
	
	public void convertToTen() {
		if(card1 > 10) {
			card1 = 10;
		}
		if(card2 > 10) {
			card2 = 10;
		}
	}
}
