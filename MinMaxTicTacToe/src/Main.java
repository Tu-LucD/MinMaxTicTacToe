public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        char result = b.play('O',0,0);
        System.out.println(result);
        b.printBoard();

        result = b.play('O',1,1);
        System.out.println(result);
        b.printBoard();

        result = b.play('O',2,2);
        System.out.println(result);
        b.printBoard();
    }
}