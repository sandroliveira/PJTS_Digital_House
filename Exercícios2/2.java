public class Maior {
    public static void main(String[] args) {
        algumMaior();
        System.out.println(algumMaior());


    }

    public static boolean algumMaior() {
        int umNumeroA = 70;
        int umNumeroB = 80;
        int umNUmeroC = 58;
        int umNumeroD = 66;
        if (umNumeroA > umNUmeroC && umNumeroA > umNumeroD || umNumeroB > umNUmeroC && umNumeroB > umNumeroD) {
            return true;
        } else {
            return false;
        }
    }
}
