/**
 * Name: 8N
 * Lab Name: StringCompression
 * Lab purpose: The goal of StringCompression is to create a program that
 * Date: 10/27/17
 * Collaborators: None
 */



public class StringCompression {

    public static String Disemvoweling(String Word){
        String voweledWord = Word;
        String disVoweledWord = "";

        for (int i = 0; i < voweledWord.length(); i++) {
            if (voweledWord.charAt(i) != 'A' && voweledWord.charAt(i) != 'a' && voweledWord.charAt(i) != 'E' && voweledWord.charAt(i) != 'e' && voweledWord.charAt(i) != 'I' && voweledWord.charAt(i) != 'i' && voweledWord.charAt(i) != 'O' && voweledWord.charAt(i) != 'o' && voweledWord.charAt(i) != 'U' && voweledWord.charAt(i) != 'u'){
                disVoweledWord += voweledWord.charAt(i);
            }
        }

        return disVoweledWord;
    }


    public static String SimpleCompression(String word){
        String compressedWord = "";
        String oldWord = word;


        for (int i = 0; i < oldWord.length(); i++) {
            if (i <= oldWord.length() -2 && oldWord.charAt(i) == oldWord.charAt(i+1)){
               int howManyOf = 1;
                while(i <= oldWord.length() -2 && oldWord.charAt(i) == oldWord.charAt(i+1)){
                    howManyOf ++;
                    i++;
                }
                compressedWord += "" + oldWord.charAt(i) + howManyOf;
            }
            else{
                compressedWord += oldWord.charAt(i);
            }
        }


        return compressedWord;

    }

    public static void DictionaryCompression(String word){
        Dictionary compressedWordDictionary = new Dictionary();
        String[] wordArray = word.split(" ");
        String compressedWord = "";
        int keyValue = 0;

        for (String curr : wordArray) {
            if (compressedWordDictionary.get(curr) == null){
                compressedWordDictionary.put(keyValue, curr);
                keyValue++;
            }
            else{
                compressedWordDictionary.put(keyValue, curr);
            }
        }
        for (Object curr : compressedWordDictionary.keys()) {
            compressedWord += curr.toString();
        }

        int valueDictLength = 0;
        for (Object curr : compressedWordDictionary.values()) {
            valueDictLength += curr.toString().length();
        }

        int keysDictLength = 0;
        for (Object curr : compressedWordDictionary.keys()) {
            keysDictLength += curr.toString().length();
        }

        System.out.println(compressedWord);
        System.out.println("Dictionary Keys: " + compressedWordDictionary.keys());
        System.out.println("Dictionary Values: " + compressedWordDictionary.values());
        System.out.print("Compression rate: ");
        System.out.println((1.0*word.length() - compressedWord.length() + keysDictLength + valueDictLength) / word.length());

    }

    public static void main(String[] args) {
        String test= "hello world! How is your day? Whaat iis uuup?";


        System.out.println(test);

        System.out.println(Disemvoweling(test));

        System.out.println(SimpleCompression(test));

        DictionaryCompression(test);

    }


}
