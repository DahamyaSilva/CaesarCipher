public class Decipher {

    public static String decipher(String ciphertext, String knownWord) {

        //try all possible shifts 0 - 25
        for(int shift = 0; shift < 26; shift++) {
            //creates a new StringBuilder object to build the decrypted string for the current shift value
            StringBuilder decrypted = new StringBuilder();

            //iterates through each character in the ciphertext and converts the string into a character array
            for(char c : ciphertext.toCharArray()) {
                //checks if the current character is a letter
                if(Character.isLetter(c)){

                    //Determines if the character is a uppercase or lowercase
                    char base = Character.isUpperCase(c) ? 'A' : 'a';

                    //reverse Ceasar cipher operation
                    //converts the letter to a number
                    //subtract the shift value to decrypt
                    //adds 26 to handle negative numbers
                    //modulo 26 (%26) to stay within the 0 - 25 range
                    //converts back from number to a character

                    char decryptedChar = (char) ((c - base - shift + 26) % 26 + base);
                    decrypted.append(decryptedChar);
                }
                else {
                    //no- letter character remains unchanged
                    decrypted.append(c);
                }
            }

            //checks if the known word appears in the decrypted text
            String decryptedText = decrypted.toString();

            //convert both to lowercase for case-insensitive comparison
            String lowerText = decryptedText.toLowerCase();
            String lowerWord = knownWord.toLowerCase();

            //split the text into words to check each one
            String[] words = lowerText.split("\\s+");
            boolean found = false;
            for(String w : words){
                w = w.replaceAll("[^a-zA-Z]", "");
                if(w.equals(lowerWord)){
                    found = true;
                    break;
                }
            }

            if(found){
                return decryptedText;
            }

        }
        //if no valid decryption was found
        return "Invalid";
    }
}