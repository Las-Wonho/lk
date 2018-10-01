import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TissueTest {

    String map = "11111 11011 11100 00101 01011";
    Tissue t = new Tissue(5, 5, map);

    @Test
    @DisplayName("Cell is available check")
    void is_safeAccess() {
        assertTrue(t.is_safeAccess(0, 0));
        assertTrue(t.is_safeAccess(1, 1));
        assertTrue(t.is_safeAccess(3, 4));
        assertFalse(t.is_safeAccess(2, 5));
        assertFalse(t.is_safeAccess(5, -1));
        assertFalse(t.is_safeAccess(-5, -1));
        assertFalse(t.is_safeAccess(5, 5));
        assertFalse(t.is_safeAccess(-1, 1));
    }

    @Test
    void get() {
        assertTrue(t.get(1, 1).state_of_life);
        assertTrue(t.get(1, 1) != null);

        assertTrue(t.get(1, 5) == null);
        assertTrue(t.get(1, -1) == null);
        assertTrue(t.get(-1, 5) == null);
        assertTrue(t.get(-1, -1) == null);
        assertTrue(t.get(-1, 2) == null);
    }

    @Test
    void cell_check() {
        assertTrue(t.cell_check(new Cell(true)));
        assertFalse(t.cell_check(new Cell(false)));
        assertFalse(t.cell_check(null));
    }

    @Test
    void neighbor() {
        Tissue t = new Tissue(5, 5, map);
        assertTrue(t.neighbor(0,0));
        assertTrue(t.neighbor(1,1));
        assertTrue(t.neighbor(4,2));
        assertFalse(t.neighbor(4,3));
    }

}