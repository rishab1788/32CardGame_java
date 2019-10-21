public class Main implements Runnable {
    Players players[] = new Players[4];
    Pile piles[] = new Pile[4];
    Deck d = new Deck();

    Main() { //instansication
        for (int i = 0; i < 4; i++) {
            piles[i] = new Pile();
        }
        //instansication

        for (int i = 0; i < 4; i++) {
            players[i] = new Players();
        }
        distributeCardsPlayersPile();
    }

    public static void main(String[] args) throws InterruptedException {

        Main hand = new Main();

        Thread t1 = new Thread(hand);
        t1.setName("1");
        Thread t2 = new Thread(hand);
        t2.setName("2");
        Thread t3 = new Thread(hand);
        t3.setName("3");
        Thread t4 = new Thread(hand);
        t4.setName("4");

        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();
        Thread.sleep(100);
        t4.start();


    }

    @Override
    public void run() {

        int playerNumber = Integer.parseInt(Thread.currentThread().getName());
        try {
            players[playerNumber - 1].playerWork(piles, playerNumber - 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void distributeCardsPlayersPile() {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                players[i].cards.add(d.card[temp]);
                System.out.println("player" + i + " = " + d.card[temp].getCardValue());
                temp++;
            }
            for (int j = 4; j < 8; j++) {
                piles[i].cards.add(d.card[temp]);
                System.out.println("pile" + i + " = " + d.card[temp].getCardValue());
                temp++;
            }
        }

    }


}
