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

    public char play(char playerSymbol, int row, int col){
        boxes[row][col] = playerSymbol;
        return gameOver();
    }
    private char gameOver(){
        char verifier;
        char comparator;

        //Check horizontal win
        for(int i = 0; i < 3; i++){
            verifier = boxes[i][0];
            comparator = boxes[i][0];
            for(int j = 0; j < 3; j++){
                if(verifier != boxes[i][j]) comparator = boxes[i][j];
            }
            //Returns winner, either X or O
            if(verifier == comparator && verifier != '-') return verifier;
        }

        //Check vertical win
        for(int i = 0; i < 3; i++){
            verifier = boxes[0][i];
            comparator = boxes[0][i];
            for(int j = 0; j < 3; j++){
                if(verifier != boxes[j][i]) comparator = boxes[j][i];
            }
            //Returns winner, either X or O
            if(verifier == comparator && verifier != '-') return verifier;
        }

        //Check diagonal wins
        verifier = boxes[0][0];
        comparator = boxes[0][0];
        for(int i = 0; i < 3; i++){
            if(verifier != boxes[i][i]) comparator = boxes[i][i];
        }
        //Returns winner, either X or O
        if(verifier == comparator && verifier != '-') return verifier;


        verifier = boxes[0][2];
        comparator = boxes[0][2];
        for(int i = 0; i < 3; i++){
            if(verifier != boxes[i][2-i]) comparator = boxes[i][2-i];
        }
        //Returns winner, either X or O
        if(verifier == comparator && verifier != '-') return verifier;

        //Check if the board is full
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                //Not over
                if(boxes[i][j] == '-') return 'N';
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
