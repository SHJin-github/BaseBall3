package Judge;

import vo.Bolls;

public class BaseBollJudge implements Judge{

    private int strikes;
    private int balls;

    @Override
    public boolean isOutComputer(Bolls computer, Bolls player) {
        countStrikeAndBall(computer,player);
        return strikes == computer.LENGTH;
    }

    private void countStrikeAndBall(Bolls computer, Bolls player){
        strikes = computer.countStrike(computer,player);
        balls = computer.countBall(computer,player);

        printResult();
    }

    private void printResult() {
        if (strikes > 0 && balls > 0) {
            System.out.println(strikes + " 스트라이크 " + balls + " 볼");
        } else if (strikes > 0 && balls == 0) {
            System.out.println(strikes + " 스트라이크");
        } else if (strikes == 0 && balls > 0) {
            System.out.println(balls + " 볼");
        } else {
            System.out.println("낫싱");
        }
    }


}
