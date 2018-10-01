public class Tissue implements Printable{
    int x, y;
    int N;
    Cell[][] cells;

    Tissue(int _n, int _m) {
        N = 0;
        x = _n;
        y = _m;
        cells = new Cell[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
    Tissue(int _n, int _m, String map) {
        x = _n;
        y = _m;
        cells = new Cell[x][y];
        String[] map_resource = map.split(" ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                char c = map_resource[i].charAt(j);
                if(c=='1'){
                    cells[i][j] = new Cell(true);
                }
                else{
                    cells[i][j] = new Cell(false);
                }

            }
        }
    }

    Cell get(int _x, int _y) {

        if (!is_safeAccess(_x, _y)) {

            return null;
        }

        return cells[_x][_y];
    }

    boolean cell_check(Cell cell) {
        if (cell == null)
            return false;
        if (cell.state_of_life)
            return true;
        return false;
    }
    }
}
