import java.util.Scanner;

public class TicTacToe {
    private int turn;
    private Board board;

    public TicTacToe(){
        Scanner sc = new Scanner(System.in);
        board = new Board();
        char gameState;
        do{
//            Player Move
            if(turn % 2 == 0){
                System.out.println("Player's turn");
                System.out.println("What row?");
                int row = sc.nextInt();
                System.out.println("What column?");
                int col = sc.nextInt();
                gameState = board.play('X',row,col);
            }
//            //Bot Move
            else{
            System.out.println("Bot's turn");
                gameState = board.play('O',0,0);
            }
            board.printBoard();
            System.out.println("----------------");
            turn++;
        }while (gameState == 'N');
        if(gameState != 'T'){
            System.out.println("THE WINNER IS "+gameState);
        }
        else{
            System.out.println("THE GAME IS A TIE");
        }
    }
}
