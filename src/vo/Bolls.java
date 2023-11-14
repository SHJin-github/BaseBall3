package vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bolls {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    public static final int LENGTH = 3;

    private List<Integer> bolls;

    public Bolls() {
        this.bolls = generateRandomBolls();
    }

    public Bolls(String str){
        this.bolls = new ArrayList<>();
        convertStrToBoll(str);
        validateBolls();
    }

    private List<Integer> generateRandomBolls() {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        while (result.size() < LENGTH) {
            int boll = random.nextInt(END_NUMBER) + START_NUMBER;
            if (!result.contains(boll)) {
                result.add(boll);
            }
        }
        System.out.println(result);
        return result;
    }

    private void convertStrToBoll(String str){
        for (int i = 0; i < str.length(); i++) {
            char digitChar = str.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            bolls.add(digit);
        }
    }

    private boolean validateBolls(){
        return (isLength() && isRange() && !isDuplicated());
    }

    private boolean isLength(){
        if(bolls.size() == LENGTH) {
            return true;
        }
        throw new IllegalArgumentException(LENGTH+"자리수로 입력하세요");
    }

    private boolean isRange(){
        for(Integer boll : bolls){
            if(!(boll >= START_NUMBER && boll <= END_NUMBER)){
                throw new IllegalArgumentException(START_NUMBER+"~"+END_NUMBER+"숫자로 입력하세요");
            }
        }
        return true;
    }

    private boolean isDuplicated() {
        List<Integer> set = new ArrayList<>();
        for (Integer boll : bolls){
            if(set.contains(boll)){
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
            set.add(boll);
        }
        return false;
    }

    public int countStrike(Bolls computer, Bolls player){
        List<Integer> com = computer.getBolls();
        List<Integer> play = player.getBolls();
        int strikes = 0;
        for (int i = 0; i < com.size(); i++) {
            if (com.get(i).equals(play.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    public int countBall(Bolls computer, Bolls player){
        List<Integer> com = computer.getBolls();
        List<Integer> play = player.getBolls();
        int balls = 0;
        for (int i = 0; i < com.size(); i++) {
            if (!com.get(i).equals(play.get(i)) && play.contains(com.get(i))) {
                balls++;
            }
        }
        return balls;
    }


    private List<Integer> getBolls() {
        return bolls;
    }


}
