public class Soma {
    public static void main(String[] args) {
        int resultado;
        resultado = somaArray();
        System.out.println(resultado);



    }

    public static int somaArray() {
        int [] arraylist = {1,2,3,4,5};
        int soma = 0;
        int count = 0;
        for (int i : arraylist) {
            soma = soma + i;
            count++;
        }
        return soma;

    }
}