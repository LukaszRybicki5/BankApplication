package com.controller;

import com.checkers.*;
import com.model.Client;
import com.jsonparser.AccountFileMaker;
import com.jsonparser.JSONFileToArrayMaker;
import com.jsonparser.JSONFileMaker;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/*
Nadajemy wartości polom z danymi klienta i robimy weryfikacje
 */
public class AccountMaker {

    double accountBalance = 1000;
    Scanner input = new Scanner(System.in);
    PassAndLogVerifier passAndLogVerifier = new PassAndLogVerifier();

    public void addNewClient() throws IOException {
        Date today = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String TimeOfOpeningInvestment = dateFormat.format(today);
        JSONFileToArrayMaker jsonFileToArrayMaker = new JSONFileToArrayMaker();
        List<Client> clientList = jsonFileToArrayMaker.putingJSONFileToArray();
        AccountNumberMaker accountNumberMaker = new AccountNumberMaker();

        Client client = new Client();

        boolean optionFlag2 = true;

        System.out.printf("<--------------------------------------->" +
                        "\n\tWitaj w systemie tworzenia konta!!!" +
                        "\n\tZa założenie konta otrzymasz %.2f złotych" +
                        "\n\tPodaj swoje dane według poleceń:\n" +
                        "<--------------------------------------->\n", accountBalance);
        try {
            while (optionFlag2) {
                client.setAccountBalance(accountBalance);
                client.setAccountNumber(accountNumberMaker.getRandomAccountNumber());
                client.setInvestmentBalance(0);
                client.setTimeOfOpeningInvestment(TimeOfOpeningInvestment);

                AccountVerifier accountVerifier = new FirstAndLastNameVerifier();
                System.out.println("Podaj swoje imie:");
                String firstName = input.nextLine().trim();
                if (accountVerifier.isAdequate(firstName))
                    client.setFirstName(firstName);
                else break;

                System.out.println("Podaj swoje nazwisko:");
                String lastName = input.nextLine();
                if (accountVerifier.isAdequate(lastName.trim()))
                    client.setLastName(lastName);
                else break;

                accountVerifier = new LenghtVerifier();
                System.out.println("Podaj swój adres\nPodaj miasto:");
                String city = input.nextLine();
                if (accountVerifier.isAdequate(city.trim()))
                    client.setCity(city);
                else break;

                System.out.println("Podaj ulicę:");
                String street = input.nextLine();
                if (accountVerifier.isAdequate(street.trim()))
                    client.setStreet(street);
                else break;

                System.out.println("Podaj numer domu:");
                String numberOfHouse = input.nextLine();
                if (accountVerifier.isAdequate(numberOfHouse.trim()))
                    client.setNumberOfHouse(numberOfHouse);
                else break;

                accountVerifier = new PostalCodeLengthVerifier();
                System.out.println("Podaj kod pocztowy w formacie AB-CDE:");
                String postalCode = input.nextLine().trim();
                boolean areNumbers = accountVerifier.isAdequate(postalCode);
                accountVerifier = new DashVerifier();
                boolean isDash = accountVerifier.isAdequate(postalCode);

                if(areNumbers && isDash)
                    client.setPostalCode(postalCode.trim());
                else break;

                System.out.println("Podaj swój login o co najmniej 6 znakach:");
                String InputLogin = input.nextLine().trim();

                System.out.println("Podaj swóje hasło o co najmniej 6 znakach:");
                String InputPass = input.nextLine().trim();

                if (passAndLogVerifier.isAlreadyPassOrLogInDB(InputPass, InputLogin)) {
                    System.out.println("Hasło lub login istnieje już w bazie!!!" +
                            "\nProszę spróbować ponownie!!!");
                    break;
                }

                accountVerifier = new LengthOfPassAndLogVerifier();
                if (accountVerifier.isAdequate(InputLogin))
                    client.setAccountLogin(InputLogin);
                else
                    break;

                if (accountVerifier.isAdequate(InputPass))
                    client.setAccountPassword(InputPass);
                else
                    break;

                System.out.printf(
                        "<------------------------------------->" +
                                "\nWitaj w systemie bankowym użytkowniku:\n" +
                                client.getFirstName() + " " + client.getLastName() +
                                "\nTwój numer konta to: " + client.getAccountNumber() +
                                "\n<------------------------------------->" +
                                "\n\tTwój obecny stan konta równa %.2f złotych." +
                                "\n\tProponujemy dokonać wpłaty na konto.\n" +
                                "<------------------------------------->\n", accountBalance);

                clientList.add(client);

                AccountFileMaker accountFileMaker = new JSONFileMaker();
                accountFileMaker.createFile(clientList);

                ActionOnAccountManager actionOnAccountManager = new ActionOnAccountManager();
                actionOnAccountManager.actionsToChoose(client.getAccountNumber());
                optionFlag2 = false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono niepoprawny format danych!!!\nPonów próbę!!!");
        }
    }
}
