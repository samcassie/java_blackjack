import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {


    Deck deck1;
    Player player;
    Card card1;
    Card card2;


    @Before
    public void before() {
        deck1 = new Deck();
        player = new Player("Niall");
        deck1.addCards();
        deck1.shuffleCards();
        card1 = new Card(SuitType.HEARTS, RankType.ACE);
        card2 = new Card(SuitType.DIAMONDS, RankType.ACE);
    }

    @Test
    public void canTakeAddCard() {
        deck1.dealCard(player);
        deck1.dealCard(player);
        assertEquals(2, player.getHand().size());
        assertEquals(50, deck1.getCards().size());
    }

    @Test
    public void canCountCards() {

        deck1.addCards();
        deck1.shuffleCards();
        deck1.dealCard(player);
        deck1.dealCard(player);
        assertEquals(true, player.cardCount() > 0);
    }

    @Test
    public void canAddToWallet(){
        player.addWalletFunds(1000);
        assertEquals(1000, player.getWallet());
    }

    @Test
    public void canRemoveCardFromHand(){
        player.addCard(card1);
        player.addCard(card2);
        player.removeCardFromHand(card1);
        assertEquals(1, player.cardCount());
    }
}
