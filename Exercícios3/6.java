import java.util.Random;

public class ListaAleatoria {
    public static void main(String[] args) {
        somaArray();


    }

    public static void somaArray() {
        Random inteiro = new Random();
        int[] arraylist = new int[10];
        for (int i = 0; i < 10; i++) {
            arraylist[i] = inteiro.nextInt(100);

        }
        for (int x = 0; x < arraylist.length; x++) {

            System.out.println(arraylist[x]);

        }

    }
}