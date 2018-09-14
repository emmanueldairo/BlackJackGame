package core;

public class Card {


	private String suit;
	private int rank;
		
	public Card(String suit,int rank) {
		this.suit=suit;
		this.rank=rank;
	}
	public Card(Card aCard) {
		suit=aCard.suit;
		rank=aCard.rank;
	}
	 public String getRankName(){
        if (rank == 1)
        	return "A";
	    else if (rank == 11)
            return "J";
        else if (rank == 12)
            return "Q";
        else if (rank == 13)
            return "K";
        else
            return String.valueOf(rank);
	 }
	 public int getValue(){
		 if (rank == 1)
			 return 11;
		 else if (rank == 11 || rank == 12 || rank == 13)
	         return 10;

		 return rank;
	 } 

	 public String getSuit(){
		 return suit;
	 } 

    public int getRank(){
    	return rank;
    } 
}


