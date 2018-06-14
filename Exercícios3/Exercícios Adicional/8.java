import java.util.Scanner;

public class Inversao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Escreva alguma palavra: ");
        String texto = input.next();
        String resultado = somaArray(texto);
        System.out.println(resultado);

    }


        public static String somaArray (String texto){
            Scanner input = new Scanner(System.in);
            String captar = texto;
            String conversao = "";

            for (int i = 0; i < captar.length(); i++){
                conversao = captar.charAt(i) + conversao;
            }

            return conversao;
            }


        }
