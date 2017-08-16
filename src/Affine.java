
import java.util.Scanner;

public class Affine {

    public static boolean keyCheck(int alpha, int beta){
        // checks if alpha and beta are within set parameters as ditacted by the cipher
        if( alpha <1 || alpha >26 || beta <1 || beta>26 ){
            return false;
            // need to add gcd check for alpha and 26

//            System.out.println("Error key must have values greater than 0 and less than 26");
//            System.exit(0);
        }
        return true;
    }


    public static String affineCipher(String plaintext, int alpha, int beta){
        keyCheck(alpha,beta);
        // changed the plain text to upper case so that the alphabet can follow the 0-25 numbering system
        plaintext =plaintext.toUpperCase();
        String ciphertext = "";
        for(int i = 0; i <= plaintext.length()-1; i++){
            char letter = plaintext.charAt(i);
            if (Character.isLetter(letter)){
//              get the ascii value of the letter and minus it by 65 so it is now  number from 0-25
                int ascii = (int)letter;
                int p = ascii-65;
//                perform the standard formual (ax+b mod m ) but add 65 so the letter is returned to a ascii value
                int c = ((alpha*p +beta)%26) +65;
                char l = (char)c;
                ciphertext += l;
            }
            else{
                ciphertext += letter ;
            }
        }
        return ciphertext;
    }
//    public static void main(String[] args) {
//        Scanner reader = new Scanner(System.in);
//        System.out.println("Enter a phrase to be encrpyted: ");
//        String text = reader.nextLine();
//        System.out.println("Enter alpha: ");
//        int alpha = reader.nextInt();
//        System.out.println("Enter beta: ");
//        int beta = reader.nextInt();
//        keyCheck(alpha,beta);
//        String cipher = affineCipher(text, alpha, beta);
//        System.out.println(cipher);
//    }
}

