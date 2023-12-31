package Game;

import Computer.Computer;
import Judge.Judge;
import Player.Player;
import vo.Bolls;

public class BaseBollGame implements Game{

    private Computer computer;
    private Player player;
    private Judge judge;

    public BaseBollGame(Computer computer, Player player, Judge judgement) {
        this.computer = computer;
        this.player = player;
        this.judge = judgement;
    }

    @Override
    public void start() {
        do{
            play();
        } while (player.wantGame());
    }

    private void play() {
        System.out.println("게임을 시작합니다. 세자리 숫자를 입력하세요");
        Bolls computerBolls = computer.generateAnswer();
        Bolls playerBolls = player.inputAnswer();
        int count = 1;
        while (!judge.isOutComputer(computerBolls, playerBolls)) {
            playerBolls = player.inputAnswer();
            count++;
        }
        System.out.println(count + "번째에 맞췄습니다!");
    }

}
