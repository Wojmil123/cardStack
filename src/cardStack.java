import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
public class cardStack {
    static int playersCount = 3;
    static int howManyCards = 15;
    static Stack<Integer> cards = new Stack<Integer>();
    static HashMap<String, ArrayList<Integer>> hand = new HashMap<String, ArrayList<Integer>>();
    public static void main(String[] args) {
        int pid = 1;
        makeStack();
        while(cards.size() > 0){
            System.out.println("Kolej gracza " + pid);
            if(pid == 4) pid = 1;
            int card = pickCard();
            pickToHand(pid, card);
            System.out.println("Podniesiono kartę " + card);
            if(cards.size() > 3) System.out.println("Karta na wierzchu: " + peekAtCard(pid));
            System.out.println("pozostało kart" + cards.size());
            pid ++;
        }
        playerHand(1);
        playerHand(2);
        playerHand(3);
    }

    public static void makeStack() {
        for(int i = 0; i < howManyCards; i++){
            cards.add(i);
        }
    }

    public static int pickCard(){
        return cards.pop();
    }

    public static int peekAtCard(int player){
        return hand.get("Player" + player);
    }

    public static void pickToHand(int player, int card){
        hand.put(("Player" + player), card);
    }

    public static void playerHand(int player){
        System.out.println(hand.get("Player" + player));
    }

}
