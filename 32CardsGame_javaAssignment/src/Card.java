public class Card {
    int cardValue;

    Card() {

    }

    Card(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object != null && object instanceof Card) {
            isEqual = (this.cardValue == ((Card) object).cardValue);
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        return this.cardValue;
    }

}
