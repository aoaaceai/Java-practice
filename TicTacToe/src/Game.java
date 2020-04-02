public class Game {
    private Player[] players;
    private char[][] board;
    private int size;
    private boolean playing = true;
    public Game(int size, Player[] players){
        this.players = players;
        this.size = size;
        board = new char[size][size];
    }

    public Player[] getPlayers(){
        return players;
    }

    public boolean isPlaying(){
        return playing;
    }

    public char[][] getBoard(){
        return board;
    }

    public int turn(int current, int x, int y){
        // 0: normal round, nothing happens
        // 1: illegal move
        // 2: current person wins
        if(x>=size || y>= size || x<0 || y<0)return 1;
        if(board[x][y]!='\u0000')return 1;
        board[x][y]=players[current].symbol;
        if(Board.checkBoard(board, x, y)){
            playing = false;
            return 2;
        }
        return 0;
    }




}
