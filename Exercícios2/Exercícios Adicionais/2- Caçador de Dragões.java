import java.util.Scanner;
import java.util.Random;
public class Soma {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int continue1 = 0; // 1 representa continuar, 2 representa desistir e 3 representa derrota.
        Random attack = new Random();// Decide se o jogador ou computador ataca primeiro.
        Random range_damage_dragon = new Random(); // Alcance de dano gerado aleatoriamente
        int[] inflict_damage_dragon = new int[10];// Armazena em blocos os danos causados da variável range_damage_dragon
        int danos_totais = 0;// Armazena a soma total de dano
        int dificuldade = 0;// Define a probabilidade do jogador ganhar a disputa de ataque

        int count = 0; /*uso esse contador para marcar pontos de dano dentro do array inflict_damage_dragon e também
        para mostrar a rodada*/

        Scanner input = new Scanner(System.in);
        System.out.println("[ CAÇADOR DE DRAGÕES ]");
        System.out.println("Presione 'ENTER' para iniciar o jogo");
        String iniciar = input.nextLine();

        // DIFICULDADE
        System.out.println("Escolha um nível de dificuldade: ");
        System.out.println("DIGITE: (1) para fácil   (2) para médio ou (3) para difícil");
        iniciar = input.nextLine();
        switch (Integer.parseInt(iniciar)){
            case 1: dificuldade = 50;
                break;
            case 2: dificuldade = 25;
                break;
            case 3: dificuldade = 12;
                break;
        }


        System.out.println("COMEÇOU O JOGO\n");
        System.out.println("RODADA 1");

        while (danos_totais < 5) {
            if (continue1 == 1) { // NÚMERO DA RODADA
                System.out.printf("Rodada %d\n", count + 1);
            }

            System.out.println("Disputa de ataque");
            if (attack.nextInt(dificuldade) > 3) {
                System.out.print("Você atacou o dragão");
                inflict_damage_dragon[count] = range_damage_dragon.nextInt(6);// DANOS ALEATÓRIO AO DRAGÃO
                danos_totais = danos_totais + inflict_damage_dragon[count];// DANOS TOTAIS AO DRAGÃO
                if(inflict_damage_dragon[count] == 0){
                    System.out.print(": Miss\n");
                }else if (inflict_damage_dragon[count] == 5){
                    System.out.print(": Dano Crítico\n");
                }else{
                    System.out.print(": Dano Infligido\n");
                }
                /*TESTE
                System.out.println("dano causado " + inflict_damage_dragon[count]);
                System.out.println("danos totais " + danos_totais);*/
                if (danos_totais < 5) { // CONTADOR
                    count++;
                }


            } else {
                continue1 = 3; // sair do loop e entrar na condição 'Perdendo'
                break;
            }


            if (danos_totais < 5){
                System.out.println("Deseja continuar o jogo?");
                System.out.println("DIGITE: (1) para continuar  ou (2) para terminar");
                continue1 = teclado.nextInt();
                if (continue1 == 2) {
                    danos_totais = 6; // Sair do loop
                }
            }else{

            }



        }

        // RESULTADO E DANOS TOTAIS

        if (danos_totais > 4 && continue1 != 2) { // VENCENDO
            System.out.println("Fim de jogo");
            System.out.println("Você Venceu :D");
            System.out.print("O seu histórico de danos causados ao dragão é: ");
            for (int i = 0; i < count + 1; i++) {
                if (i == count) {
                    System.out.print("e " + inflict_damage_dragon[i] + " de dano.");
                } else if (i == count - 1) {
                    System.out.print(inflict_damage_dragon[i] + " de dano. ");
                } else {
                    System.out.print(inflict_damage_dragon[i] + " de dano, ");
                }
            }
        } else if (danos_totais < 5 && continue1 == 3){ // PERDENDO
            System.out.println("O dragão acertou o golpe em você");
            System.out.println("Você perdeu );");
            System.out.print("O seu histórico de danos causados ao dragão é: ");
            for (int i = 0; i < count; i++) {
                if (i == count - 1) {
                    System.out.print(inflict_damage_dragon[i] + " de dano. ");
                } else if (i == count) {
                    System.out.print("e " + inflict_damage_dragon[i] + " de dano.");
                } else {
                    System.out.print(inflict_damage_dragon[i] + " de dano, ");
                }
            }
            if(count == 0){
                System.out.print(inflict_damage_dragon[0] + " de dano.");
            }
        }else{ // DESISTINDO
            System.out.println("Fim de jogo");
            System.out.println("Você desistiu ):");
            System.out.print("O seu histórico de danos causados ao dragão é: ");
            for (int i = 0; i < count; i++) {
                if (i == count) {
                    System.out.print("e " + inflict_damage_dragon[i] + " de dano.");
                } else if (i == count - 1) {
                    System.out.print(inflict_damage_dragon[i] + " de dano. ");
                } else {
                    System.out.print(inflict_damage_dragon[i] + " de dano, ");
                }
            }
            if(count == 0) {
                System.out.print(inflict_damage_dragon[0] + " de dano.");
            }


        }
    }

}


















