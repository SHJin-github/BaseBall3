package Computer;

import vo.Bolls;

public class BaseBallComputer implements Computer{

    @Override
    public Bolls generateAnswer() {
        return new Bolls();
    }
}
