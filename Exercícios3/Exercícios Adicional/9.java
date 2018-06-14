
import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {

        String texto = "palindromo";
        boolean resultado = palindromo(texto);
        System.out.println(resultado);

    }


        public static boolean palindromo (String texto){
            Scanner input = new Scanner(System.in);
            String captar = texto;
            String chave = "";
            boolean palindromo = false;

            while(palindromo == false){
                System.out.println("Escreva a palavra chave: ");
                chave = input.next();
                if (chave.equals(captar)){
                    palindromo = true;
                    break;
                }else{
                    System.out.println("RESPOSTA INCORRETA");
                    System.out.println("Tente novamete");
                }
            }

            return palindromo;
            }


        }
