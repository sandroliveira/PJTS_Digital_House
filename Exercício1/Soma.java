public class Soma {
    public static void main(String[] args) {
        int umNumeroA = 2;
        double umNumeroB = 5;
        double soma = umNumeroA + umNumeroB;
        double diferenca = soma%2;
        System.out.printf("umNumeroA é: %d e umNumeroA é: %.1f", umNumeroA,umNumeroB);
        System.out.printf("\nA soma de umNumeroA + umNumeroB é: %.1f",soma);
        System.out.println();

        if (umNumeroA != umNumeroB){
            System.out.printf("A diferença entre umNumeroA e umNumeroB é: %d e %.1f", umNumeroA, umNumeroB);
        }
    }
}