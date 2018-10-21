package com.options.investment;

import com.options.OptionOnAccountSwitcher;
import com.model.Client;
import com.jsonparser.JSONFileMaker;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
Zamykamy lokatę, przelewamy środki z lokaty na konto
 */
public class InvestmentFinisher implements OptionOnAccountSwitcher {

    public void choosenOption(long AccountNumber, List<Client> clientList) {

        JSONFileMaker JSONFileMaker = new JSONFileMaker();
        Scanner scanner = new Scanner(System.in);
        try {
            for (Client s : clientList) {
                if (AccountNumber == s.getAccountNumber()) {
                    if (s.getInvestmentBalance() == 0) {
                        System.out.println("Nie miałeś lokaty");
                        break;
                    } else
                        System.out.println("<-------------------------------------->\n" +
                                "Jeśli potwierdzasz usunięcie lokaty wpisz a\n" +
                                "Jeśli zmieniłeś zdanie wpisz b\n" +
                                "<-------------------------------------->");

                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "a":
                            InvestmentEvaluater investmentEvaluater = new InvestmentEvaluater();
                            double investmentBalance = investmentEvaluater.currentInvestment(AccountNumber, clientList);
                            double accountBalance = s.getAccountBalance() + investmentBalance;

                            double maxValue = Double.MAX_VALUE;

                            if (accountBalance > maxValue){
                                System.out.println("Osiągnięto maskymalną możliwą wielkość kwoty na koncie i lokacie!!!");
                                s.setAccountBalance(maxValue);
                                break;
                            }else
                            s.setAccountBalance(accountBalance);
                            s.setInvestmentBalance(0);
                            JSONFileMaker.createFile(clientList);
                            break;
                        case "b":
                            System.out.println("Przerwano operację.");
                            break;
                        default:
                            System.out.println("\tBłąd!!!\nWybierz opcje " +
                                    "(wpisz małą literę a lub b w konsolę).");
                            break;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadziłeś zły format danych!!!");
        }
    }
}