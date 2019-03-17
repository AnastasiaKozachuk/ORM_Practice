package com.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry(6000);

            StudentInfo stub = (StudentInfo) registry.lookup("studInfo");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String studName = sc.nextLine();
            System.out.println();

            System.out.println("All students JDBC: \n");
            System.out.println(stub.getInfoAboutAllStud());


            System.out.println("\nCurrent student JDBC -" + studName + ": \n");
            System.out.println(stub.getInfoAboutOneStud(studName));

            System.out.println("All students Hibernate: \n");
            System.out.println(stub.getInfoAboutAllStudH());


            System.out.println("\nCurrent student Hibernate - " + studName + ": \n");
            System.out.println(stub.getInfoAboutOneStudH(studName));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
