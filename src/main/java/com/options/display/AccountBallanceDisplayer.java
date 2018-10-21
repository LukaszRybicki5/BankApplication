package com.options.display;

import com.options.OptionOnAccountSwitcher;
import com.model.Client;
import java.util.List;
/*
Pokazujemy aktualny stan konta
 */
public class AccountBallanceDisplayer implements OptionOnAccountSwitcher {

    public void choosenOption(long AccountNumber, List<Client> clientList) {

        for (Client c: clientList) {
            if (AccountNumber == c.getAccountNumber()) {
                System.out.printf("<-------------------------------------->\n" +
                                "Twój stan konta równa się:\n" +
                                  "%.2f złotych.\n", c.getAccountBalance());
                break;
            };
        }
    }
}
