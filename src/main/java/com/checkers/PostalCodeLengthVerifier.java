package com.checkers;

/*
Sprawdzamy czy w Stringu mamy dwa znaki myślnik, mniej niż 6 znaków i mamy cyfry w odpowiednich miejscach
 */
public class PostalCodeLengthVerifier implements AccountVerifier {

    private boolean Status;

    public boolean isAdequate(String postalCode) {

        if (postalCode.equals("") || (postalCode.length() != 6)) {
            System.out.println("\tZła długość kodu!!!");
            return false;
        }

        Status = ( Character.isDigit(postalCode.charAt(0)) && Character.isDigit(postalCode.charAt(1)) &&
                Character.isDigit(postalCode.charAt(3)) && Character.isDigit(postalCode.charAt(4))
                && Character.isDigit(postalCode.charAt(5)));
        if(!Status){
            System.out.println("Wprowadż cyfry!!!");
            return Status;
        }else return Status;
    }
}


