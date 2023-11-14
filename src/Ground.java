import Computer.*;
import Game.*;
import Judge.*;
import Player.*;
import Rules.BaseBollRules;

public class Ground {
    public static void main(String[] args) {
        Computer computer = new BaseBollComputer();
        Player player = new BaseBollPlayer(new BaseBollRules());
        Judge judge = new BaseBollJudge();

        Game game = new BaseBollGame(computer,player,judge);
        game.start();
    }
}