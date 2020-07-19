import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCards() {

        for (SuitType suitType : SuitType.values()) {
            for (RankType rankType : RankType.values()) {
                Card card = new Card(suitType, rankType);
                this.cards.add(card);
            }
        }
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public ArrayList<String> printCards(){
        ArrayList<String> cardString = new ArrayList<String>();
        for (Card card : this.cards){
            String cardDetails = card.toString();
            cardString.add(cardDetails);
        }
        return cardString;
    }

    public void shuffleCards(){
        Collections.shuffle(this.cards);
    }

    public void dealCard(Player player){
        Card card = this.cards.remove(0);
        player.addCard(card);
    }

}
