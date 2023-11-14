package Player;

import Rules.Rules;
import vo.Bolls;

import java.util.Scanner;

public class BaseBollPlayer implements Player{

    private final Scanner scanner;

    private Rules rules;

    public BaseBollPlayer(Rules rules) {
        this.scanner = new Scanner(System.in);
        this.rules = rules;
    }

    @Override
    public Bolls inputAnswer() {
        Bolls bolls = null;
        while (true) {
            try {
                String str = scanner.nextLine();
                rules.wantExitGame(str);
                bolls = new Bolls(str);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bolls;
    }

    @Override
    public boolean wantGame() {
        while (true){
            rules.printRestart();
            try {
                return rules.isRestart(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
