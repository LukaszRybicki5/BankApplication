package com.controller;

import com.options.*;
import com.options.investment.InvestmentFinisher;
import com.options.investment.InvestmentController;
import com.options.display.AccountBallanceDisplayer;
import com.options.display.AccountDataDisplayer;
import com.options.display.AccountDataEditor;
import com.options.transfer.TransferManager;
import com.model.Client;
import com.jsonparser.JSONFileToArrayMaker;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
/*
Działania możliwe do wykonania na stronie konta
 */

public class ActionOnAccountManager {

    public void actionsToChoose(long AccountNumber) throws IOException {
        boolean optionFlag = true;

        Menu menu = new Menu();
        System.out.println("<------------------------------------->" +
                "\nWitaj na stronie swojego konta!!!");

        OptionOnAccountSwitcher optionOnAccountSwitcher = null;

        JSONFileToArrayMaker jsonFileToArrayMaker = new JSONFileToArrayMaker();

        while (optionFlag) {
            List<Client> clientList = jsonFileToArrayMaker.putingJSONFileToArray();

            Scanner put = new Scanner(System.in);

            System.out.println("<-------------------------------------> " +
                    "\nWybierz co chcesz zrobić:" +
                    "\na) Sprawdzenie danych" +
                    "\nb) Sprawdzenie stanu konta" +
                    "\nc) Wykonanie przelewu" +
                    "\nd) Założenie lokaty" +
                    "\ne) Edycja danych" +
                    "\nf) Zamknięcie lokaty" +
                    "\nx) Bezpieczne wylogowanie się");
            String choice = put.nextLine();

            switch (choice) {

                case "a":
                    optionOnAccountSwitcher = new AccountDataDisplayer();
                    optionOnAccountSwitcher.choosenOption(AccountNumber, clientList);
                    break;
                case "b":
                    optionOnAccountSwitcher = new AccountBallanceDisplayer();
                    optionOnAccountSwitcher.choosenOption(AccountNumber, clientList);
                    break;
                case "c":
                    optionOnAccountSwitcher = new TransferManager();
                    optionOnAccountSwitcher.choosenOption(AccountNumber, clientList);
                    break;
                case "d":
                    optionOnAccountSwitcher = new InvestmentController();
                    optionOnAccountSwitcher.choosenOption(AccountNumber, clientList);
                    break;
                case "e":
                    optionOnAccountSwitcher = new AccountDataEditor();
                    optionOnAccountSwitcher.choosenOption(AccountNumber, clientList);
                    break;
                case "f":
                    optionOnAccountSwitcher = new InvestmentFinisher();
                    optionOnAccountSwitcher.choosenOption(AccountNumber, clientList);
                    break;
                case "x":
                    optionFlag = false;
                    clientList.removeAll(clientList);
                    menu.showingMenu();
                    break;
                default:
                    System.out.println("\tBłąd!!! " +
                            "\nWybierz opcje " +
                            "(wpisz małą literę a, b, c, d, e, f lub x w konsolę).");
                    break;
            }
        }
    }
}
