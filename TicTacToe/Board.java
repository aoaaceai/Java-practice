public abstract class Board {
    public static boolean checkBoard(char[][] board, int x, int y){
        int size = board.length;
        char[] line= new char[size];
        char currentSymbol = board[x][y];
        if(x+y==size-1 || x==y){
            for(int i=0;i<size;i++){
                line[i]=board[i][i];
            }
            if(checkLine(line, currentSymbol))return true;
            for(int i=0;i<size;i++){
                line[i]=board[i][size-i-1];
            }
            if(checkLine(line, currentSymbol))return true;
        }
        for(int i=0;i<size;i++){
            line[i]=board[x][i];
        }
        if(checkLine(line, currentSymbol))return true;
        for(int i=0;i<size;i++){
            line[i]=board[i][y];
        }
        if(checkLine(line, currentSymbol))return true;
        return false;
    }

    private static boolean checkLine(char[] line, char currentSymbol){
        for(int i=0;i<line.length;i++){
            if(line[i]!=currentSymbol)return false;
        }
        return true;
    }

    public static void printArr(char[][] board){
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
