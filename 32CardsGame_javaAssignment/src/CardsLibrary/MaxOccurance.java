package CardsLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MaxOccurance {

    public static boolean findMaxOccurance(ArrayList<Cardss> cards) {
        HashMap<Cardss, Integer> hm = new HashMap();
        for (int i = 0; i < cards.size(); i++) {
            if (hm.containsKey(cards.get(i))) {
                hm.put(cards.get(i), hm.get(cards.get(i)) + 1);
            } else {
                hm.put(cards.get(i), 1);
            }
        }
        int maxOccurance = 0;
        int maxOccuranceValue = 0;
        for (Map.Entry<Cardss, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            if (entry.getValue() > maxOccurance) {
                maxOccurance = entry.getValue();
                maxOccuranceValue = entry.getKey().value;
            }
        }
        System.out.println(maxOccurance);
        if (maxOccurance == 4) {
            return true;
        } else {
            return false;
        }


    }


    public static void main(String[] args) {
        ArrayList<Cardss> cards = new ArrayList();
        cards.add(new Cardss(4));
        cards.add(new Cardss(4));
        cards.add(new Cardss(1));
        cards.add(new Cardss(4));
        cards.add(new Cardss(4));
        Scanner s = new Scanner(System.in);
        System.out.println(findMaxOccurance(cards));

        /*


        HashSet<Cardss> ht = new HashSet();
        for (int i = 0; i < cards.size(); i++) {

            if (ht.contains(cards.get(i))) {
                System.out.println(cards.get(i));
            } else {
                ht.add(cards.get(i));
            }
        }

*/
    }
}