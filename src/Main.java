import java.util.Scanner;

public class Main {

    public static Jogo startGame() {
        System.out.println("******* Jo-Ken-Po *******\n");
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o seu nome:");
        String playerName = scan.next().toUpperCase();

        Player user = new Player(playerName);
        Player IA = new Player( "IA");

        System.out.print(playerName + ", informe quantos rounds voce deseja jogar: ");
        int rounds = scan.nextInt();

        return new Jogo (user, IA, rounds);
    }

    public static void main(String[] args) {
        Jogo jogo = startGame();
        jogo.toPlay();



    }
}