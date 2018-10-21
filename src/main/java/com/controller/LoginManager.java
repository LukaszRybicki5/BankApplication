package com.controller;

import com.model.Client;
import com.jsonparser.JSONFileToArrayMaker;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoginManager {

    public void actionAccountManager() throws IOException {
        ActionOnAccountManager actionOnAccountManager = new ActionOnAccountManager();
        AccountNumber = loginAndPasswordManager();
        actionOnAccountManager.actionsToChoose(AccountNumber);
    }

    Long AccountNumber;

    private Long loginAndPasswordManager() throws IOException {

        JSONFileToArrayMaker jsonFileToArrayMaker = new JSONFileToArrayMaker();
        List<Client> clientList = jsonFileToArrayMaker.putingJSONFileToArray();
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        int counter = 0;
        boolean optionFlag = true;

        while (optionFlag) {
            counter++;
            System.out.println(
                    "<-------------------------------------->" +
                            "\n\tWitaj w system logowania!!!" +
                            "\n<--------------------------------------> " +
                            "\nPodaj swój login:");
            String InputLogin = input.nextLine();

            System.out.println("Podaj swoje hasło:");
            String InputPassword = input.nextLine();

            for (Client c :clientList) {
                if ((InputLogin.equals(c.getAccountLogin()))
                        && (InputPassword.equals(c.getAccountPassword()))) {
                    long AccountNumber = c.getAccountNumber();

                    System.out.println(
                            "<-------------------------------------->" +
                                    "\n\tPodano prawidłowe dane!!!");
                    return AccountNumber;
                }
                if (counter > 2) {
                    System.out.println(
                            "<-------------------------------------->" +
                                    "\n\tTrzy razy wprowadziłeś niepoprawne dane!!!" +
                                    "\n<-------------------------------------->");
                    optionFlag = false;
                    menu.showingMenu();
                }
            }
        }return null;
    }
}

