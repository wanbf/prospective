package com.prospective.practice.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by wanbf on 2018/1/24.
 */
public interface Hello extends Remote {
    public String sayHello(String name) throws RemoteException;
}
