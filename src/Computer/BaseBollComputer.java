package Computer;

import vo.Bolls;

public class BaseBollComputer implements Computer{

    @Override
    public Bolls generateAnswer() {
        return new Bolls();
    }
}
