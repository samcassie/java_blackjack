import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {


//        SET UP FOR GAME AND CLASS INSTANCES

        boolean gameActive = true;
        Deck deck = new Deck();
        deck.addCards();
        deck.shuffleCards();
        Game game = new Game(deck);

        Player player = new Player("player");
        Player dealer = new Player("dealer");
        player.addWalletFunds(1000);

        game.addPlayer(player);
        game.addPlayer(dealer);

//        START OF GAME , BETTING, INITIAL DEALING

        Scanner in = new Scanner(System.in);

        System.out.println("Type 'begin' to start the game. ");
        String begin = null;
        while (!"begin".equals(begin)){
            begin = in.nextLine();
        }
        while (gameActive == true) {
            System.out.println("Your wallet contains: £" + player.getWallet() + ".");
            System.out.println("How much do you wish to bet? ");
            int bet = in.nextInt();
            while (bet > player.getWallet()) {
                System.out.println("Insufficient funds.");
                bet = in.nextInt();
            }

            System.out.println("You have bet: £" + bet + ".");
            player.loseWalletFunds(bet);
            String next = in.nextLine();

            deck.dealCard(player);
            deck.dealCard(player);
            deck.dealCard(dealer);
            deck.dealCard(dealer);

            System.out.println("You and the dealer were dealt two cards. ");
            next = in.nextLine();

            System.out.println("You were dealt a " + player.printCards() + " Total = " + player.cardCount() + ". ");
            System.out.println("The dealer was dealt a " + dealer.getHand().get(0).toString() + " and one face down card. ");
            System.out.println(" ");


            //        PLAYER OPTION TO STICK OR TWIST

            System.out.println("Do you want to stick or twist? stick/twist ");
            String decision = in.nextLine();

            while ((!decision.contentEquals("stick")) && (!decision.contentEquals("twist"))) {
                System.out.println("Please enter 'stick' or 'twist'.");
                decision = in.nextLine();
            }

            System.out.println("You chose to " + decision + ".");

            Player winner = null;

            while ("twist".equals(decision)) {
                deck.dealCard(player);
                System.out.println("You were dealt a " + player.getHand().get((dealer.getHand().size()) - 1).toString() + ".");
                System.out.println("New total: " + player.cardCount() + ".");

                if (player.cardCount() > 21) {
                    winner = dealer;
                    System.out.println("You are over 21, you have went bust. ");
                    decision = "stick";
                    next = in.nextLine();
                } else {
                    System.out.println(" ");
                    System.out.println("Do you want to 'stick' or 'twist'? ");
                    decision = in.nextLine();
                    while ((!decision.contentEquals("stick")) && (!decision.contentEquals("twist"))) {
                        System.out.println("Please enter 'stick' or 'twist'.");
                        decision = in.nextLine();
                    }
                }
            }
            System.out.println(" ");


            //        DEALER IS DEALT CARDS

            if (winner == null) {
                System.out.println("Your final total: " + player.cardCount() + ". ");

                next = in.nextLine();
                System.out.println("The dealer second card is revealed as a " + dealer.getHand().get(0).toString() + " .");
                System.out.println("Dealer total: " + dealer.cardCount() + ".");
                next = in.nextLine();

                while ((dealer.cardCount() < player.cardCount())) {
                    System.out.println("The dealer decided to twist. ");
                    deck.dealCard(dealer);
                    System.out.println("The dealer was dealt a " + dealer.getHand().get((dealer.getHand().size()) - 1).toString() + ".");
                    System.out.println("New dealer total: " + dealer.cardCount() + ".");
                    next = in.nextLine();

                    if (dealer.cardCount() > 21) {
                        System.out.println("The dealer is over 21, they have went bust. ");
                        next = in.nextLine();
                        winner = player;
                        break;
                    }
                }

                if ((dealer.cardCount() > player.cardCount()) && (dealer.cardCount() < 21)) {
                    winner = dealer;
                }
            }


            //        WINNER IS ANNOUNCED

            if (winner == player) {
                System.out.println("The winner of this game is the player.");
                player.addWalletFunds((bet * 2));
            } else {
                System.out.println("The winner of this game is the dealer.");
            }

            System.out.println("Wallet amount: £" + player.getWallet());
            next = in.nextLine();

            if (player.getWallet() == 0){
                System.out.println("No funds to play again. ");
                System.out.println("Thank you for playing! ");
            } else {
                System.out.println("Play again? yes/no");
                String playAgain = null;
                playAgain = in.nextLine();
                while ((!playAgain.contentEquals("yes")) && (!playAgain.contentEquals("no"))) {
                    System.out.println("Please enter 'yes' or 'no'.");
                    playAgain = in.nextLine();
                }
                if (playAgain.contentEquals("yes")){
                    System.out.println("Shuffling deck...");
//                    RESET GAME, COULD MAKE FUNCTION IN GAME BUT LAZY

                    game.returnCards();
                    deck.shuffleCards();
                    winner = null;
                    decision = null;


                } else {
                    System.out.println("Thank you for playing! ");
                    gameActive = false;
                }
            }
        }


    }
}
