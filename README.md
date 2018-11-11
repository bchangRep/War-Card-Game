The 2 files War.bat and WarGame.jar allow you to run this game as an executable.
 -The display will be in the command prompt window, and it will simulate 1 game of war.
To do this you will need to have the War.bat and WarGame.jar file located in the same folder.
Run the War.bat file to run the game.
For security reasons you may not be able to run the .bat file. In that case you can create your own bat file with the following steps:

1) Open a text editor (NotePad, WordPad, NotePad++)
2) Copy and paste the following 2 lines into a new file:

java -jar WarGame.jar

pause

3) Save the file as War.bat
4) Place the War.bat and WarGame.jar file in the same folder
5) Run the War.bat file to run the game

The following section is also stated in WarGame.java

This variation of War is for 2 players and 1 standard deck of 52 cards will be divided between the 2 players.
Cards rank from high to low (Ace is highest and 2 is lowest): A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2.
Suits are ignored in this game.

Objective: The winner is determined once one player has gained all the cards, or when one player does not have enough cards to play during war.
 
How to play: Each round both players will take the top card of their deck and compare their ranks.
The player with the higher card takes both the cards and puts them at the bottom of their deck.
If the cards have the same rank a "war" occurs. 
Each player plays the next two cards of their deck, and the second cards' ranks are compared.
The player with the higher card adds all played cards to the bottom of their deck.
If the cards equal again another war occurs. 
This process repeats until one player's second card is greater than their opponent's.
The game continues until one player gains all the cards.
The order the cards are placed are the bottom of the deck is: winner's card(s) followed by loser's card(s).

In the event that a war occurs and one player does not have enough cards, the opponent automatically wins.
In the event that a war occurs and both players do not have enough cards, player 2 automatically wins.
