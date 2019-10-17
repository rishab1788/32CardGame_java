# 32CardGame_java

Java Programming Assignment
Use Java threads to implement players for a simple card game. The game
has 4 players and 4 piles of cards, one between each pair of players. The
players draw cards from the top and discard cards to the bottom of the piles
in the following pattern:

Player Draw Pile Discard Pile
1 1 2
2 2 3
3 3 4
4 4 1
The first player to collect 4 cards of the same denomination wins the game.
The card deck has 32 cards: 4 of each denomination from 0 through 7.
However, your program must accept denominations greater than 7, for testing
purposes (for testing, we will create input decks with 4 of only one
denomination between 0 and 7, 3 of the other denominations between 0 and
7, and fill out the 32 card deck with denominations greater than 7, with fewer
than 4 of any of those denominations). Initially each player is dealt 4 cards in
round robin fashion starting from player 1, and the remainder of the cards are
added to the piles, starting from Pile 1, in round robin fashion (with the first
card added to each pile the first one drawn, as in a queue).
Strategy
The simple strategy you should use has each player preferring certain card
denominations. In particular, player 1 prefers 0&#39;s and 1&#39;s, player 2 prefers 2&#39;s
and 3&#39;s, player 3 prefers 4&#39;s and 5&#39;s, and player 4 prefers 6&#39;s and 7&#39;s. This
means that (after drawing a card from the proper deck) a player discards any
card from a non-preferred denomination, if possible. If that is not possible,
then the player discards a card from the denomination with fewer cards. To
ensure progress in the game, a player may not indefinitely hold a card from a
non-preferred denomination. This means that you must implement some
mechanism for selecting a non-preferred denomination card that ensures that
any particular non-preferred card is eventually selected for discard.
For example, if player 2 has (after drawing a card from the proper deck) one
2, one 4, one 5, and a pair of 3&#39;s, then the player would discard either the 4 or
the 5. If player 3 had the same set of cards, the player would discard a 2 or a
3. An example of the other case, is that if player 2 had three 2&#39;s and a pair of
3&#39;s, then the player must discard a 3.
Implementation
Your Java program should start from a class named Main (which must have a
member function named main), read test data from an input data file specified

on the command line and write it&#39;s output to standard output.
In addition to a Main class that starts the game application, reads the input
deck, deals the initial hands, and creates the various threads needed to run
the game, you will need to build classes for the players and for the card piles.
For the various classes, some of your methods will need to be synchronized
to prevent multiple threads from accessing shared data simultaneously.
In addition, you will need to implement a routine that handles stopping players
who did not win the game. The winning player can simply exit the run
procedure that started its thread execution. However, this player must notify
the other player threads that they need to stop (e.g., by setting a member
value in the player class via a synchronized method, that is subsequently
checked by all player threads). Each thread must print a message when it
finishes (e.g., &quot;Player 1 wins and exits&quot;, &quot;Player 2 exits&quot;, etc.). Also, drawing
and discarding is an atomic action, so a player must discard after a draw,
even when the player wins. This means a player always has 4 cards in the
hand whenever printing the contents of a hand.
Each player must demonstrate card playing actions by printing the card
drawn, the card discarded and the current hand for each action. The action
must be labeled with the player number. Each player&#39;s actions should be
written to standard output.
For example, intermediate moves should print something like the following:
player 1 draws a 4
player 1 discards 4
player 1 hand 5 5 5 6
The final move of the winner prints something like the following:
player 3 draws a 7
player 3 discards a 3
player 3 hand 7 7 7 7
player 3 wins
player 3 exits
The card deck is read from standard input.
An example of an initial deck looks like this:
2 3 4 0 7 1 6 5
6 5 0 2 1 7 4 3
3 6 1 5 4 2 0 7
1 2 3 0 5 6 7 4
As the final output for each player at the end of the game, the player should
print three lines, appropriately customized for that player, to the standard
output. The first states whether the player won or lost, the second lists the
player&#39;s hand at the end of the game, and the third lists the contents of the
pile the player draws from at the end of the game. The lines look like this, with
required keywords in bold:

player 2 WIN yes (or no)
player 2 HAND card1 card2 card3 card4
player 2 DRAWPILE contents of draw pile, separated by spaces (e.g., 2 5 3)
Instructions for submitting your work
Jar the source code and a Maven POM or Ant config file that compiles and
executes the code and a README file that describes how to compile and
execute the program and email it.
Please mention any online resources like stackoverflow that you referred to
for your solution.
