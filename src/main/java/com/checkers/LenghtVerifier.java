package com.checkers;
/*
Sprawdzamy czy nie zostały wpisane puste pola
 */
public class LenghtVerifier implements AccountVerifier {

    public boolean isAdequate(String word){
        if(word.equals("")){
            System.out.println("Nie podano wartości");
            return false;
        }else return true;
    }
}
