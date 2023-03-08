public class Board {
    private char[][] boxes;

    public Board(){
        boxes = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                boxes[i][j] = '-';
            }
        }
    }

    public char[][] getBoxes() {
        return boxes;
    }

    public char play(char playerSymbol, int row, int col, char[][] board){
        board[row][col] = playerSymbol;
        return gameOver(board);
    }
    private char gameOver(char[][]board){
        char verifier;
        char comparator;

        //Check horizontal win
        for(int i = 0; i < 3; i++){
            verifier = board[i][0];
            comparator = board[i][0];
            for(int j = 0; j < 3; j++){
                if(verifier != board[i][j]) comparator = board[i][j];
            }
            //Returns winner, either X or O
            if(verifier == comparator && verifier != '-') return verifier;
        }

        //Check vertical win
        for(int i = 0; i < 3; i++){
            verifier = board[0][i];
            comparator = board[0][i];
            for(int j = 0; j < 3; j++){
                if(verifier != board[j][i]) comparator = board[j][i];
            }
            //Returns winner, either X or O
            if(verifier == comparator && verifier != '-') return verifier;
        }

        //Check diagonal wins
        verifier = board[0][0];
        comparator = board[0][0];
        for(int i = 0; i < 3; i++){
            if(verifier != board[i][i]) comparator = board[i][i];
        }
        //Returns winner, either X or O
        if(verifier == comparator && verifier != '-') return verifier;


        verifier = board[0][2];
        comparator = board[0][2];
        for(int i = 0; i < 3; i++){
            if(verifier != board[i][2-i]) comparator = board[i][2-i];
        }
        //Returns winner, either X or O
        if(verifier == comparator && verifier != '-') return verifier;

        //Check if the board is full
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                //Not over
                if(board[i][j] == '-') return 'N';
            }
        }

        // Tie
        return 'T';
    }

    public void printBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(boxes[i][j]+" ");
            }
            System.out.println();
        }
    }
}
