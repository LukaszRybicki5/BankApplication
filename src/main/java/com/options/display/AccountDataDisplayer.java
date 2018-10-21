package com.options.display;

import com.options.OptionOnAccountSwitcher;
import com.options.investment.InvestmentEvaluater;
import com.model.Client;
import java.util.List;
/*
Pokazujemy dane klienta
 */
public class AccountDataDisplayer implements OptionOnAccountSwitcher {

    double investmentBalance;

    public void choosenOption(long AccountNumber, List<Client> clientList) {

        InvestmentEvaluater investmentEvaluater = new InvestmentEvaluater();

        for (Client c: clientList) {

            if (AccountNumber == c.getAccountNumber()) {
                investmentBalance = investmentEvaluater.currentInvestment(AccountNumber, clientList);

                System.out.printf(
                        "<-------------------------------------->\n" +
                                "Twoje imie i nazwisko:\n" +
                                c.getFirstName() + " "
                                + c.getLastName() +
                                "\nTwój numer konta:\n"
                                + c.getAccountNumber() +
                                "\nTwój stan konta równa się:\n"
                                + "%.2f złotych" +
                                "\nTwój stan lokaty równa się:\n"
                                + "%.2f złotych" +
                                "\nTwoje dane adresowe:\n"
                                + c.getStreet() + " "
                                + c.getNumberOfHouse() + "\n"
                                + c.getPostalCode() + " "
                                + c.getCity(),c.getAccountBalance(), investmentBalance);
                System.out.println();
                break;
            }
        }
    }
}