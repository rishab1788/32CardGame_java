import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

public class Players implements Runnable {
    static int winner = -1;
    static int time = 10;
    static int turn = 0;
    ArrayList<Card> cardsListOfPlayers[] = new ArrayList[4];
    Pile piles[] = new Pile[4];

    Players() {
        for (int i = 0; i < 4; i++) {
            cardsListOfPlayers[i] = new ArrayList(4);
        }
        for (int i = 0; i < 4; i++) {
            piles[i] = new Pile();
        }

    }

    @Override
    public synchronized void run() {
        while (winner == -1) {
            int playerNumber = Integer.parseInt(Thread.currentThread().getName());
            playerNumber = playerNumber - 1;
            while (turn != playerNumber) {
                if (winner != -1) {
                    System.out.println("Bye TO EveryOne "+ playerNumber + " Congrates to " + winner);
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName());
            printPlayerCard(playerNumber);
            Card withDrawnCardFromPile = withDrawCardFromPile(playerNumber);
            addPileCardToPlayer(playerNumber, withDrawnCardFromPile);
            printPlayerCard(playerNumber);
            if (isPlayerWon(playerNumber) == true) {
                System.out.println("player " + playerNumber + "Won The Match");

                winner = playerNumber;

                notifyAll();
                break;
            } else {
                Card withDrawnCardFromPlayer = playerCardToWithDraw(playerNumber);
                addCardToNextPile(playerNumber, withDrawnCardFromPlayer);
                printPlayerCard(playerNumber);
                turn++;
                turn = turn % 4;
            }
            notifyAll();
        }

        System.out.print("BYE..");
        if (winner != -1) {
            System.out.println("Player " + "GoodBye Congrats To Player-" + winner);
        }

    }

    private void addCardToNextPile(int playerNumber, Card card) {
        piles[(playerNumber + 1) % 4].cards.add(card);
    }

    private Card withDrawCardFromPile(int playerNumber) {
        int pileToWithDraw = playerNumber;
        return piles[playerNumber].cards.remove(0);//top
    }

    private synchronized void printPlayerCard(int playerNumber) {

        System.out.print("Player number " + playerNumber + " cards-");
        for (int i = 0; i < cardsListOfPlayers[playerNumber].size(); i++) {
            System.out.print(cardsListOfPlayers[playerNumber].get(i).cardValue + ",");
        }
        System.out.println();
    }

    private void addPileCardToPlayer(int playerNumber, Card c) {
        cardsListOfPlayers[playerNumber].add(c);
    }

    private boolean isPlayerWon(int playerNumber) {
        HashMap<Card, Integer> hm = new HashMap();
        for (int i = 0; i < cardsListOfPlayers[playerNumber].size(); i++) {
            if (hm.containsKey(cardsListOfPlayers[playerNumber].get(i))) {
                hm.put(cardsListOfPlayers[playerNumber].get(i), hm.get(cardsListOfPlayers[playerNumber].get(i)) + 1);
            } else {
                hm.put(cardsListOfPlayers[playerNumber].get(i), 1);
            }
        }
        int maxOccurance = 0;
        int maxOccuranceValue = 0;
        for (Map.Entry<Card, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > maxOccurance) {
                maxOccurance = entry.getValue();
                maxOccuranceValue = entry.getKey().cardValue;

            }

        }
        System.out.println("Max Occurance-" + maxOccurance);
        if (maxOccurance == 4) {
            return true;
        } else {
            return false;
        }

    }

    private Card playerCardToWithDraw(int playerNumber) {

        HashMap<Card, Integer> hm = new HashMap();
        for (int i = 0; i < cardsListOfPlayers[playerNumber].size(); i++) {
            if (hm.containsKey(cardsListOfPlayers[playerNumber].get(i))) {
                hm.put(cardsListOfPlayers[playerNumber].get(i), hm.get(cardsListOfPlayers[playerNumber].get(i)) + 1);
            } else {
                hm.put(cardsListOfPlayers[playerNumber].get(i), 1);
            }
        }
        int minOccurance = 10;
        int minOccuranceValue = 0;
        Random rand = new Random();
        int tempvaiable = rand.nextInt(5);
        for (Map.Entry<Card, Integer> entry : hm.entrySet()) {
            if (entry.getValue() <= minOccurance) {
                minOccurance = entry.getValue();
                minOccuranceValue = entry.getKey().cardValue;
                tempvaiable--;
                if (tempvaiable == 0 && minOccurance == 1) {
                    break;
                }
            }
        }
        cardsListOfPlayers[playerNumber].remove(new Card(minOccuranceValue));
        System.out.println("CardsWithDrawn-" + minOccuranceValue);
        return new Card(minOccuranceValue);
    }
    /*public synchronized void playerWork(Pile p[], int playerNumber) throws InterruptedException {
        while (winner == -1) {
            System.out.println("-----------------------------------------");
            printPlayerCard(playerNumber);
            Card c = withDrawCardFromPile(p, playerNumber);
            addPileCardToPlayer(c);
            printPlayerCard(playerNumber);
            if (isPlayerWin() == true) {
                System.out.println("player " + playerNumber + "Won The Match");
                winner = playerNumber;
                return;
            }
            Card withDrawCard = playerCardToWithDraw();
            printPlayerCard(playerNumber);
            addCardToPile(p, playerNumber, withDrawCard);
            Thread.sleep(time + 1000);
            wait(2000);
            time = time + 200;
        }
        if (winner != -1) {
            System.out.println("Player " + playerNumber + "GoodBye Congrats To Player-" + winner);
        }
    }

*/
/*


    private boolean isPlayerWin() throws InterruptedException {
        HashMap<Card, Integer> hm = new HashMap();
        for (int i = 0; i < cardsListOfPlayers.size(); i++) {
            if (hm.containsKey(cardsListOfPlayers.get(i))) {
                hm.put(cardsListOfPlayers.get(i), hm.get(cardsListOfPlayers.get(i)) + 1);
            } else {
                hm.put(cardsListOfPlayers.get(i), 1);
            }
        }
        int maxOccurance = 0;
        int maxOccuranceValue = 0;
        for (Map.Entry<Card, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > maxOccurance) {
                maxOccurance = entry.getValue();
                maxOccuranceValue = entry.getKey().cardValue;

            }

        }

        System.out.println("Max Occurance-" + maxOccurance);
        if (maxOccurance == 4) {
            return true;
        } else {
            return false;
        }

    }

    private Card playerCardToWithDraw() {

        HashMap<Card, Integer> hm = new HashMap();
        for (int i = 0; i < cardsListOfPlayers.size(); i++) {
            if (hm.containsKey(cardsListOfPlayers.get(i))) {
                hm.put(cardsListOfPlayers.get(i), hm.get(cardsListOfPlayers.get(i)) + 1);
            } else {
                hm.put(cardsListOfPlayers.get(i), 1);
            }
        }
        int minOccurance = 10;
        int minOccuranceValue = 0;
        for (Map.Entry<Card, Integer> entry : hm.entrySet()) {
            if (entry.getValue() < minOccurance) {
                minOccurance = entry.getValue();
                minOccuranceValue = entry.getKey().cardValue;

            }

        }
        cardsListOfPlayers.remove(new Card(minOccuranceValue));
        System.out.println("CardsWithDrawn-" + minOccuranceValue);
        return new Card(minOccuranceValue);
    }

    private void addPileCardToPlayer(Card c) {
        cards.add(c);
    }
*/


}
