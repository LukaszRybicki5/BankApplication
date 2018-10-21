package com.options.display;

import com.checkers.*;
import com.options.OptionOnAccountSwitcher;
import com.model.Client;
import com.jsonparser.JSONFileMaker;
import java.util.List;
import java.util.Scanner;
/*
Zmieniamy pola na liście, weryfikujemy zgodność podawanych danych
 */
public class AccountDataEditor implements OptionOnAccountSwitcher {

    Scanner input = new Scanner(System.in);
    boolean optionFlag = true;

    public void choosenOption(long AccountNumber, List<Client> clientList) {

        JSONFileMaker JSONFileMaker = new JSONFileMaker();
        AccountVerifier accountVerifier = null;

        for (Client c : clientList) {
            if (AccountNumber == c.getAccountNumber()) {

                System.out.println("<-------------------------------------->" +
                        "\n\tWitaj w systemie edycji danych!!!" +
                        "\n<---------------------------------------> ");
                while (optionFlag) {

                    System.out.println("Wybierz co chcesz zrobić:" +
                            "\na) Zmiana imienia" +
                            "\nb) Zmiana nazwiska" +
                            "\nc) Zmiana miasta" +
                            "\nd) Zmiana ulicy" +
                            "\ne) Zmiana numeru domu" +
                            "\nf) Zmiana kodu pocztowego" +
                            "\nx) Zakończenie edycji");

                    Scanner input = new Scanner(System.in);
                    String choice = input.nextLine();
                    switch (choice) {

                        case "a":
                            accountVerifier = new FirstAndLastNameVerifier();
                            System.out.println("Podaj nowe imie:");
                            String firstName = input.nextLine().trim();
                            if (accountVerifier.isAdequate(firstName))
                                c.setFirstName(firstName.trim());
                            else break;
                            break;

                        case "b":
                            accountVerifier = new FirstAndLastNameVerifier();
                            System.out.println("Podaj nowe nazwisko:");
                            String lastName = input.nextLine().trim();
                            if (accountVerifier.isAdequate(lastName))
                                c.setLastName(lastName);
                            else break;
                            break;

                        case "c":
                            accountVerifier = new LenghtVerifier();
                            System.out.println("Podaj nowe miasto:");
                            String city = input.nextLine().trim();
                            if (accountVerifier.isAdequate(city))
                                c.setCity(city);
                            else break;
                            break;

                        case "d":
                            accountVerifier = new LenghtVerifier();
                            System.out.println("Podaj nową ulicę:");
                            String street = input.nextLine().trim();
                            if (accountVerifier.isAdequate(street))
                                c.setStreet(street);
                            else break;
                            break;

                        case "e":
                            accountVerifier = new LenghtVerifier();
                            System.out.println("Podaj nowy numer domu:");
                            String numberOfHouse = input.nextLine().trim();
                            if (accountVerifier.isAdequate(numberOfHouse))
                                c.setNumberOfHouse(numberOfHouse);
                            else break;
                            break;

                        case "f":
                            accountVerifier = new PostalCodeLengthVerifier();
                            System.out.println("Podaj nowy kod pocztowy w formacie AB-CDE:");
                            String postalCode = input.nextLine().trim();
                            boolean areNumbers = accountVerifier.isAdequate(postalCode);
                            accountVerifier = new DashVerifier();
                            boolean isDash = accountVerifier.isAdequate(postalCode);

                            if (areNumbers && isDash)
                                c.setPostalCode(postalCode);
                            else break;
                            break;
                        case "x":
                            optionFlag = false;
                            break;

                        default:
                            System.out.println("\tBłąd!!!\nWybierz opcje " +
                                    "(wpisz małą literę a, b, c, d, e lub f w konsolę.\n");
                            break;
                    }
                    JSONFileMaker.createFile(clientList);
                }
            }
        }
    }
}
