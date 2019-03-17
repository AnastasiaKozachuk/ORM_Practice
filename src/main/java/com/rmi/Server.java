package com.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {


    public static void main(String args[]){
        try {

            StudentInfoImpl studentInfo = new StudentInfoImpl();

            Registry registry = LocateRegistry.createRegistry(6000);

            StudentInfo stub = (StudentInfo) UnicastRemoteObject.exportObject(studentInfo, 6000);

            registry.bind("studInfo", stub);
            System.out.println("Server ready...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }



}
