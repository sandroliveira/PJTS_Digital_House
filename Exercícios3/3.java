public class ArrayPares {
    public static void main(String[] args) {
        somaArray();


    }

    public static void somaArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] arraylist = new int[array.length];
        int contador = 0;
        for (int i : array) {
            if (array[i % 2] == 1) {
                arraylist[contador] = i;
                contador++;
            }
        }
        for (int x = 0; x < arraylist.length; x++) {

            System.out.println(arraylist[x]);

        }

    }
}