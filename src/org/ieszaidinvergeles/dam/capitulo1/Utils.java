/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ieszaidinvergeles.dam.capitulo1;

import java.util.Random;


public class Utils {
        public static String randomWord(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        //targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
        
    public static String generateRandomFileName(int length){
        String [] extensions = {"doc", "pdf", "rtf", "csv", "txt", "docx"};
        Random random = new Random();
        String extension = extensions[random.nextInt(extensions.length-1)];
        return randomWord(length)+"."+extension;
    }    
}
