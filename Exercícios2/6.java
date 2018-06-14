public class Letra {
    public static void main(String[] args) {
        boolean umTexto = contemLetraA("l");
        System.out.println(umTexto);

        }

public static boolean contemLetraA(String l){
        char umaLetra = 'l';
        if(umaLetra == l.charAt(0)){
            return true;
        }else{
            return false;
        }
}
}