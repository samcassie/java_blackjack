import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.oops.Array;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Card card;
    Deck deck1;
    Deck deck2;

    @Before
    public void before(){
        deck1 = new Deck();
        deck2 = new Deck();
    }

    @Test
    public void canAddCardsToDeck(){
        deck1.addCards();
        System.out.println(deck1.printCards());
        assertEquals(52, deck1.getCards().size());
    }

    @Test
    public void canShuffle(){

        deck1.addCards();
        deck2.addCards();
        deck2.shuffleCards();

        System.out.println(deck1.printCards());
        System.out.println(deck2.printCards());

        assertEquals(false, (deck1.getCards() == deck2.getCards()));

    }

//    @Test
//    public void canGetTotal() {
//
//        deck2.addCards();
//        deck2.shuffleCards();
//        deck2.dealCard();
//    }
}
