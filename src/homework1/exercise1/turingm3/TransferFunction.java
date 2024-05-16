package homework1.exercise1.turingm3;

public class TransferFunction {
    private Character state = 's';
    private Character writeSymbol = '*';
    private String direction = "->";

    public TransferFunction(Character state, Character writeSymbol,
                            String direction) {
        this.state = state;
        this.writeSymbol = writeSymbol;
        this.direction = direction;
    }

    public TransferFunction() {

    }

    public Character getState() {
        return this.state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    public Character getWriteSymbol() {
        return this.writeSymbol;
    }

    public void setWriteSymbol(Character writeSymbol) {
        this.writeSymbol = writeSymbol;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "(s, " + writeSymbol + ", " + direction + ")";
    }

}

