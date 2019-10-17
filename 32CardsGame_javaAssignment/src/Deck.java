import java.util.Random;

public class Deck {
    Card card[] = new Card[32];
    CardsArrangement cardsArrangement = new CardsArrangement();
    Random rand = new Random();
    FileOperation fo = new FileOperation();

    Deck() {
        for (int i = 0; i < 32; i++) {
            card[i] = new Card();
            card[i].setCardValue(cardsArrangement.a[i % 8]);
        }

        String s[] = fo.fileReader().split("[\n ' ']");

        int index = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length(); j++) {
                int value = s[i].charAt(j) - '0';
                card[index].setCardValue(value);
                System.out.println(card[index].getCardValue());
                index++;
            }
        }


    }

    public static void main(String[] args) {

        Deck d = new Deck();

    }

}
