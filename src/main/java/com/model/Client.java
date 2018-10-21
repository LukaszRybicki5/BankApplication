package com.model;
/*
Tworzymy model klienta, pola i konstruktory (pusty, ze wszystkimi polami i bez danych o lokacie)
 */
public class Client {

    private String firstName;
    private String lastName;
    private Long accountNumber;
    private double accountBalance;
    private String accountLogin;
    private String accountPassword;
    private String city;
    private String street;
    private String numberOfHouse;
    private String postalCode;
    private double investmentBalance;
    private String timeOfOpeningInvestment;
    private double  investmentProcent;

    public Client() {
    }
    
    public Client(String firstName, String lastName, Long accountNumber,
                  double accountBalance, String accountLogin, String accountPassword,
                  String city, String street, String numberOfHouse, String postalCode,
                  double investmentBalance, String timeOfOpeningInvestment, double investmentProcent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountLogin = accountLogin;
        this.accountPassword = accountPassword;
        this.city = city;
        this.street = street;
        this.numberOfHouse = numberOfHouse;
        this.postalCode = postalCode;
        this.investmentBalance = investmentBalance;
        this.timeOfOpeningInvestment = timeOfOpeningInvestment;
        this.investmentProcent = investmentProcent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountLogin() {
        return accountLogin;
    }

    public void setAccountLogin(String accountLogin) {
        this.accountLogin = accountLogin;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(String numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public double getInvestmentBalance() {
        return investmentBalance;
    }

    public void setInvestmentBalance(double investmentBalance) {
        this.investmentBalance = investmentBalance;
    }

    public String getTimeOfOpeningInvestment() {
        return timeOfOpeningInvestment;
    }

    public void setTimeOfOpeningInvestment(String timeOfOpeningInvestment) {
        this.timeOfOpeningInvestment = timeOfOpeningInvestment;
    }

    public double getInvestmentProcent() {
        return investmentProcent;
    }

    public void setInvestmentProcent(double investmentProcent) {
        this.investmentProcent = investmentProcent;
    }
}
