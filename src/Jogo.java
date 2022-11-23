import java.util.Random;
import java.util.Scanner;

public record Jogo(Player user, Player IA, int rounds) {
    public void toPlay(){
        System.out.println("\n******* SEJA BEM-VINDO(A), " + user.getName() + " *******\n");

        for(int i = 1; i <= rounds; i++){
        int choiseUser = choiseUser();
        if(choiseUser < 1 || choiseUser > 3) {
            System.out.println("\nJOGADA INVALIDA: (1, 2 ou 3) :");
            System.out.println("\tPONTO PARA  " + IA.getName() + "\n");
            IA.incrementScore();
            //continue;
        }

            int choiseIA = choiseIA();
            System.out.print("\n" + choiseUser + " X " + choiseIA + "\n");

            int result = choiseUser - choiseIA;

            winnerRound(result);
        }
    }

    public void showFinalResult () {
        System.out.println("\n****************************************\n");
        Integer finalScoreUser = user.getScore();
        Integer finalScoreIA = IA.getScore();

        System.out.println("\n\tPLACAR FINAL: " + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getName());

        if(finalScoreUser == finalScoreIA){
            System.out.println("EMPATE!");
        } else {
            String finalWinner = (finalScoreIA > finalScoreUser) ? IA.getName() : user.getName();
            System.out.println("VENCEDOR = " + finalWinner.toUpperCase());
        }
        System.out.println("\n****************************************\n");
    }
    private void winnerRound (int result) {
        String winnerRound;
        if (result  == 0){
            winnerRound = "EMPATE";
        } else {
            if(result ==-1 || result == 2) {
                IA().incrementScore();
                winnerRound = IA().getName();
            } else {
                user.incrementScore();
                winnerRound = user.getName();
            }
        }
        System.out.println("\n Vencedor do Round:" + winnerRound + "\n");
    }

    private int choiseIA() {
        Random random = new Random();
        return random.nextInt(3 ) + 1;

    }

    private int choiseUser(){
     Scanner scan = new Scanner(System.in);
     System.out.println("1 - PEDRA");
     System.out.println("2 - PAPEL");
     System.out.println("3 - TESOURA");

     System.out.print("Informe a sua jogada:");

     return scan.nextInt();

    }
}


//quando se cria um atributo do record não se pode mais alterar