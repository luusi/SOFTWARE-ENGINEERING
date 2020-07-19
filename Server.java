/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.july;

/**
 *
 * @author studente
 */
import javax.xml.ws.Endpoint;

public class Server {
     public static void main(String args[]) throws InterruptedException {
        WSImpl implementor = new WSImpl();
        //String address = "http://0.0.0.0:7777/WSInterface";
        String address = "http://localhost:8080/WSInterface";
        Endpoint.publish(address, implementor);
        System.out.println("Server started...");
        while(true) {}
    
}
    
}
