package com.options.transfer;

import com.model.Client;
import com.jsonparser.JSONFileMaker;
import java.util.List;
/*
Znając kwotę do przelania numer konta i listę klientów dokonujemy przelewu
 */
public class TransferSender {

    public boolean makingTransfer(long AccountToSendMoney, double AmountOfMoneyToSend, List<Client> clientList) {

        JSONFileMaker JSONFileMaker = new JSONFileMaker();

        for (Client l: clientList) {
            if (AccountToSendMoney == l.getAccountNumber()) {

                l.setAccountBalance(l.getAccountBalance() + AmountOfMoneyToSend);

                JSONFileMaker.createFile(clientList);
                return true;
            }
        }return false;
    }
}