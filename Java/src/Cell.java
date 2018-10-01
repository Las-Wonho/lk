public class Cell {
    public boolean state_of_life;
    Cell(){
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
}
