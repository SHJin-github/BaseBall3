package vo;

public class Rules {

    private static final int START_GAME = 1;
    private static final int END_GAME = 2;

    public Rules() {
        System.out.println(START_GAME+". 게임시작     "+END_GAME+". 종료");
    }

    public boolean isRestart(String str) {
        int num = convertStrToNum(str);
        validateBolls(num);

        if (num == START_GAME) {
            return true;
        } else {
            System.out.println("게입을 종료합니다");
            return false;
        }

    }

    private int convertStrToNum(String str){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력하세요");
        }
    }

    private void validateBolls(int num){
        if(!(num == START_GAME || num == END_GAME)){
            throw new IllegalArgumentException(START_GAME+"또는"+END_GAME+"를 입력하세요");
        }
    }


}
