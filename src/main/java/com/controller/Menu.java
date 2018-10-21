package com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import static java.lang.System.exit;

/*
Menu do rozpoczynania pracy z aplikacja
 */
public class Menu {

    boolean optionFlag = true;

    public void showingMenu() throws IOException {

        Scanner input = new Scanner(System.in);
        AccountMaker accountMaker = new AccountMaker();
        LoginManager loginManager = new LoginManager();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();

        while (optionFlag) {

            System.out.println("<-------------------------------------->" +
                    "\n\tWitaj w systemie bankowym!!!" +
                    "\n\t\t" + dateFormat.format(date) +
                    "\n<--------------------------------------> " +
                    "\nWybierz:" +
                    "\na) Nowe konto" +
                    "\nb) Logowanie do systemu" +
                    "\nx) Koniec programu");

            String choice = input.nextLine();

            switch (choice) {
                case "a":  //zakładamy nowe konto, nadajemy wartości polom z package com.model
                    accountMaker.addNewClient();
                    break;
                case "b":
                    loginManager.actionAccountManager();
                    break;
                case "x":
                    optionFlag = false;
                    exit(0);
                    break;
                default:
                    System.out.println("\tBłąd!!!\nWybierz opcje " +
                            "(wpisz małą literę a lub b w konsolę).");
                    break;
            }
        }
    }
}
