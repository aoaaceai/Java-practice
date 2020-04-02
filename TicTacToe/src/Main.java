import java.util.Scanner;

public class Main {

    public static void cls(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input player number: ");
        int playerNums= Integer.parseInt(scanner.nextLine());
        Player[] players = new Player[playerNums];
        for(int i=0;i<playerNums;i++){
            System.out.print("Name of player "+i+" : ");
            String name = scanner.nextLine();
            System.out.print("Symbol of player "+i+" : ");
            char symbol = scanner.nextLine().charAt(0);
            players[i] = new Player(name, symbol);
        }
        System.out.print("Input the size of the board: ");
        int sizeOfBoard = Integer.parseInt(scanner.nextLine());
        Game game = new Game(sizeOfBoard, players);
        int current=0;
        gameloop:
        while(game.isPlaying()){
            cls();
            Board.printArr(game.getBoard());
            Player currentPlayer = players[current];
            System.out.println("Current player: "+currentPlayer.name);
            outer:
            while(true){
                System.out.print("Input the x value : ");
                int x= Integer.parseInt(scanner.nextLine());
                System.out.print("Input the y value : ");
                int y= Integer.parseInt(scanner.nextLine());
                switch (game.turn(current, x, y)){
                    case 0:
                        System.out.println("Nothing happens. Move on.");
                        break outer;
                    case 1:
                        System.out.println("Input illegal");
                        break;
                    case 2:
                        System.out.println("Seems like somebody wins...");
                        break gameloop;

                }
            }
            current = (current+1)%playerNums;
        }
        Player winner = players[current];
        cls();
        Board.printArr(game.getBoard());
        System.out.println("Congrats to "+winner.name+" for winning!");
        scanner.close();
    }
}
