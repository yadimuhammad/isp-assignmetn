package com.yadimr.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    private static Scanner scan;
    private static String[][] bookShelf = new String[0][3];
    private static String inputs = null;
    private static int len = 0;
    private static PrintStream console = System.out;
    

    public static void main(String[] args) throws IOException
    {
        scan = new Scanner(System.in);
        if(args.length>0){
            File f = new File(args[0]);
            BufferedReader b = new BufferedReader(new FileReader(f));
            // String inputs ="";
            File fo = new File("file-out.txt");
            FileOutputStream fos = new FileOutputStream(fo);
            PrintStream ps = new PrintStream(fo);
            while((inputs = b.readLine()) != null){
                System.out.println(inputs);
                
                // System.setOut(ps);

                if(inputs.substring(0,1).equals("c")){
                    String[] BookSlothNew = inputs.split(" ");
                    int bookSlots = Integer.parseInt(BookSlothNew[1]);
                    createBookShelf(bookSlots);
                    
                }else if (inputs.substring(0,3).equals("put")){
                    System.setOut(ps);
                    putBook();
                }else if(inputs.substring(0,4).equals("list")){
                    System.setOut(ps);
                    listAll();
                }else if (inputs.substring(0,3).equals("rem")){
                    System.setOut(ps);
                    rmvBook();
                }else if(inputs.substring(0,3).equals("fin")){
                    System.setOut(ps);
                    findAuthor();
                }else if(inputs.substring(0,3).equals("tit")){
                    System.setOut(ps);
                    findTitles();
                }
            }
        }else {
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
        System.setOut(console);
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
        System.setOut(console);
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
        System.setOut(console);
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
            System.setOut(console);
    }
    private static void findTitles(){
        String[] author = inputs.split(" ");
            switch (author[0]) {
                case "titles-by-author":
                String status = "";
                int trigger = 0;
                    for (int i = 0; i < len; i++) {
                        if(bookShelf[i][2].equals(author[1])){
                            System.out.println(bookShelf[i][1]);
                            trigger = 1;
                        }else {
                            status = "Not Found";
                        }
                    }
                    if(trigger == 0){
                        System.out.println(status);
                    }
                    break;
                default:
                    break;
            }
            System.setOut(console);
    }
}
