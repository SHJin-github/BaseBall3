package Player;

import vo.Bolls;
import vo.Rules;

import java.util.Scanner;

public class BaseBollPlayer implements Player{

    private final Scanner scanner;

    public BaseBollPlayer() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Bolls inputAnswer() {
        Bolls bolls = null;
        while (true) {
            try {
                String str = scanner.nextLine();
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
        Rules rules = new Rules();
        while (true){
            try {
                return rules.isRestart(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
