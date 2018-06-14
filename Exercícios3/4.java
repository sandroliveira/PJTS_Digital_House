public class Array100 {
    public static void main(String[] args) {
        somaArray();


    }

    public static void somaArray() {
        int[] arraylist = new int[100];
        int count = 0;
        for (int i = 0; i < 200; i++) {
            if (i < 101 && i != 0) {
                arraylist[count] = i;
                count++;

            }
        }
        for (int x = 0; x < arraylist.length; x++) {

            System.out.println(arraylist[x]);

        }

    }
}