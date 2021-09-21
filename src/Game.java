import java.util.Scanner;

public class Game {
    public Game() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter amount of rounds 5-30");
        int amountOfRounds = myScanner.nextInt();
        while (amountOfRounds < 5 || amountOfRounds > 30) {
            System.out.println("Please enter a number between 5-30");
            amountOfRounds = myScanner.nextInt();
        }

        System.out.println("Enter amount of players 1-4");
        int amountOfPlayers = myScanner.nextInt();
        while (amountOfPlayers < 1 || amountOfPlayers > 4) {
            System.out.println("Please enter a number between 1-4");
            amountOfPlayers = myScanner.nextInt();
        }

        Player[] players = new Player[amountOfPlayers];
        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.println("Enter player name");
            String inputName = myScanner.next();
            players[i] = new Player(inputName, 10000);
        }
        for (int i = 0; i < amountOfRounds; i++) {
            for (int x = 0; x < players.length; x++) {
                System.out.println(players[x].getPlayerName() + "'s turn.");
            }
        }
    }
}
