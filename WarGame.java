/* Author: Brian Chang
 * 
 * This variation of War is for 2 players and 1 standard deck of 52 cards will be divided between the 2 players.
 * Cards rank from high to low (Ace is highest and 2 is lowest): A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2.
 * Suits are ignored in this game.
 * 
 * Objective: The winner is determined once one player has gained all the cards, 
 * or when one player does not have enough cards to play during war.
 * 
 * How to play: Each round both players will take the top card of their deck and compare their ranks.
 * The player with the higher card takes both the cards and puts them at the bottom of their deck.
 * If the cards have the same rank a "war" occurs. 
 * Each player plays the next two cards of their deck, and the second cards' ranks are compared.
 * The player with the higher card adds all played cards to the bottom of their deck.
 * If the cards equal again another war occurs. 
 * This process repeats until one player's second card is greater than their opponent's.
 * The game continues until one player gains all the cards.
 * The order the cards are placed are the bottom of the deck is: winner's card(s) followed by loser's card(s).
 * 
 * In the event that a war occurs and one player does not have enough cards, the opponent automatically wins.
 * In the event that a war occurs and both players do not have enough cards, player 2 automatically wins.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class WarGame
{
	// p1DeafaultWin is true if Player 2 does not have enough cards for war. Otherwise false.
	static boolean p1DefaultWin = false;
	// p2DeafaultWin is true if Player 1 does not have enough cards for war. Otherwise false.
	static boolean p2DefaultWin = false;
	
	public static void main (String args[])
	{
		boolean winner = false;
		//a standard deck of 52 cards is created
		Card aDeck = new Card();
		
		// Each LinkedList will represent one player's deck
		LinkedList<Card> p1Deck = new LinkedList<Card>();
        LinkedList<Card> p2Deck = new LinkedList<Card>();
        // Collections.shuffle is used to randomly shuffle the deck
        Collections.shuffle(aDeck.deck);
        // Each player is given half of the deck
        p1Deck.addAll(aDeck.deck.subList(0, aDeck.deck.size()/2 ));
        p2Deck.addAll(aDeck.deck.subList(aDeck.deck.size()/2, aDeck.deck.size()));

        while (!winner)
        {
        	Card p1Card = p1Deck.pop();
    		Card p2Card = p2Deck.pop();
    		
    		System.out.print("Player 1's card is " );
    		p1Card.display();
    	
    		System.out.print("Player 2's card is " );
    		p2Card.display();
    		
    		if (p1Card.getValue() > p2Card.getValue())
    		{
    			p1Deck.addLast(p1Card);
    			p1Deck.addLast(p2Card);
    			System.out.println("Player 1 wins the round");
    		}
    		else if (p1Card.getValue() < p2Card.getValue())
    		{
    			p2Deck.addLast(p2Card);
    			p2Deck.addLast(p1Card);
    			System.out.println("Player 2 wins the round");
    		} 
    		else
    		{
    			System.out.println("Cards are equal. War will begin!");
    			// p1WarDeck and p2WarDeck will store cards during war for respective players.
    			// p1WarDeck for Player 1 (p1Deck), and p2WarDeck for Player 2 (p2Deck)
    			ArrayList<Card> p1WarDeck = new ArrayList<Card>();
    			ArrayList<Card> p2WarDeck = new ArrayList<Card>();
    			p1WarDeck.add(p1Card);
    			p2WarDeck.add(p2Card);
    			war (p1Deck, p2Deck, p1WarDeck, p2WarDeck);
    		}
    		// Player 2 wins if Player 1 does not have enough cards for war or has no more cards.
    		if (p2DefaultWin || p1Deck.size() == 0)
    		{
    			System.out.println("Player 1 is out of cards. Player 2 wins the game");
    			winner = true;
    	    }
    		// Player 1 wins if Player 2 does not have enough cards for war or has no more cards.
    		else if (p1DefaultWin || p2Deck.size() == 0)
    	    {
    	    	System.out.println("Player 2 is out of cards. Player 1 wins the game");
    	    	winner = true;
    	    }
    		System.out.println();
        } 
	}// Main
	/* Method "war" follows the same set of rules above for:
	 * 		- Declaring a winner of a round
	 * 		- Winner adding cards to their deck
	 * 
	 * "war" has 4 parameters:
	 * deck1 will reference Player 1's deck and deck2 will reference Player 2's deck.
	 * warDeck1 will reference Player 1's war deck and warDeck2 will reference Player 2's war deck. 
	 * 
	 * "war" will first check if each deck has enough cards (2) for war.
	 * If each player has enough cards, the next 2 cards of each deck are shown.
	 * The second cards are compared. The player with the higher value card is the winner and takes all cards.
	 * If cards are equal, war is recursively called with the same parameters.
	 */
	public static void war(LinkedList<Card> deck1, LinkedList<Card> deck2,
			ArrayList<Card> warDeck1, ArrayList<Card> warDeck2)
	{
		// both player decks are checked for sufficient cards for war
		if (deck1.size() < 2)
		{
			System.out.println("Player 1 does not have enough cards for war.");
			p2DefaultWin = true;
		}
		else if (deck2.size() < 2)
		{
			System.out.println("Player 2 does not have enough cards for war.");
			p1DefaultWin = true;
		}
		else
		{
			for (int i = 0; i < 2; i++)
			{
				warDeck1.add(deck1.pop());
				warDeck2.add(deck2.pop());
			}

			System.out.println("Cards at stake for war: ");
			System.out.println("------------------------");
			System.out.println("Player 1's cards: ");
			for (int j = 0; j < warDeck1.size(); j++)
			{
				warDeck1.get(j).display();
			}
			System.out.println();
			System.out.println("Player 2's cards: ");
			for (int k = 0; k < warDeck2.size(); k++)
			{
				warDeck2.get(k).display();
			}
			System.out.println();
			System.out.print("Player 1's card is " );
			warDeck1.get(warDeck1.size()-1).display();
    	
    		System.out.print("Player 2's card is " );
    		warDeck2.get(warDeck2.size()-1).display();
    		
    		if (warDeck1.get(warDeck1.size()-1).getValue() > warDeck2.get(warDeck2.size()-1).getValue())
    		{
    			deck1.addAll(warDeck1);
    			deck1.addAll(warDeck2);
    			System.out.println("Player 1 wins the round");
    		}
    		else if (warDeck1.get(warDeck1.size()-1).getValue() < warDeck2.get(warDeck2.size()-1).getValue())
    		{
    			deck2.addAll(warDeck2);
    			deck2.addAll(warDeck1);
    			System.out.println("Player 2 wins the round");
    		}
    		else
    		{
    			System.out.println("Cards are equal. War will begin again!");
    			// if the second cards are equal again, war is recursively called
    			war(deck1, deck2, warDeck1, warDeck2);
    		}
		}
	}// static method war
}// Class
