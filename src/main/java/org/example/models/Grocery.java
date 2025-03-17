package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static ArrayList <String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void startGrocery(){
        int choice;

        do{
            System.out.println("Lütfen yapmak istediğiniz operasyonu seçin. (0 = çıkış, 1 = ekleme, 2 = çıkarma)");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;

                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Geçersiz tercih");
            }
            printSorted();
        } while (choice != 0);
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            item = item.trim();
            if (!groceryList.contains(item)) {
                groceryList.add(item);
            }
        }


    }

    public static void removeItems(String input){
        String[] items = input.split(",");

        for(String item: items){
            item = item.trim();
            if(checkItemIsInList(item)){
                groceryList.remove(item);
            }
        }

    }

    public static boolean checkItemIsInList(String item){
        return groceryList.contains(item);
    }

    public static void printSorted(){
        sortItems();
        System.out.println("Mevcut Pazar Listesi: ");
        for (String item: groceryList){
            System.out.println(item);
        }
    }

    private static void sortItems() {
        Collections.sort(groceryList);
    }
}
