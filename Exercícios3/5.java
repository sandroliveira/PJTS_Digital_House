public class Intervalo {
    public static void main(String[] args) {
        somaArray();


    }

    public static void somaArray() {
        int minimo = 3;
        int maximo = 10;
        int[] arraylist = new int[10];
        int contador = 0;
        for (int i = 0; i < 10; i++) {
            if (i > minimo && i < maximo) {
                arraylist[contador] = i;
                contador++;
            }
        }
        for (int x = 0; x < arraylist.length; x++) {

            System.out.println(arraylist[x]);

        }

    }
}