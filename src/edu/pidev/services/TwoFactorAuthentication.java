/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.services;

/**
 *
 * @author Mariem OUESLATI
 */

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoFactorAuthentication {
    
    
        public static void main(String[] args) {
        String nomu = "nomu";
        String mot_passe = "mot_passe";
        String secretCode = "123456";
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrer le nom d'utilisateur: ");
        String inputNomu = scanner.nextLine();
        
        System.out.print("Entrer le mot de passe: ");
        String inputMot_passe = scanner.nextLine();
        
        System.out.print("Entrer le code de verification: ");
        String inputCode = scanner.nextLine();
        
        // Combine the username and password into a single string
        String combinedString = Stream.of(inputNomu, inputMot_passe)
                .collect(Collectors.joining());
        
        // Hash the combined string using SHA-256 algorithm
        String hashedString = hashString(combinedString);
        
        // Check if the hashed string matches the password and the verification code is correct
        if (inputNomu.equals(nomu) && hashedString.equals(mot_passe) && inputCode.equals(secretCode)) {
            System.out.println("Authentification réussie");
        } else {
            System.out.println("Authentification échouée");
        }
    }
    
    private static String hashString(String input) {
        // Use a library like Apache Commons Codec to hash the string
        // Here we just return the original string as an example
        return input;
    }
    
}
