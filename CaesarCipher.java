
// File: CaesarCipher.java
// Author: Jonatan Sihombing
// Date: November 2025
// Project: Codédex Build - "Create a Caesar Cipher with Java"
// Description:
// A simple Caesar Cipher encryption & decryption program written in Java.
// Demonstrates basic control flow, loops, methods, and user input handling.

import java.util.Scanner;

public class CaesarCipher {

    // Method to encrypt text using Caesar Cipher algorithm
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                // Determine base ASCII value (uppercase or lowercase)
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                // Shift character and wrap around alphabet
                char encryptedChar = (char) ((character - base + shift) % 26 + base);
                result.append(encryptedChar);
            } else {
                // Keep non-alphabetic characters unchanged
                result.append(character);
            }
        }
        return result.toString();
    }

    // Method to decrypt text (simply reverse the shift)
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    // Main method: handles user input and runs the cipher
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("      🔐 Caesar Cipher Encryption Tool      ");
        System.out.println("===========================================");
        System.out.println("Developed by: Jonatan Sihombing");
        System.out.println("Inspired by Julius Caesar’s cipher method.");
        System.out.println("-------------------------------------------\n");

        // Loop so user can choose to play again
        boolean playAgain = true;
        while (playAgain) {
            System.out.print("Enter your message: ");
            String inputText = scanner.nextLine();

            System.out.print("Enter the shift key (0-25): ");
            int shiftKey = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            System.out.print("Encrypt or Decrypt? (E/D): ");
            String mode = scanner.nextLine().trim().toUpperCase();

            String result;
            if (mode.equals("E")) {
                result = encrypt(inputText, shiftKey);
                System.out.println("\nEncrypted Text: " + result);
            } else if (mode.equals("D")) {
                result = decrypt(inputText, shiftKey);
                System.out.println("\nDecrypted Text: " + result);
            } else {
                System.out.println("\nInvalid mode! Please type E or D.");
                continue;
            }

            System.out.println("-------------------------------------------");
            System.out.print("Would you like to try again? (Y/N): ");
            String again = scanner.nextLine().trim().toUpperCase();
            playAgain = again.equals("Y");
            System.out.println();
        }

        System.out.println("Thanks for using Caesar Cipher by Joo Si!");
        System.out.println("Good luck with your Codédex Java journey! 🎯");
        scanner.close();
    }
}
