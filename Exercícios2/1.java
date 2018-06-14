public class MaiorQueDez {


    public static void main(String[] args) {
        imparMairQueDez();
        System.out.println(imparMairQueDez());


    }

    public static boolean imparMairQueDez() {
        int umNumero = 21;
        if (umNumero % 2 == 1 && umNumero > 10) {
            return true;
        } else {
            return false;
        }
    }
}