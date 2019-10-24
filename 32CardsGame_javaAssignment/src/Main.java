import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class Main implements Runnable {

    Deck d = new Deck();


    Main() { //instansication

    }

    public static void main(String[] args) throws InterruptedException {

        Main hand = new Main();
        Players player = new Players();
        System.out.print(player);
        hand.distributeCardsPlayersPile(player);
        CountDownLatch startSignal = new CountDownLatch(1);
        Thread t1 = new Thread(player);
        t1.setName("1");
        Thread t2 = new Thread(player);
        t2.setName("2");
        Thread t3 = new Thread(player);
        t3.setName("3");
        Thread t4 = new Thread(player);
        t4.setName("4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    @Override
    public void run() {

     /*   int playerNumber = Integer.parseInt(Thread.currentThread().getName());

        try {
            players[playerNumber - 1].playerWork(piles, playerNumber - 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/

    }

    public void distributeCardsPlayersPile(Players players) {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                players.cardsListOfPlayers[i].add(d.card[temp]);
                System.out.println("player" + i + " = " + d.card[temp].getCardValue());
                temp++;
            }
            for (int j = 4; j < 8; j++) {
                players.piles[i].cards.add(d.card[temp]);
                System.out.println("pile" + i + " = " + d.card[temp].getCardValue());
                temp++;
            }
        }

    }
}
