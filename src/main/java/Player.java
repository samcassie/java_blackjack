import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private int wallet;

    public Player(String name) {
        this.hand = new ArrayList<Card>();
        this.name = name;
        this.wallet = 0;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public String printCards() {
        ArrayList<String> cardString = new ArrayList<String>();
        for (Card card : this.hand) {
            String cardDetails = card.toString();
            cardString.add(cardDetails);
        }
        String sentence = new String();
        for (String card : cardString) {
            sentence += (card + " and a ");
        }
        return sentence.substring(0, sentence.length() - 7) + ".";
    }

    public int cardCount() {
        int handTotal = 0;
        for (int i = 0; i < this.hand.size(); ++i) {
            handTotal += this.hand.get(i).getValueFromEnum();
        }
        return handTotal;
    }

    public int getWallet() {
        return wallet;
    }

    public void addWalletFunds(int funds) {
        wallet += funds;
    }

    public void loseWalletFunds(int funds) {
        wallet -= funds;
    }

    public void removeCardFromHand(Card card){
        this.hand.remove(card);
    }

}
