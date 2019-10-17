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
    }

    public static void main(String[] args) {

        Main hand = new Main();

        Thread m = new Thread(hand);

        m.start();


    }

    @Override
    public void run() {
        System.out.print("hiiii");
    }

    public void distributeCardsPlayersPile() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                players[i].cards.add(d.card[j]);
            }
            for (int j = 4; j < 8; j++) {
                piles[i].cards.add(d.card[j]);
            }
        }

    }
}
