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

    }
}
