import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Players {
    static int winner = -1;
    static int time = 10;
    ArrayList<Card> cards = new <Card>ArrayList(4);

    public synchronized void playerWork(Pile p[], int playerNumber) throws InterruptedException {
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
            Thread.sleep(time+1000);
            wait(2000  );
            time = time + 200;
        }

        if (winner != -1) {
            System.out.println("Player " + playerNumber + "GoodBye Congrats To Player-" + winner);
        }
    }


    private boolean isPlayerWin() throws InterruptedException {
        HashMap<Card, Integer> hm = new HashMap();
        for (int i = 0; i < cards.size(); i++) {
            if (hm.containsKey(cards.get(i))) {
                hm.put(cards.get(i), hm.get(cards.get(i)) + 1);
            } else {
                hm.put(cards.get(i), 1);
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
        for (int i = 0; i < cards.size(); i++) {
            if (hm.containsKey(cards.get(i))) {
                hm.put(cards.get(i), hm.get(cards.get(i)) + 1);
            } else {
                hm.put(cards.get(i), 1);
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
        cards.remove(new Card(minOccuranceValue));
        System.out.println("CardsWithDrawn-" + minOccuranceValue);
        return new Card(minOccuranceValue);
    }

    private void addPileCardToPlayer(Card c) {
        cards.add(c);
    }

    private void addCardToPile(Pile[] p, int playerNumber, Card card) {
        p[(playerNumber + 1) % 4].cards.add(card);
    }

    private Card withDrawCardFromPile(Pile p[], int playerNumber) {
        int pileToWithDraw = playerNumber;
        return p[playerNumber].cards.remove(0);//top
    }

    private void printPlayerCard(int playerNumber) throws InterruptedException {
        System.out.print("Player number " + playerNumber + " cards-");
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i).cardValue + ",");
        }
        System.out.println();


    }
}
