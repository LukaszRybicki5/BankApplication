package com;

import com.controller.Menu;

import java.io.IOException;
/*
Klasa rozruchowa
 */
public class BankApp {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.showingMenu();
    }
}