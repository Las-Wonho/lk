import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {
    Cell cell;


    @Test
    @DisplayName("Cell create test")
    void cell_crate() {
        cell = new Cell();
        assertTrue(cell.state_of_life == true);

        cell = new Cell(false);
        assertTrue(cell.state_of_life == false);
    }

    @Test
    @DisplayName("Cell toString test")
    void cell_toString() {
        cell = new Cell();
        assertTrue(cell.toString().equals("live"));

        cell = new Cell(false);
        assertTrue(cell.toString().equals("dead"));
    }
}