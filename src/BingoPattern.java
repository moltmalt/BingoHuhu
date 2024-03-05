import java.util.ArrayList;
import java.util.List;

public abstract class BingoPattern implements Runnable{
    List<BingoChecker> bingoCheckers;
    BingoCard toCheckAgainst;

    public BingoPattern(BingoCard toCheckAgainst) {
        this.bingoCheckers = new ArrayList<>();
        this.toCheckAgainst = toCheckAgainst;
    }

    public void run(){
        Thread [] bcThreads =  new Thread[bingoCheckers.size()];
        for(int i = 0; i<bingoCheckers.size(); i++){
            bcThreads[i] = new Thread();
        }

        for(int i = 0; i<bingoCheckers.size(); i++){
            bcThreads[i].start();
            try {
                bcThreads[i].wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
