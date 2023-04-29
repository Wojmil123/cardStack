import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
public class cardStack {
    static int howManyCards = 15;
    static Stack<Integer> cards = new Stack<>();
    static HashMap<Integer, ArrayList<Integer>> hand = new HashMap<>();
    static ArrayList<Integer> player1 = new ArrayList<>();
    static ArrayList<Integer> player2 = new ArrayList<>();
    static ArrayList<Integer> player3 = new ArrayList<>();
    public static void main(String[] args) {
        startGame();
        deal();
        System.out.println("\r\n \r\n");
        playerHand();
    }


    public static void startGame(){
        makeStack();
        shuffleCards();
        addPlayers();
    }

    public static void deal(){
        int player = 1;
        while(cards.size() > 0){
            System.out.println("Player " + player + "'s turn");
            if(player == 4) player = 1;
            int card = pickCard();
            pickToHand(player, card);
            System.out.println("Card picked up: " + card);
            if(cards.size() > 3) System.out.println("Card on top: " + peekAtCard());
            player ++;
        }
    }

    public static void playerHand(){
        for(int player : hand.keySet()){
            System.out.println("Player " + player + "'s cards: " + hand.get(player));
        }
    }

    public static void makeStack() {
        for(int i = 0; i < howManyCards; i++)
            cards.push(i);
    }

    public static void shuffleCards(){
        Collections.shuffle(cards);
    }

    public static void addPlayers(){
        hand.put(1, player1);
        hand.put(2, player2);
        hand.put(3, player3);
    }

    public static int pickCard(){
        return cards.pop();
    }

    public static int peekAtCard(){
        return cards.peek();
    }

    public static void pickToHand(int player, int card){
        hand.get(player).add(card);
    }

}
