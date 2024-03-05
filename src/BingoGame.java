import java.util.Scanner;
import java.util.*;

public class BingoGame implements Runnable{

    List<BingoCard> cards;
    static boolean [] result;
    boolean identifier;

    List<Integer> chosenNumbers;


    public BingoGame() {
        this.cards = cards;
        this.result = new boolean[76];
        this.identifier = false;

        for(int i = 0; i<76; i++){
            result[i] = false;
        }

        this.chosenNumbers = new ArrayList<>();

    }

    @Override
    public void run() {
        int number = 0;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many players? ");
        int cnt = sc.nextInt();
        cards =  new ArrayList<>();
        for(int i = 0; i<cnt; i++){
            cards.add(new BingoCard(i+1));
        }

        for(BingoCard card: cards){
            System.out.println("Card "+ card.id);
            System.out.println(card);
        }

        Thread [] thrdRow =  new Thread[cnt];
        for(int i = 0; i<cnt; i++){
            for(int j = 1; j<=5; j++){
                thrdRow[i] = new Thread(new BingoRowChecker(j, cards.get(i)));
                thrdRow[i].start();
            }
        }

//        Thread [] thrdRow =  new Thread[cnt];
//        for(int i = 0; i<cnt; i++){
//            for(int j = 1; j<=5; j++){
//                thrdRow[i] = new Thread(new BingoRowChecker(j, cards.get(i)));
//                thrdRow[i].start();
//            }
//        }

        Thread [] thrdCol =  new Thread[cnt];
        for(int i = 0; i<cnt; i++){
            for(int j = 1; j<=5; j++){
                thrdCol[i] = new Thread(new BingoColumnChecker(j, cards.get(i)));
                thrdCol[i].start();
            }
        }

        int num = 0;
        boolean present = false;
        Random rndm = new Random();

        while(identifier == false){
            while(!present){
                num = rndm.nextInt(75);
                if(!chosenNumbers.contains(num)){
                    present =  true;
                    chosenNumbers.add(num);
                    System.out.print(num + " ");
                }
            }

            result[num] = true;
            present = false;

            synchronized (result){
                result.notifyAll();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
