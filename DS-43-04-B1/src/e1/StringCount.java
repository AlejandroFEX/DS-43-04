package e1;

import static java.lang.Character.*;

public class StringCount {
    /**
     * Counts the number of words in a given String .
     * Words are groups of characters separated by one or more spaces .
     *
     * @param text String with the words
     * @return Number of words in the String or zero if it is null
     */
    public static int countWords(String text){
        int count=0;
        if(text==null)
            return count;
        if (text.charAt(0)==' '){
            count--;
        }

        for (int i=0; i<text.length();i++){

            if (text.charAt(i)==' '&& i+1<text.length()) {
                if (text.charAt(i + 1) != ' ') {
                    count++;
                }
            }
        }
        count ++;
        return count;
    }
    /**
     * Counts the number of times the given character appears in the String .
     * Accented characters are considered different characters .
     * @param text String with the characters
     * @param c the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countChar(String text, char c){
        int count=0;
        if(text==null)
            return count;
        for (int i=0; i<text.length();i++){
            if(text.charAt(i)==c){
                count++;
            }
        }
        return count;
    }
    /**
     * Counts the number of times the given character appears in the String .
     * The case is ignored so an ’a’ is equal to an ’A ’.
     * Accented characters are considered different characters .
     * @param text String with the characters
     * @param c the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countCharIgnoringCase ( String text , char c ) {
        int count=0;
        if(text==null)
            return count;
        char letraCambio;
        if(Character.isLowerCase(c)) {
            letraCambio= Character.toUpperCase(c);
        }
        else
            letraCambio=Character.toLowerCase(c);

        for (int i=0; i<text.length();i++){
            if(text.charAt(i)==c||text.charAt(i)==letraCambio){
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if a password is safe according to the following rules :
     * - Has at least 8 characters
     * - Has an uppercase character
     * - Has a lowercase character
     * - Has a digit
     * - Has a special character among these : ’? ’, ’@ ’, ’#’, ’$ ’, ’. ’ and ’,’
     * @param password The password , we assume it is not null .
     * @return true if the password is safe , false otherwise
     */
    public static boolean isPasswordSafe ( String password ) {
        int i;
        //minimo 8 caracteres
        if(password.length()<7) {
            return false;
        }
        //minimo una mayuscula y una minuscula
        int countMayus=0;
        int countMinus=0;
        for (i=0; i<password.length();i++){
            if(isUpperCase(password.charAt(i))){
                countMayus++;
            }
            if(isLowerCase(password.charAt(i))){
                countMinus++;
            }
        }
        if(countMayus<=0||countMinus<=0) {

            return false;
        }

        //minimo un digito
        boolean digito=false;
        String numeros="0123456789";
        for (int j=0; 9>=j;j++) {
            for (i = 0; password.length() > i; i++) {
                if (countChar(password,numeros.charAt(j))>0){
                    digito=true;
                }
            }
        }

        if(!digito) {
            return false;
        }
        //minimo un caracter especial
        int numeCaracEspeciales=0;
        String caracEspeciales= "?@#$.,";
        for (i=0;caracEspeciales.length()>i;i++) {
            if (countChar(password, caracEspeciales.charAt(i)) > 0)
                numeCaracEspeciales++;
        }

        return numeCaracEspeciales > 0;
    }

}
