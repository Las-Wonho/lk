public class Cell implements Printable {
    public boolean state_of_life;
    public boolean futher;

    Cell() {
        state_of_life = true;
    }

    Cell(boolean state) {
        state_of_life = state;
    }

    @Override
    public String toString() {
        if (state_of_life)
            return "live";
        return "dead";
    }

    @Override
    public void print() {
        if (state_of_life)
            System.out.print(1);
        System.out.print(0);
    }
}
