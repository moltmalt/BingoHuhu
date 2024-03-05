import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BingoCard {
    int[][] nums;
    int id;

    ArrayList<Integer> alreadyUsed = new ArrayList<Integer>();

    public BingoCard(int id) {
        this.id = id;
        this.nums = new int[5][5];
        randomNumberGenerator();
    }

    public void randomNumberGenerator(){
        boolean valid = false;
        int temp = 0;
        for(int i = 0; i < 5; i++){
            for(int row = 0; row < 5; row++){
                while(!valid){
                    temp = (int)(Math.random() * 15) + 1 + 15 * i;
                    if(!alreadyUsed.contains(temp)){
                        valid = true;
                        alreadyUsed.add(temp);
                    }
                }
                nums[row][i] = temp;
                valid = false;
            }
        }
        nums[2][2] = 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row<5; row++){
            for(int col = 0; col<5; col++){
                sb.append(nums[row][col]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
