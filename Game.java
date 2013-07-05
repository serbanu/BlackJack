
public class Game {

	public int card1;
	public int card2;
	public int tableCard;
	public static int playersSum;
	public static int tablesSum;
	
	public static String[] card = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "12", "13", "14" };
		
	public int generateCard() {
		int generated = Integer.parseInt(card[(int) (Math.random()*13)]);
		generated = faceDownConvertToTen(generated);
		return generated;
	}
	
	public static void playersTurn() {
		Player giocatore = new Player();
		giocatore.convertToTen();
		giocatore.gameAtStart();
		mainMoves(giocatore);
		playersSum = giocatore.sumCumulated;
		System.out.print("Player's cards are " + giocatore.card1 + " and " + giocatore.card2);
		System.out.println(" and he cumulated " + playersSum);		
	}

	public static void tablesTurn() {
		Table tablare = new Table();
		tablare.convertToTen();
		System.out.print("Table's card were " + tablare.tableCard + " and then obtained ");
		mainMoves(tablare);
		tablesSum = tablare.tableCard;
		System.out.println(tablare.tableCard);
	}

	private static void mainMoves(Player giocatore) {
		while(giocatore.checkSumCumulated()) {
			oneCardEqualsOne(giocatore);
			giocatore.hitMe();
			hitOrStand(giocatore);
		}
	}

	private static void hitOrStand(Player giocatore) {
		if(giocatore.checkSumCumulated()) {
			giocatore.hitMe();
		} else {
			giocatore.stand();
		}
	}

	private static void oneCardEqualsOne(Player giocatore) {
		if(giocatore.oneCardEqualsOne()) {
			giocatore.chooseAce();
		}
	}

	private static void mainMoves(Table tablare) {
		if(tablare.equalsOne()) {
			tablare.chooseAce();
			tablare.tableCard += Integer.parseInt(card[(int) (Math.random()*13)]);
			tablare.convertToTen();
		} else {
			tablare.hitMe();
			soft17(tablare);
			int faceDownCard = Integer.parseInt(card[(int) (Math.random()*13)]);
			faceDownCard = faceDownConvertToTen(faceDownCard);
			tablare.tableCard += faceDownCard;
		}
	}

	private static void soft17(Table tablare) {
		if(tablare.soft17()) {
			tablare.stand();
		} else {
			tablare.hitMe();
		}
	}

	private static int faceDownConvertToTen(int faceDownCard) {
		if(faceDownCard > 10) {
			faceDownCard = 10;
		}
		return faceDownCard;
	}

	private static void clashOfTheTitans() {
		if(playersSum <= 21 && tablesSum <= 21) {
			tableVsPlayerUnder21();
		} else {
			unfairTableVsPlayer();
		}
	}

	private static void unfairTableVsPlayer() {
		if(playersSum <= 21 && tablesSum > 21) {
			System.out.println("Player has won the game");
		} else if(playersSum > 21 && tablesSum <= 21) {
			System.out.println("Table has won the game");
		} else {
			System.out.println("Both, the player and the table lost the game");
		}
	}

	private static void tableVsPlayerUnder21() {
		if(playersSum < tablesSum) {
			System.out.println("Table has won the game");
		} else if(playersSum > tablesSum) {
			System.out.println("Player has won the game");
		} else {
			System.out.println("Game ended as a draw");
		}
	}
	

	public static void main(String[] args) {
		playersTurn();
		tablesTurn();
		clashOfTheTitans();
	}
}
