package com.codegym;

import com.codegym.view.ContactMenu;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ContactMenu contactMenu = new ContactMenu();
        contactMenu.run();
    }
}
