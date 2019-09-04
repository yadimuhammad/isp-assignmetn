package com.yadimr.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {
    private static Scanner scan;
    private static String[][] bookShelf = new String[0][3];
    private static String inputs = null;
    private static int len = 0;

    public static void main(String[] args) throws IOException
    {
        scan = new Scanner(System.in);
        while(!(inputs = scan.nextLine()).equals("exit")){
            if(inputs.substring(0,1).equals("c")){
                String[] BookSlothNew = inputs.split(" ");
                int bookSlots = Integer.parseInt(BookSlothNew[1]);
                createBookShelf(bookSlots);
                
            }else if (inputs.substring(0,3).equals("put")){
                putBook();
            }else if(inputs.substring(0,4).equals("list")){
                listAll();
            }else if (inputs.substring(0,3).equals("rem")){
                rmvBook();
            }else if(inputs.substring(0,3).equals("fin")){
                findAuthor();
            }else if(inputs.substring(0,3).equals("tit")){
                findTitles();
            }
            
        }
    }

    private static void createBookShelf (int sums){
        String[][] bookShelfs = new String[sums][3];
        for (int i = 0; i < sums; i++) {
            for (int j = 1; j < 3; j++) {
                bookShelfs[i][0] = Integer.toString(i+1);
                bookShelfs[i][j] = "-" ;    
            }
        }
        len = sums;
        System.out.println("Created a book shelf with "+bookShelfs.length+" slots");
        bookShelf = bookShelfs;
    }
    private static void putBook(){
        int respInput = 0;
        String slot = "";
        String[] book = inputs.split(" ");
        for (int i = 0; i < len; i++) {
            if(book[1].equals(bookShelf[i][1])){
                respInput = 1;
                slot = bookShelf[i][0];
                break;
            }else if(bookShelf[i][1].equals("-")){
                bookShelf[i][1] = book[1];
                bookShelf[i][2] = book[2];
                slot = bookShelf[i][0];
                respInput = 0;
                break;
            }else{
                respInput = 2;
            }
        }
        if(respInput == 1){
            System.out.println("Book is already alocated in slot "+slot);
        }else if(respInput == 2){
            System.out.println("Book Shelf Full");
        }else{
            System.out.println("Allocated Slot number:"+slot);
        }
    }
    private static void rmvBook(){
        String[] slots = inputs.split(" ");
        for (int i = 0; i < len; i++) {
            if(slots[1].equals(bookShelf[i][0])){
                bookShelf[i][1] = "-";
                bookShelf[i][2] = "-";
                System.out.println("Slot Number "+slots[1]+" is free");
            }
        }
    }
    private static void listAll(){
        String leftAlignFormat = "| %-10s | %-35s | %-17s |%n";

        System.out.format("+------------+-------------------------------------+-------------------+%n");
        System.out.format("| Slot no.   | Book Title                          | Author            |%n");
        System.out.format("+------------+-------------------------------------+-------------------+%n");
        for (int i = 0; i < len; i++) {
            if(!bookShelf[i][1].equals("-")){
                System.out.format(leftAlignFormat, bookShelf[i][0], bookShelf[i][1], bookShelf[i][2]);
            }
        }    
        System.out.format("+------------+-------------------------------------+-------------------+%n");
    }
    private static void findAuthor(){
        String[] author = inputs.split(" ");
            switch (author[0]) {
                case "find-by-author":
                    for (int i = 0; i < len; i++) {
                        if(bookShelf[i][2].equals(author[1])){
                            System.out.println(bookShelf[i][0]);
                        }
                    }
                    break;
                case "find-by-title":
                    for (int i = 0; i < len; i++) {
                        if(bookShelf[i][1].equals(author[1])){
                            System.out.println(bookShelf[i][0]);
                        }
                    }
                    break;
                default:
                    break;
            }
    }
    private static void findTitles(){
        String[] author = inputs.split(" ");
            switch (author[0]) {
                case "titles-by-author":
                    for (int i = 0; i < len; i++) {
                        if(bookShelf[i][2].equals(author[1])){
                            System.out.println(bookShelf[i][1]);
                        }
                    }
                    break;
                default:
                    break;
            }
    }
}
