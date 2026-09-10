/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6112;

import java.util.Scanner;

/**
 *
 * @author Tekano Malebana
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("LATEST SERIES - 2025");
        System.out.println("=====================");

        System.out.print("Enter (1) to launch menu or any other key to exit: ");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {

            Series series = new Series();

            series.Menu();

        } else {

            System.out.println("Exiting application...");
        }
    }
}
