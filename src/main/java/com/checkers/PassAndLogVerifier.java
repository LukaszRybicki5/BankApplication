package com.checkers;

import com.model.Client;
import com.jsonparser.JSONFileToArrayMaker;
import java.util.List;
/*
Sprawdzamy czy hasło i login nie istnieją juz na liście
 */
public class PassAndLogVerifier {

    boolean check;

    public boolean isAlreadyPassOrLogInDB(String AccountPassword, String AccountLogin) {

        JSONFileToArrayMaker jsonFileToArrayMaker = new JSONFileToArrayMaker();

        List<Client> clientList = jsonFileToArrayMaker.putingJSONFileToArray();

        for (Client c : clientList) {
            if ((AccountPassword.equals(c.getAccountPassword()) || (AccountLogin.equals(c.getAccountLogin())))
                    ||
             (AccountPassword.equals(c.getAccountLogin()) || (AccountLogin.equals(c.getAccountPassword())))){
                check = true;
                break;
            }else check = false;
        } return check;
    }
}