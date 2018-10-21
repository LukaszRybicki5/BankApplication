package com.options.investment;

import com.model.Client;
import com.jsonparser.JSONFileMaker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/*
Obliczamy wzrost stanu lokaty zakładamy 1%, w skali 60 minut
 */
public class InvestmentEvaluater {

    double investmentToExcell = 0;

    public double currentInvestment(long AccountNumber, List<Client> clientList) {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        JSONFileMaker JSONFileMaker = new JSONFileMaker();

        for (Client c : clientList) {
            if (AccountNumber == c.getAccountNumber()) {

                double investmentBalance = c.getInvestmentBalance();
                String TimeOfOpeningInvestment = c.getTimeOfOpeningInvestment();

                try {
                    Date startDate = dateFormat.parse(TimeOfOpeningInvestment);
                    Date endDate = new Date();

                    int timeToExcell = countDifference(startDate, endDate);

                    investmentToExcell = currentInvestment(investmentBalance, timeToExcell, c.getInvestmentProcent());

                } catch (ParseException e) {
                    e.printStackTrace();
                } finally {
                    JSONFileMaker.createFile(clientList);
                }
            }
        }
        return investmentToExcell;
    }

    // zwracam liczbe minut od założenia konta
    private int countDifference(Date startDate, Date endDate) {

        double different = endDate.getTime() - startDate.getTime();

        double minutesInMilli = 60000;

        int elipsedMinutes = (int) (different / minutesInMilli);

        return elipsedMinutes;
    }

    //proste zwiększanie kwoty na lokacie wykorzystujace potęgowanie
    private double currentInvestment(double investmentBalance, int elipsedMinutes, double investmentProcent) {

        if (elipsedMinutes < 60) {
            elipsedMinutes = 1;
        }
        double currentValue = Math.pow((1 + investmentProcent / 100), (elipsedMinutes/60));

        double investment = investmentBalance * currentValue;

        //w razie błędu jsona
        if ((investment < 0.0)){
            System.out.println("Błąd bazy danych!!!");
            return investment = 0.0;
        }

        double maxValue = Double.MAX_VALUE;
        if (investment >= maxValue){
            System.out.println("Osiągnięto maksymalną wartość lokaty!");
            return maxValue;
        }
        return investment;
    }
}