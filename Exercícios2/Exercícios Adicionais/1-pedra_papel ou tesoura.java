import java.util.Scanner;
import java.util.Random;
public class jokenpo {
    public static void main(String[] args) {
        int cal_jogador = 4;
        String[] array = {"PEDRA", "PAPEL", "TESOURA"};
        Random numero = new Random();

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o seu Nome: ");
        String nome = input.nextLine();
        while (cal_jogador > 2) {
            System.out.println("Escolha um número de acordo com a sua jogada \n pedra (0) papel (1) ou tesoura (2):");
            cal_jogador = Integer.parseInt(input.nextLine());
            if (cal_jogador > 2) {
                System.out.println("NÚMERO INVALIDO: digite um valor entre 0 e 2\n");
            }
        }
        String escolha = array[cal_jogador];
        System.out.println();
        System.out.printf("VOCÊ ESCOLHEU: %s", escolha);

        int cal_pc = numero.nextInt(3);
        String escolha_pc = array[cal_pc];
        System.out.printf("\nO COMPUTADOR ESCOLHEU: %s", escolha_pc);


        if ((cal_jogador == 0 && cal_pc != 1 && cal_jogador != cal_pc) || (cal_jogador == 1 && cal_pc != 2 && cal_jogador != cal_pc) || (cal_jogador == 2 && cal_pc != 0 && cal_jogador != cal_pc)) {
            System.out.println();
            System.out.printf("\nO JOGADOR %s VENCEU :D\n", nome);
        } else if ((cal_pc == 0 && cal_jogador != 1 && cal_jogador != cal_pc) || (cal_pc == 1 && cal_jogador != 2 && cal_jogador != cal_pc) || (cal_pc == 2 && cal_jogador != 0 && cal_jogador != cal_pc)) {
            System.out.println();
            System.out.println("\nO COMPUTADOR VENCEU );");
        } else {
            System.out.println();
            System.out.println("EMPATOU ):");
        }

    }
}