package core;
//citation: Stack overflow how is my black jack game design

public class Hand {
	    private Card first;
	    private int cardTotal;
	    private String name;
	    private int handSize;

	    public Hand(String name)
	    {
	        first = null;
	        this.name = name;
	        cardTotal = 0;
	        handSize = 0;
	    } 

	    public void insert(Card card)
	    {
	        Card newLink = new Card(card);
	        newLink.next = first;

	        if (card.getRank() == 1 && cardTotal + card.getValue() > 21)
	            cardTotal = cardTotal + (card.getValue() - 10);
	        else
	            cardTotal = cardTotal + card.getValue();

	        handSize = handSize + 1;

	        first = newLink;
	    } 

	    public Card deleteFirst()
	    {
	        Card temp = first;
	        first = first.next;
	        cardTotal = cardTotal - temp.getValue();
	        handSize = handSize - 1;
	        return temp;
	    } 

	    public void displayHand()
	    {
	        Card current = first;
	        while(current != null)
	        {
	            current.toString();
	            current = current.next;
	        } 
	    } 

	    public boolean isEmpty()
	    {
	        return first == null;
	    } 

	    public boolean bothEqual()
	    {
	        Card temp = first;
	        return temp != null && (temp.getValue() == temp.next.getValue());
	    } 
	    

	    public void peek()
	    {
	        first.showCard();
	    } 

	    public int peekValue()
	    {
	        return first.getValue();
	    } 

	    public int getHandSize()
	    {
	        return handSize;
	    } 

	    public String getName()
	    {
	        return name;
	    } 

	    public int getHandTotal()
	    {
	        return cardTotal;
	    } 
	
}
