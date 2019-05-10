package gameModel;

import java.util.List;
import java.util.Random;

public class GrillField {
    private int number;
    private Random randomInt;

    public GrillField(int number)
    {
        this.number = number;
        randomInt=new Random();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int setAndReturnRandomNumber(List<Integer> possibleNumbers){
            if(!possibleNumbers.isEmpty()) {
                this.number = possibleNumbers.get(randomInt.nextInt(possibleNumbers.size()));
                return number;
            }

            return 0;
    }
}
