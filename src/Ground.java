import Computer.*;
import Game.*;
import Judge.*;
import Player.*;

public class Ground {
    public static void main(String[] args) {
        Computer computer = new BaseBallComputer();
        Player player = new BaseBollPlayer();
        Judge judge = new BaseBollJudge();

        Game game = new BaseBallGame(computer,player,judge);
        game.start();
    }
}