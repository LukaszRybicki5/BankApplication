package com.controller;

import com.model.Client;
import com.jsonparser.JSONFileToArrayMaker;
import java.util.List;
/*
Tworzymy prosty generator numeru konta opieramy się na liczbach pseudolosowych
numer konta dla ułatwienia będzie miał tylko 6 cyfr sprawdzamy czy numer już nie istnieje
 */
class AccountNumberMaker {

    long AccountNumber;

    public long getRandomAccountNumber() {

        JSONFileToArrayMaker jsonFileToArrayMaker = new JSONFileToArrayMaker();
        List<Client> clientList = jsonFileToArrayMaker.putingJSONFileToArray();

        AccountNumber = (long) (Math.random() * 1000000);

        for (Client c : clientList) {
            if ((AccountNumber == c.getAccountNumber()) || (AccountNumber < 100000)) {
                return getRandomAccountNumber();
            }
        }return AccountNumber;
    }
}



