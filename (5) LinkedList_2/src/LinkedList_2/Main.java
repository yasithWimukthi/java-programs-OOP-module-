package LinkedList_2;

import com.sun.org.apache.xerces.internal.impl.xs.util.XSObjectListImpl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      LinkedList<String> placesToVisit = new LinkedList<String>();
       /* placesToVisit.add("Sydney");    // ADD ITEMS TO LINKED LIST
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");

        printList(placesToVisit);

        placesToVisit.add(1,"Alice springs");   //ADD ITEMS TO SPECIFIC INDEX OF THE LINKED LIST
        printList(placesToVisit);

        placesToVisit.remove(4);    // REMOVE AN ITEM FROM THE LINKED LIST
        printList(placesToVisit); */

        addInOrder(placesToVisit,"Sydney");
        addInOrder(placesToVisit,"Melbourne");
        addInOrder(placesToVisit,"Brisbane");
        addInOrder(placesToVisit,"Perth");
        addInOrder(placesToVisit,"Canberra");
        addInOrder(placesToVisit,"Adelaide");
        addInOrder(placesToVisit,"Darwin");

        printList(placesToVisit);

        addInOrder(placesToVisit,"Alice springs");
        addInOrder(placesToVisit,"Darwin");
        printList(placesToVisit);

        visit(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList){
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()){
            System.out.println("Now visiting : "+i.next());
        }
        System.out.println("===============================================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()){
            int comparison = listIterator.next().compareTo(newCity);
            if (comparison==0){
                //EQUAL, DO NOT ADD
                System.out.println(newCity+" is already included as a destination.");
                return false;
            }
            else if(comparison>0){
                listIterator.previous();
                listIterator.add(newCity);
                return true;
            }
            else if(comparison<0){
                // MOVE ON NEXT CITY
            }
        }
        listIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()){
            System.out.println("No cities in the itinerary.");
            return;
        }else {
            System.out.println("Noe visiting : "+listIterator.next());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Holiday over!!!");
                    quit = true;
                    break;

                case 1:
                    if (!goingForward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now visiting : "+listIterator.next());
                    }else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now visiting : "+listIterator.previous());
                    }else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions : \npress");
        System.out.println("0 - to quit.\n" +
                "1 - go to next city.\n" +
                "2 - go to previous city.\n" +
                "3 - print menu options.");
    }
}
