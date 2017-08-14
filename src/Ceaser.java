import java.util.Scanner;

public class Ceaser {

    public static String ceasarCipher(String plainText, int shift ){
//        get the reminder of a shift if it is greater than the number of alphabets (26)
        if(shift > 26) {
            shift = shift % 26;
        }
//       if the shift is less than 0 get the reminder plus 26
        else if (shift < 0){
            shift = (shift%26)+26;
        }
        String cipherText = "";
        for(int i = 0; i< plainText.length(); i++){
            char letter = plainText.charAt(i);
//        check if the character is a letter and not a space or punctuation or etc , if it is skip to else and just append to ciphertext
            if(Character.isLetter(letter)){
                if(Character.isLowerCase(letter)){
                    char newLetter = (char) (letter + shift);
                    if(newLetter >'z'){
                        cipherText +=( char)(letter - (26 - shift));
                    }
                    else {
                        cipherText += newLetter;
                    }
                }
                if (Character.isUpperCase(letter)){
                    char newLetter = (char) (letter + shift);
                    if(newLetter >'Z'){
                        cipherText +=( char)(letter - (26 - shift));
                    }
                    else {
                        cipherText += newLetter;
                    }
                }
            }
            else {
                cipherText += letter;
            }
        }
        return cipherText ;
    }
    //same logic as encryption method but math is slightly different
    public static String decrypt(String plainText, int shift ){
        if(shift > 26) {
            shift = shift % 26;
        }
        else if (shift < 0){
            shift = (shift%26)+26;
        }
        String cipherText = "";
        for(int i = 0; i<plainText.length(); i++){
            char letter = plainText.charAt(i);
            if(Character.isLetter(letter)){
                if(Character.isLowerCase(letter)){
                    char newLetter = (char) (letter - shift);
                    if(newLetter < 'a'){
                        cipherText +=( char)(letter - (26 - shift));
                    }
                    else {
                        cipherText += newLetter;
                    }
                }
                if (Character.isUpperCase(letter)){
                    char newLetter = (char) (letter - shift);
                    if(newLetter >'A'){
                        cipherText +=( char)(letter - (26  + shift));
                    }
                    else {
                        cipherText += newLetter;
                    }
                }
            }
            else {
                cipherText += letter;
            }
        }
        return cipherText ;
    }

    public static void main(String[] args) {
//        Scanner reader = new Scanner(System.in);
//        System.out.println("Enter a phrase to be encrpyted: ");
//        String text = reader.nextLine();
//        System.out.println("Enter the number of shifts: ");
//        int shifts = reader.nextInt();
//        String cipher = ceasarCipher(text, shifts);
//        System.out.println(cipher);



    }
}
