public class SomaPares {
    public static void main(String[] args) {

        int resultado;
        resultado = pares();
        System.out.println(resultado);



    }

    public static int pares() {
        int [] arraylist = {1,2,3,4,5};
        int soma = 0;
        int count = 0;
        for (int i : arraylist) {
            if(arraylist[i%2] == 1 ){
                soma = soma + i;
            }

            count++;
        }
        return soma;

    }
}