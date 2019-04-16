package com.acwd.IU7;

/**
 * @author dseah
 * @version 1.0
 * Created
 * @version 1.1
 * changed hardcoded text to reflect project requirements
 * @since 2019-04-04
 *
 * This program takes in a hardcoded string input, normalize the input by removing spaces and certain special characters
 * Following normalization, encrypting begins by shifting the alphabets by a certain integer.
 * The shift occurs in a rollabout manner; ie A -1 = Z
 * Finally, the string is regrouped by adding a space character in set intervals
 *
 */
public class Crypto {
    public static void main(String[] args) {
        String test = "This is some \"really\" great. (Text)!?";
        String anotherTest = "Hello there! My name is Daniel";
        System.out.println("Originial String : " + test);
        System.out.println("Encrypted String : " + encryptString(test, -3, 3));
        System.out.println(anotherTest);
        System.out.println(encryptString(anotherTest, 5, 9));


    }

    /**
     * This is a publicly accessible static method that encrypts a given string input
     * The method calls upon three other internal methods, namely normalizedText, caesarify and groupify
     *
     * The parameters accepted are the string to be encrypted, the shifts desired for the encryption, and the group size
     * of the encrypted result.
     *
     * This method returns the encrypted string
     *
     * @param string
     * @param shift
     * @param groupSize
     * @return
     */
    public static String encryptString(String string, int shift, int groupSize) {
        String normalized = normalizeText(string);
        String encrypted = caesarify(normalized, shift);
        return groupify(encrypted, groupSize);
    }

    /**
     *
     * Returns a normalized string without spaces, and the following special characters:
     *  [. , : ' " ! ? ( )]
     *
     * @param text
     * @return
     */
    private static String normalizeText(String text) {
        String normalized = "";
        for(int i = 0; i < text.length(); i++) {
            switch(text.charAt(i)) {
                case '.':
                case ',':
                case ':':
                case ';':
                case '\'':
                case '\"':
                case '!':
                case '?':
                case '(':
                case ' ':
                case ')':
                    continue;
                default:
                    normalized += text.charAt(i);
            }
        }
        normalized = normalized.toUpperCase();
        return normalized;
    }

    /**
     * This internal method performs the encryption
     * The method takes in the text to be encrypted and the shifts needed for encryption
     *
     * The method returns the raw encrypted text
     *
     * @param normText
     * @param shifts
     * @return
     */
    private static String caesarify(String normText, int shifts) {
        String newText = "";
        for(int i=0; i < normText.length(); i++) {
            char temp = normText.charAt(i);
            temp += shifts;
            if(temp < 'A') {
                temp = (char) (temp + 26);
            }
            if(temp > 'Z') {
                temp -= 26;
            }
            newText += temp;
        }
        return newText;
    }

    /**
     *
     * Groups the input string in a given interval(groupSize)
     *
     * @param originalText
     * @param groupSize
     * @return
     */
    private static String groupify(String originalText, int groupSize) {
        String newText = "";
        int counter = 1;
 //       for(int i = 0; i < originalText.length(); i*=)
        for(int i = 0; i<originalText.length(); i++) {
            newText += originalText.charAt(i);
            if(counter == groupSize) {
                counter = 1;
                newText += " ";
            }else {
                counter++;
            }
        }
        if(counter != 1){
            //Padding for the rest of the text
            for(int i= 0; i < counter; i++){
                newText += "x";
            }
        }

        return newText;
    }

}