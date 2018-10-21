package com.options.investment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.options.OptionOnAccountSwitcher;
import com.model.Client;
import com.jsonparser.JSONFileMaker;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
Nadajemy wartość polu InvestmentBalance, InvestmentProcent = 1%, nadajemy date utworzenia
 */
public class InvestmentController implements OptionOnAccountSwitcher {

    Date dateOfOpening = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    JSONFileMaker JSONFileMaker = new JSONFileMaker();

    public void choosenOption(long AccountNumber, List<Client> clientList) {
        try {
            for (Client c : clientList) {
                if (AccountNumber == c.getAccountNumber()) {
                    if (c.getInvestmentBalance() > 0L) {
                        System.out.println("Masz juz lokatę!!!");
                        break;
                    }
                    System.out.printf("<-------------------------------------->\n" +
                            "Twój stan konta równa się:\n" +
                            "%.2f złotych.\n" +
                            "Wpisz kwotę z której mamy utworzyc lokatę:\n", c.getAccountBalance());

                    Scanner input = new Scanner(System.in);
                    double amountMoneyToInvest = input.nextDouble();

                    //nadajemy wartość oprocentowania
                    c.setInvestmentProcent(1);

                    double amountMoneyOnAccount = c.getAccountBalance();

                    if (amountMoneyToInvest > amountMoneyOnAccount) {
                        System.out.println("Podana kwota jest większa niż obecny stan konta!!!");
                        break;
                    }

                    if (amountMoneyToInvest < 0.01) {
                        System.out.println("Podana kwota jest za mała!!!");
                        break;
                    }
                    double currentAccountBalance = amountMoneyOnAccount - amountMoneyToInvest;

                    c.setInvestmentBalance(amountMoneyToInvest);
                    c.setAccountBalance(currentAccountBalance);

                    //z czasu założenia lokaty tworzymy String
                    String TimeOfOpeningInvestment = dateFormat.format(dateOfOpening);
                    c.setTimeOfOpeningInvestment(TimeOfOpeningInvestment);

                    JSONFileMaker.createFile(clientList);

                    System.out.println("Dokonano wpłaty na lokatę!!!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadziłeś zły format danych!!!");
        }
    }
}
