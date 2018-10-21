package com.options.transfer;

import com.options.OptionOnAccountSwitcher;
import com.model.Client;
import com.jsonparser.JSONFileMaker;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TransferManager implements OptionOnAccountSwitcher {

    public void choosenOption(long AccountNumber, List<Client> clientList) {

        JSONFileMaker JSONFileMaker = new JSONFileMaker();
        Scanner input = new Scanner(System.in);
        TransferSender transferSender = new TransferSender();
        try {
            for (Client c : clientList) {
                if (AccountNumber == c.getAccountNumber()) {
                    double amountOfMoneyCouldSend = c.getAccountBalance();
                    System.out.printf(
                            "<-------------------------------------->\n" +
                                    "Twój stan konta to:\n" +
                                    "%.2f złotych." +
                                    "\nPodaj numer konta na jaki chcesz dokonać przelewu:\n", c.getAccountBalance());
                    long accountToSendMoney = input.nextLong();

                    if (accountToSendMoney == c.getAccountNumber()) {
                        System.out.println("Wybrałeś własny numer konta!!!");
                        break;
                    }

                    System.out.println("Podaj kwotę jaką chcesz przelać:");

                    double amountOfMoneyToSend = input.nextDouble();

                    if (amountOfMoneyToSend < 0.01) {
                        System.out.println("Podana kwota jest za mała!!!");
                        break;
                    }

                    if ((amountOfMoneyCouldSend - amountOfMoneyToSend) < 0) {
                        System.out.println("Wysyłana kwota jest większa od posiadanej!!!");
                        break;
                    }

                    boolean isAccExist = transferSender.makingTransfer(accountToSendMoney, amountOfMoneyToSend, clientList);

                    if (isAccExist) {
                        c.setAccountBalance(c.getAccountBalance() - amountOfMoneyToSend);
                    } else
                        System.out.println("Podany numer konta nie istnieje!!!");

                    JSONFileMaker.createFile(clientList);
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadziłeś zły format danych!!!");
        }
    }
}