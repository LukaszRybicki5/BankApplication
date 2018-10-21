package com.checkers;

import java.util.InputMismatchException;

/*
Sprawdzamy czy na drugim miejscu jest myślnik, i czy na pozostałych są cyfry
 */
public class DashVerifier implements AccountVerifier {

    public boolean isAdequate(String postalCode) throws InputMismatchException {
        try {
            char mark = postalCode.charAt(2);

            if ((mark != '-') || (mark == ' ')) {
                System.out.println("\tZły format danych!!!");
                return false;
            } else return true;
        }catch (IndexOutOfBoundsException e){
            System.out.println("\tWpisz myślnik w odpowiednie miejsce!!!");
        }return false;
    }
}
