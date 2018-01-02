/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesar.ciphers;

import java.util.Scanner;

/**
 *
 * @author 348676487
 */
public class CaesarCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);

        //Obtain sentence to encode and the shift factor
        System.out.println("Enter sentence to encode: ");
        String sentence1 = s.nextLine();
        int shift1 = s.nextInt();
        //Output encoded sentence
        System.out.println(encode(sentence1, shift1));

        s.nextLine();

        //Obtain sentence to decode and the shift factor
        System.out.println("Enter sentence to decode: ");
        String sentence2 = s.nextLine();
        int shift2 = s.nextInt();
        //Output encoded sentence
        System.out.println(decode(sentence2, shift2));

        s.nextLine();

        //Obtain a decoded sentence to determine the real sentence
        System.out.println("Enter sentence break: ");
        String sentence3 = s.nextLine();
        String[] decodedMessage = (breakCode(sentence3));
        //Output each possible decoded sentence
        for (int i = 0; i < 26; i++) {
            System.out.println(decodedMessage[i]);
        }
    }

    /**
     * Takes a sentence and encodes it by shifting the characters (if letters)
     * by the given factor. Returns the encrypted sentence with the correct
     * characters shifted by the given value.
     *
     * @param sentence String with the sentence to encode
     * @param shift Integer by which the sentence is to be shifted to encode it
     * @return The String with the encrypted sentence
     */
    public static String encode(String sentence, int shift) {
        //Array to hold each character of the sentence
        char[] letters = new char[sentence.length()];
        //Store the sentence once encrypted
        String encrypted = "";
        //Loop through each character in the sentence

        for (int i = 0; i < sentence.length(); i++) {
            //Store the sentence's character in the array
            letters[i] = sentence.charAt(i);
            //calculate the shift
            shift = shift % 26;

            //check if the leter is uppercase
            if (letters[i] >= 65 && letters[i] <= 90) {
                //shift the letter
                letters[i] = (char) (letters[i] + shift);
                //if shifted character is past Z, shift it back
                if (letters[i] < 65) {
                    letters[i] += 26;
                }
                //if shifted character is before A, shift it forward
                if (letters[i] > 90) {
                    letters[i] -= 26;
                }
            }

            //check if the letter is lowercase
            if (letters[i] >= 97 && letters[i] <= 122) {
                //shift the letter
                letters[i] = (char) (letters[i] + shift);
                //if shifted character is past z, shift it back
                if (letters[i] < 97) {
                    letters[i] += 26;
                }
                //if shifted character is before a, shift it forward
                if (letters[i] > 122) {
                    letters[i] -= 26;
                }
            }
            //Add the new encrypted letter
            encrypted += letters[i];
        }
        //Return the encrypted sentence
        return encrypted;
    }

    /**
     * Takes a sentence and decodes it by shifting the characters (if letters)
     * by the given factor in the opposite direction. Returns the decrypted
     * sentence with the correct characters shifted by the given value.
     *
     * @param sentence String with the sentence to decode
     * @param shift Integer by which the sentence is to be shifted to decode it
     * @return String with the decrypted sentence
     */
    public static String decode(String sentence, int shift) {
        //Encrypt sentence with a negative shift
        return encode(sentence, -shift);
    }

    /**
     * Take a sentence and decode it to all possible sentences. Return all the
     * possible sentences. Find a sentence which has the most number of common
     * English words. Output the sentence with the the most English words.
     *
     * @param sentence The string with the encoded sentence
     * @return The array of possible decoded messages
     */
    public static String[] breakCode(String sentence) {
        //Array of the decoded messages
        String[] decodedMessage = new String[26];
        //Fill the array with the decoded messages
        for (int i = 0; i < decodedMessage.length; i++) {
            decodedMessage[i] = decode(sentence, i);
        }

        //Array of common english words
        String[] commonWords = {"what", "and", "be", "the", "it", "is", "of", "have", "for", "are", "you", "to", "with", "from", "but", "each", "when", "who", "not", "that", "will"};
        //Array of common english words counter
        int[] counter = new int[decodedMessage.length];

        //Loop through each decoded message
        for (int x = 0; x < decodedMessage.length; x++) {
            //Loop through each of the common english words
            for (int y = 0; y < commonWords.length; y++) {
                if (decodedMessage[x].toLowerCase().contains(commonWords[y])) {
                    //Add to the corresponding counter
                    counter[x]++;
                }
            }
        }

        //Integer to record which sentence has most common english words
        int highestPosition = 0;
        //Integer to record the number of most common english words
        int highestCounter = 0;
        //Loop through each counter
        for (int i = 0; i < counter.length; i++) {
            //Determine if the current counter is higher than the previous highest counter
            if (counter[i] > highestCounter) {
                highestCounter = counter[i];
                highestPosition = i;
            }
        }

        //Output the correct sentence
        System.out.println("Correct Sentence: " + decodedMessage[highestPosition]);

        return decodedMessage;
    }

}
