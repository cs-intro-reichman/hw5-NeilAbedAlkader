/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
        System.out.println(randomStringOfLetters(8));
    }

    /**
     * Returns the number of times the given character appears in the given string.vvvv
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count = 0;
        for(int i =0; i < str.length(); i++){
            if(str.charAt(i)==ch)
                count++;
        }
        return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if (str1.isEmpty()) {
            return true;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        for (int i = 0; i < arr1.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    found = true;
                    arr2[j] = 0;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }


    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String strRes = "" ;
        for(int i =0; i < str.length(); i++){

            if(i==str.length()-1)
                strRes += str.charAt(i);
            else
                strRes += str.charAt(i) + " ";

        }
        return strRes;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     *
     * Example: randomStringOfLetters(3) can return "zoo"
     *
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        char[] smallCaps = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        int j = 0;
        String str = "";
        for(int i = 0; i < n; i++){
            j = (int) (Math.random() * 26) ;
            str+=smallCaps[j];
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
       char[] arr1 = StrToArr(str1);
        char[] arr2 = StrToArr(str2);
        for(int i = 0; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                if(arr1[i]==arr2[j] && arr1[i]!=0 && arr2[j]!=0){
                    arr1[i] = 0;
                    arr2[j] = 0;
                    break;
                }
            }
        }

        return ArrToStr(arr1);
    }

    public static char[] StrToArr(String str) { // Asist fun
        char[] arr = new char[str.length()];
        String strRes = "";
        for(int i = 0; i < arr.length; i++){
            arr[i]=str.charAt(i);
        }
        return arr;
    }

    public static String ArrToStr(char[] arr) {// Asist fun
        String str = "";
        for(int i = 0; i < arr.length; i++){
            if(arr[i]!=0)
                str += arr[i];
        }
        return str;
    }



    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
