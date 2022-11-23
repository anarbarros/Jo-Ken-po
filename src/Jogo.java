import java.util.Scanner;

public record Jogo(Player user, Player IA, int rounds) {
    public void toPlay(){
        System.out.println("\n******* SEJA BEM-VINDO(A), " + user.getName() + " *******\n");
        int choiseUser = choiseUser();
    }
    private int choiseUser (){
     Scanner scan = new Scanner(System.in);
     System.out.println("1 - PEDRA");
     System.out.println("2 - PAPEL");
     System.out.println("3 - TESOURA");

     System.out.print("Informe a sua jogada:");

     return scan.nextInt();

    }
}


//quando se cria um atributo do record não se pode mais alterar