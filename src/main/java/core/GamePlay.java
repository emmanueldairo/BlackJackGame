package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class GamePlay {
	 public static  int BLACKJACK = 21;
	    public  int DECKSIZE = 52;
	    public  static boolean isPlayerDone;

	    public static void main(String[] args) throws IOException 
	    {
	        Deck deck = null;
	        Hand playersHand = null;
	        Hand splitHand = null;
	        Hand dealersHand = null;
	        BufferedReader buff;
	        System.out.println("--------------------------------------------------------"); 
	        System.out.println("-               BLACK               JACK               -");
	        System.out.println("--------------------------------------------------------\n"); 
	        
	        
	        boolean runGame = true;
	        while(runGame) {
	        	String input=gameType();
        	if(input.equals("1")) {
        		while(runGame){
	            switch(options())
	            {
	                case "deal":
	                    dealersHand = new Hand("Dealer");
	                    playersHand = new Hand("Player");
	                    splitHand = null;

	                    isPlayerDone = false;

	                    deck = initialDraw(deck, playersHand, splitHand, dealersHand);
	                    if (playersHand.getHandTotal() == BLACKJACK)
	                    {
	                        System.out.print("Player has BLACKJACK!\n\n");
	                        isPlayerDone = true;
	                        System.out.print("Dealer uncovers card...\n\n");
	                        showHands(playersHand, splitHand, dealersHand);
	                        System.out.print("Dealer's move...\n\n");
	                        deck = dealerDraw(deck, playersHand, splitHand, dealersHand);
	                        showHands(playersHand, splitHand, dealersHand);
	                        compareHands(playersHand, splitHand, dealersHand);
	                    } // end if()

	                    break; // end case "deal"

	                case "hit":
	                    if(!isPlayerDone)
	                        deck = hit(deck, playersHand, splitHand, dealersHand);
	                    else
	                        System.out.print("You must deal cards first!\n\n");
	                    break; // end case "hit"

	                case "stand":
	                    if(!isPlayerDone)
	                    {
	                        isPlayerDone = true;
	                        deck = stand(deck, playersHand, splitHand, dealersHand);
	                    } // end if()
	                    else
	                        System.out.print("You must deal cards first!\n\n");
	                    break; // end case "stand"

	                case "split":
	                    if(!isPlayerDone)
	                        splitHand = split(playersHand, splitHand, dealersHand);
	                    else
	                        System.out.print("You must deal cards first!\n\n");
	                    break; // end case "split"

	                case "exit":
	                    runGame = false;
	                    System.out.print("Game ended.\n\n");
	                    break; // end case "exit"

	                default:
	                    System.out.print("Invalid entry\n\n");
	            }
	            }// end switch()
	           }else if (input.equals("2")){
	        	   Scanner scanner=new Scanner(System.in);
	   				BufferedReader br=null;
	   				String str;
	   				System.out.println("please enter file name");
	        	   try {
		        		br=new BufferedReader(new FileReader("C:\\Users\\emmad\\eclipse-workspace\\BlackJackGame\\src\\main\\resources\\textfiles\\"+scanner.next()));
		        		//System.out.println("here");

		        		//System.out.println(br.readLine());
		        		str=br.readLine();
			        	while(runGame) {
		        	switch(options())
		            {
		                case "deal":
		                    dealersHand = new Hand("Dealer");
		                    playersHand = new Hand("Player");
		                    splitHand = null;

		                    isPlayerDone = false;
				        	deck=initDeck(str,deck);
				        	
		                    deck = initialDraw(deck, playersHand, splitHand, dealersHand);

		                    if (playersHand.getHandTotal() == BLACKJACK)
		                    {
		                        System.out.print("Player has BLACKJACK!\n\n");
		                        isPlayerDone = true;
		                        System.out.print("Dealer uncovers card...\n\n");
		                        showHands(playersHand, splitHand, dealersHand);
		                        System.out.print("Dealer's move...\n\n");
		                        deck = dealerDraw(deck, playersHand, splitHand, dealersHand);
		                        showHands(playersHand, splitHand, dealersHand);
		                        compareHands(playersHand, splitHand, dealersHand);
		                    } // end if()

		                    break; // end case "deal"

		                case "hit":
		                    if(!isPlayerDone)
		                        deck = hit(deck, playersHand, splitHand, dealersHand);
		                    else
		                        System.out.print("You must deal cards first!\n\n");
		                    break; // end case "hit"

		                case "stand":
		                    if(!isPlayerDone)
		                    {
		                        isPlayerDone = true;
		                        deck = stand(deck, playersHand, splitHand, dealersHand);
		                    } // end if()
		                    else
		                        System.out.print("You must deal cards first!\n\n");
		                    break; // end case "stand"

		                case "split":
		                    if(!isPlayerDone)
		                        splitHand = split(playersHand, splitHand, dealersHand);
		                    else
		                        System.out.print("You must deal cards first!\n\n");
		                    break; // end case "split"

		                case "exit":
		                    runGame = false;
		                    System.out.print("Game ended.\n\n");
		                    break; // end case "exit"

		                default:
		                    System.out.print("Invalid entry\n\n");
		            }}// end switch()
	        	   }catch (IOException e) {
	   		    		System.out.println("file not found!");
	   		    	}
  		    		//gameType();

	           }
        	}
	    } // end main()

	   
	    public static Deck initDeck(String gameType,Deck deck) {
	    	String[] suit=new String[50];
	    	int []rank=new int[50];
	    	int counter=0;
	    	deck=new Deck();
				for(int i=0;i<gameType.length()-1;i+=2) {
					char x=gameType.charAt(i);
					//System.out.println(x);
					//char y=str.charAt(1);
					switch (x) {
					case 'S':
						suit[counter]="SPADE";
						break;
					case 'D':
						suit[counter]="DIAMOND";
						break;
					case 'H':
						suit[counter]="HEART";
						break;
					case 'C':
						suit[counter]="CLUB";
						break;	
					default:
						break;
					}
					counter++;
				}
			counter=0;
					for(int i=1;i<gameType.length();i+=2) {
						//System.out.println(gameType.charAt(i));
						if(gameType.charAt(i)=='A') 
							rank[counter]=1;
						else if(gameType.charAt(i)=='J')
							rank[counter]=11;
						else if(gameType.charAt(i)=='Q')
							rank[counter]=12;
						else if(gameType.charAt(i)=='K')
							rank[counter]=13;
						else {
						rank[counter]=Character.getNumericValue(gameType.charAt(i));
						}
						counter++;
						//System.out.println(rank[i]);

					}
					//System.out.println(counter);
				for(int i=0;i<=counter;i++) {
					//System.out.println(suit[counter-i]+"_"+rank[counter-i]);
					deck.push(new Card(suit[counter-i],rank[counter-i]));
					
				}
				return deck;
		}

//	    public void initDeck(BufferedReader buff) {
//	    	String oneLine = buff.readLine();
//		}

		public static Hand split(Hand player, Hand split, Hand dealer)
	    {
	        if(player == null)
	            System.out.print("You must deal cards first!\n\n");
	        else if(player.getHandSize() == 2 && player.bothEqual())
	        {
	            split = new Hand("Player");
	            split.insert(player.deleteFirst());

	            showHands(player, split, dealer);
	            compareHands(player, split, dealer);
	        } // end else if()
	        else if(!player.bothEqual())
	            System.out.print("Both card values must be the same!\n\n");
	        else
	            System.out.print("You must have no more than 2 cards to split!\n\n");

	        return split;
	    } // end split()

	    public static Deck stand(Deck deck, Hand player, Hand split, Hand dealer)
	    {
	        if(player == null)
	            System.out.print("You must deal cards first!\n\n");
	        else
	        {   
	            isPlayerDone = true;
	            System.out.print("Dealer uncovers card...\n\n");
	            showHands(player, split, dealer);
	            System.out.print("Dealer's move...\n\n");
	            deck = dealerDraw(deck, player, split, dealer);
	            showHands(player, split, dealer);
	            compareHands(player, split, dealer);
	        } // end else

	        return deck;
	    } // end stay()

	    public static Deck hit(Deck deck, Hand player, Hand split, Hand dealer)
	    {
	        if(player == null)
	            System.out.print("You must deal cards first!\n\n");
	        else
	        {       
	            deck = drawFromDeck(deck, player);
	            System.out.print("\n");

	            if(split != null)
	            {
	                deck = drawFromDeck(deck, split);
	                System.out.print("\n");
	            } // end if()

	            showHands(player, split, dealer);
	            compareHands(player, split, dealer);

	            if (player.getHandTotal() == BLACKJACK)
	            {
	                System.out.print("Player has BLACKJACK!\n\n");
	                isPlayerDone = true;
	                System.out.print("Dealer uncovers card...\n\n");
	                showHands(player, split, dealer);
	                System.out.print("Dealer's move...\n\n");
	                deck = dealerDraw(deck, player, split, dealer);
	                showHands(player, split, dealer);
	                compareHands(player, split, dealer);
	            } // end if()
	            else if(player.getHandTotal() > BLACKJACK)
	            {
	                System.out.print("Player Busted!\n\n");
	                isPlayerDone = true;
	                System.out.print("Dealer uncovers card...\n\n");
	                showHands(player, split, dealer);
	                compareHands(player, split, dealer);
	            }
	        } // end else

	        return deck;
	    } // end hit()

	    public static Deck dealerDraw(Deck deck, Hand player, Hand split, Hand dealer)
	    {
	        if(player.getHandTotal() <= BLACKJACK)
	        {
	            // Dealer takes a precaution and only draws 
	            // if hand total is less than or equal to 16.
	            while(dealer.getHandTotal() <= 16 && 
	                    (dealer.getHandTotal() <= player.getHandTotal() || 
	                    (split != null  && dealer.getHandTotal() <= split.getHandTotal())))
	                deck = drawFromDeck(deck, dealer);

	            // Player has reached BLACKJACK!
	            // There's no or little chance to win, 
	            // dealer risks and draws even if total is high.
	            if (player.getHandTotal() == BLACKJACK || (split != null  && 
	                    split.getHandTotal() == BLACKJACK))
	                while(dealer.getHandTotal() < BLACKJACK)
	                    deck = drawFromDeck(deck, dealer);
	        } // end if()

	        return deck;
	    } // dealerDraw()

	    public  static Deck drawFromDeck(Deck deck, Hand hand)
	    {
	        deck = checkDeck(deck);

	        Card temp = new Card(deck.pop());

	        if (hand.getName().equals("Dealer") && !isPlayerDone)
	        {
	            if(hand.getHandSize() < 1)
	                System.out.print("Drawing Dealer's card... X_X");
	            else
	                System.out.print("Drawing Dealer's card... " + temp.toString());
	        } // end if()
	        else
	        {
	            if(hand.getName().equals("Dealer"))
	                System.out.print("Drawing Dealer's card... " + temp.toString() + "\n");
	            else
	                System.out.print("Drawing Player's card... " + temp.toString());
	        } // end else

	        System.out.print("\n");

	        hand.insert(temp);

	        return deck;
	    } // end drawFromDeck()

	    public static void compareHands(Hand player, Hand split, Hand dealer)
	    {
	        if (isPlayerDone)
	        {
	            if(player.getHandTotal() > BLACKJACK || 
	                    (split != null && split.getHandTotal() > BLACKJACK))
	            {
	                System.out.print("Player Busted!\n");
	                if(dealer.getHandTotal() <= BLACKJACK)
	                    System.out.print("Dealer Wins!\n\n");
	            } // end if()
	            else if(dealer.getHandTotal() > BLACKJACK)
	            {
	                System.out.print("Dealer Busted!\n");
	                if(player.getHandTotal() <= BLACKJACK || 
	                        (split != null && split.getHandTotal() <= BLACKJACK))
	                    System.out.print("Player Wins!\n\n");
	            } // end else if()
	            else if(dealer.getHandTotal() > BLACKJACK && 
	                    (player.getHandTotal() > BLACKJACK || 
	                    (split != null && split.getHandTotal() > BLACKJACK)))
	            {
	                System.out.print("Both Busted!\n");
	            } // end else if()
	            else
	            {
	                if((player.getHandTotal() > dealer.getHandTotal() && 
	                        player.getHandTotal() <= BLACKJACK) || 
	                        (split != null && (split.getHandTotal() > dealer.getHandTotal() && 
	                        player.getHandTotal() <= BLACKJACK)))
	                    System.out.print("Player Wins!\n\n");
	                else if((player.getHandTotal() < dealer.getHandTotal() && 
	                        dealer.getHandTotal() <= BLACKJACK) || 
	                        (split != null && (split.getHandTotal() < dealer.getHandTotal() && 
	                        dealer.getHandTotal() <= BLACKJACK)))
	                    System.out.print("Dealer Wins!\n\n");

	                if(player.getHandTotal() == BLACKJACK || 
	                    (split != null && split.getHandTotal() == BLACKJACK))
	                    System.out.print("Player has BLACKJACK!\n\n");
	                if(dealer.getHandTotal() == BLACKJACK)
	                    System.out.print("Dealer has BLACKJACK!\n\n");
	            } // end else
	        } // end if()
	    } // end compareHands()

	    public  static Deck checkDeck(Deck deck)
	    {
	        if(deck == null)
	            deck = createDeck();
	        else if(deck.isEmpty())
	        {
	            System.out.print("\nDeck is empty! You must create and shuffle new deck of cards!\n\n");
	            deck = createDeck();
	        } // end else if()
	        return deck;
	    } // end checkDeck()

	    public  static Deck createDeck()
	    {
	        System.out.println("Creating deck...");
	        Deck deck = new Deck();
	        deck.createDeck();
	        System.out.println("Shuffling deck...");
	        deck.shuffleDeck();
	        System.out.print("\n");

	        return deck;
	    } // end createDeck()

	    public  static Deck initialDraw(Deck deck, Hand player, Hand split, Hand dealer)
	    {
	        deck = drawFromDeck(deck, player);
	        deck = drawFromDeck(deck, player);
	        deck = drawFromDeck(deck, dealer);
	        deck = drawFromDeck(deck, dealer);

	        System.out.print("\n");

	        showHands(player, split, dealer);
	        compareHands(player, split, dealer);

	        return deck;
	    } // end initialDraw()

	    public static void showHands(Hand player, Hand split, Hand dealer)
	    {
	        System.out.print("Dealers Hand:");

	        if(!isPlayerDone)
	        {
	            dealer.peek();
	            System.out.print(" X_X = " + dealer.peekValue() + "\n");
	        } // end if()
	        else
	        {
	            dealer.displayHand();
	            System.out.print(" = " + (dealer.getHandTotal() == BLACKJACK ? 
	                    dealer.getHandTotal() + " : BLACKJACK!" : 
	                    ((dealer.getHandTotal() > BLACKJACK) ? 
	                    dealer.getHandTotal() + " : BUSTED!" : 
	                    dealer.getHandTotal())) + "\n");
	        } // end else

	        System.out.print("Players Hand:");
	        player.displayHand();
	        System.out.print(" = " + (player.getHandTotal() == BLACKJACK ? 
	                player.getHandTotal() + " : BLACKJACK!" : 
	                ((player.getHandTotal() > BLACKJACK) ? 
	                player.getHandTotal() + " : BUSTED!" : 
	                player.getHandTotal())) + "\n");

	        if (split != null)
	        {
	            System.out.print("Players Hand:");
	            split.displayHand();
	            System.out.print(" = " + (split.getHandTotal() == BLACKJACK ? 
	                    split.getHandTotal() + " : BLACKJACK!" : 
	                    ((split.getHandTotal() > BLACKJACK) ? 
	                    split.getHandTotal() + " : BUSTED!" : 
	                    split.getHandTotal())) + "\n\n");
	        } // end if()
	        else
	            System.out.print("\n");
	    } // end showHands()
	    public static String gameType() throws IOException{
	    	System.out.print("1 for console or 2 for file?");
	        InputStreamReader isr = new InputStreamReader(System.in);
	        BufferedReader br = new BufferedReader(isr);
	        String s = br.readLine();
	        System.out.print("\n"); 
	        return s;
		}
	    public static String options() throws IOException
	    {
	        System.out.print("deal, hit, split, stand, exit: ");
	        InputStreamReader isr = new InputStreamReader(System.in);
	        BufferedReader br = new BufferedReader(isr);
	        String s = br.readLine();
	        System.out.print("\n"); 
	        return s;
	    } // end options()
}
