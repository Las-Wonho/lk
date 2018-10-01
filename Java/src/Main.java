public class Main {

    public static void main(String[] args) {
        // write your code here

        String map = "11111 11011 11100 00101 01011";
        Tissue t = new Tissue(5, 5, map);
        t.next();
        t.print();
    }
}
