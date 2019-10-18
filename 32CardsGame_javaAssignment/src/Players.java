import java.util.ArrayList;
import java.util.HashMap;

public class Players {

    ArrayList<Card> cards = new <Card>ArrayList(4);

    public void playerWork(Pile p[], int playerNumber) throws InterruptedException {
        synchronized (this) {
            printPlayerCard(playerNumber);
            Card c = withDrawCardFromPile(p, playerNumber);
            addwithCardToPlayer(c);
            playerCardToWithDraw();
            addCardToPile(p, playerNumber);
        }
    }

    private void playerCardToWithDraw() {
        HashMap<Card, Integer> hm = new HashMap();
        for (int i = 0; i < cards.size(); i++) {
            if (hm.containsKey(cards.get(i))) {
                hm.put(cards.get(i), hm.get(cards.get(i)) + 1);
            } else {
                hm.put(cards.get(i), 0);
            }
        }

    }

    private void addwithCardToPlayer(Card c) {
        cards.add(c);
    }

    private void addCardToPile(Pile[] p, int playerNumber) {
        //p[(playerNumber + 1) % 4].cards.add();
    }

    private Card withDrawCardFromPile(Pile p[], int playerNumber) {
        int pileToWithDraw = playerNumber;

        return p[playerNumber].cards.remove(0);//top
    }

    private void printPlayerCard(int playerNumber) throws InterruptedException {
        for (int i = 0; i < cards.size(); i++) {
            System.out.print("Player number card-" + playerNumber + " ");
            System.out.print(cards.get(i).cardValue);
            System.out.println();
        }

    }
}
