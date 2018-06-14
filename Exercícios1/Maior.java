public class Maior {
    public static void main(String[] args){
        int umNumeroA = 3;
        int umNumeroB = 4;
        int umNumeroC = 5;

        if (umNumeroA > umNumeroB || umNumeroA > umNumeroC){
            System.out.println(umNumeroA);
        }else if(umNumeroB > umNumeroA && umNumeroB > umNumeroC){
            System.out.println(umNumeroB);
        }else{
            System.out.println(umNumeroC);
        }







    }
}

