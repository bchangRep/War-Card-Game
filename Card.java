/* Author: Brian Chang
 * The Card class will use the method, createDeck(), to create a standard 52 deck of cards.
 * Basic methods to access an individual card's Suit, Rank, and Value are provided.
 * No methods to mutate an individual card's Suit, Rank, or Value are provided.
 */

import java.util.ArrayList;

public class Card
{
	public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}
	public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}
	private Suit[] suits = Suit.values();
	private Rank[] ranks = Rank.values();
	private Suit suit;
	private Rank rank;
	ArrayList<Card> deck = new ArrayList<Card>();
	
	public Card()
	{
		createDeck();
	}
	
	public Card(Suit aSuit, Rank aRank)
	{
		suit = aSuit;
		rank = aRank;
	}
	
	public Suit getSuit()
	{
		return suit;
	}
	
	public Rank getRank()
	{
		return rank;
	}
	
	public int getValue()
	{
		return rank.ordinal();
	}
	
	// Creates a standard deck of 52 cards.
	public void createDeck()
	{
		for (int s = 0; s < suits.length; s++)
		{
			for (int r = 0; r < ranks.length; r++)
			{
				deck.add(new Card(suits[s], ranks[r]));
			}
		}
	}
	/* Will display cards in the form: "rank" of "suit".
	 * Example: TWO of HEARTS, THREE of SPADES 
	 */
	public void display()
	{
		System.out.println(rank + " of " + suit);
	}
}