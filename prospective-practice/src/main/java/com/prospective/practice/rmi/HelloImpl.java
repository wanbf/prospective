package com.prospective.practice.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by wanbf on 2018/1/24.
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {
    private static final long serialVersionUID = -271947229644133464L;

    protected HelloImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return String.format("Hello : %s", name);
    }
}
