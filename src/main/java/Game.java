import java.util.ArrayList;

public class Game {

    ArrayList<Player> players;
    Deck deck;

    public Game(Deck deck) {
        this.deck = deck;
        this.players = new ArrayList<Player>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }


    public void returnCards(){
        for (Player player: players){
            for (Card card: player.getHand()){
                player.removeCardFromHand(card);
                this.deck.addCard(card);
            }
        }
    }

}
