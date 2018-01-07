/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harry.controller;

import com.harry.model.SystemOperation;
import com.harry.net.Receiver;
import com.harry.view.SelectionOperation;
import java.awt.Robot;

/**
 *
 * @author harry
 */
public class SystemProcess {
    
    public static void infoDataProcess() throws Exception{
        
        SystemOperation.infoDataIn();                
        SelectionOperation.selectionMain();          // Change User Interface
    }
    
    public static void dataUploadProcess(String dataIn) throws Exception{
        SystemOperation.courseDataUpload(dataIn);    
    }
    
    public static void checkProcess(String courseID) throws Exception{
        Receiver receiver = new Receiver("Queue3");      //The Queue Name Selection No.3
            Thread receiverThread = new Thread(receiver);
            receiverThread.start();                      // Start the receive Thread 
            SystemOperation.checkDataIn(courseID);       // Remote call the server to start transmit the data     
            System.out.println("Waiting for msg");        
            new Robot().delay(100);                      // Waiting for 100ms and then shows the interface
           
    }
    
}
