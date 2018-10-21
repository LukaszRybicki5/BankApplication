package com.checkers;

/*
Sprawdzamy czy login i hasło maja wymaganą długość
 */
public class LengthOfPassAndLogVerifier implements AccountVerifier {

    public boolean isAdequate(String word) {
        int lenght = word.length();
        if (lenght < 6) {
            System.out.println("\tZły format danych!!!\nWymagana długość to 6 znaków!!!");
            return false;
        } else return true;
    }
}
