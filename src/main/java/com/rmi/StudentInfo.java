package com.rmi;

import com.db.model.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentInfo extends Remote {

    String getInfoAboutAllStud() throws RemoteException;
    String getInfoAboutOneStud(String name) throws RemoteException;

    String getInfoAboutAllStudH() throws RemoteException;
    String getInfoAboutOneStudH(String name) throws RemoteException;
}
