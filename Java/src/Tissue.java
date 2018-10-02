import java.util.Scanner;

public class Tissue implements Printable {
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
                if (c == '1') {
                    cells[i][j] = new Cell(true);
                } else {
                    cells[i][j] = new Cell(false);
                }

            }
        }
    }

    void next() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                get(i, j).futher = neighbor(i, j);
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                get(i, j).state_of_life = get(i, j).futher;
            }
        }
    }

    void next(int n) {
        for (int i = 0; i < n; i++) {
            next();
        }
    }
    void tern_up(InputLayer layer){
        next(layer.scanner.nextInt());
    }
    boolean is_safeAccess(int _x, int _y) {
        if (x <= _x || y <= _y)
            return false;
        if (_x < 0 || _y < 0)
            return false;
        return true;
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

    boolean neighbor(int _x, int _y) {
        Cell me = get(_x, _y);
        int count = 0;
        if (cell_check(get(_x - 1, _y))) {
            count += get(_x - 1, _y).state_of_life ? 1 : 0;
        }
        if (cell_check(get(_x + 1, _y))) {
            count += get(_x + 1, _y).state_of_life ? 1 : 0;
        }
        if (cell_check(get(_x, _y - 1))) {
            count += get(_x, _y - 1).state_of_life ? 1 : 0;
        }
        if (cell_check(get(_x, _y + 1))) {
            count += get(_x, _y + 1).state_of_life ? 1 : 0;
        }
        if (me.state_of_life) {
            if (count == 2 || count == 3) {
                return true;
            } else {
                return false;
            }
        } else {
            if (count == 3) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void print() {

        System.out.println("N is " + N);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(" " + get(i, j));
            }
            System.out.println();
        }
        System.out.println();
    }
}
