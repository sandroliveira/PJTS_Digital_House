import java.util.Scanner;


public class Cesar {
    public static void main(String[] args) {
        String[] array = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String texto;
        String codigo = "";
        Scanner input = new Scanner(System.in);
        char retirada;
        int posicao = 10;

        //System.out.println((16 + posicao) % array.length);


        //System.out.println(array[0].equals(codigo));

        System.out.println("Escreva um texto" );
        texto = input.nextLine();

        System.out.println("Digite a quantidade de pulo de posições Ex 3, 10, 15");
        posicao = input.nextInt();

        for(int i = 0; i < texto.length();i++){
            retirada = texto.charAt(i);
            for(int x = 0; x < array.length; x++) {
                if(array[x].equals(Character.toString(retirada))) {
                    if(x + posicao > array.length){
                        codigo = codigo + array[(x + posicao) - array.length];
                    }else {
                        codigo = codigo + array[x + posicao];
                    }

                }
                if(x == 26){
                    x = 0;
                }


            }

        }

        System.out.println(codigo);

    }
}
