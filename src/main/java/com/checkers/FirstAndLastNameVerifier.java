package com.checkers;

/*
Sprawdzamy czy nie wprowadzamy pustego Stringa
*/
public class FirstAndLastNameVerifier implements AccountVerifier {

    public boolean isAdequate(String Name) {
            if(Name.equals("")){
                System.out.println("\tNie wprowadzono wymaganych danych!!!");
                return false;
            }else return true;
    }

}
