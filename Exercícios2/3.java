public class Soma {
    public static void main(String[] args) {
        int [] arraylist = {1,2,3,4,5};
        double numero, resultado;
        resultado = media(arraylist);
        System.out.println(resultado);



    }

    public static double media(int[] lista) {
        int soma = 0;
        int count = 0;
        double media = 0;
        int [] arraylist = lista ;
        for (int i : arraylist) {
            soma = soma + i;
            count++;
        }
        media = soma / count;
        return media;

    }
}