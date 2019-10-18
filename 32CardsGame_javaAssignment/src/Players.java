import java.util.ArrayList;

public class Players {

    ArrayList<Card> cards = new <Card>ArrayList(4);

    public void playerWork(Pile p[], int playerNumber) throws InterruptedException {
        synchronized (this) {
            printPlayerCard(playerNumber);

            withDrawCardFromPile(playerNumber);

        }
    }

    private void withDrawCardFromPile(int playerNumber) {
        int pileToWithDraw = playerNumber;

    }

    private void printPlayerCard(int playerNumber) throws InterruptedException {
        for (int i = 0; i < cards.size(); i++) {
            System.out.print("Player number card-" + playerNumber + " ");
            System.out.print(cards.get(i).cardValue);
            System.out.println();
        }

    }
}
