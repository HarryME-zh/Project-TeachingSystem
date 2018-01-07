/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harry.model;

import com.harry.common.RMIInterface;
import static com.harry.startup.SystemClient.URL;
import java.rmi.Naming;
import com.harry.net.Receiver;
import com.harry.net.Sender;
import static com.harry.startup.SystemClient.getCTX;
/**
 *
 * @author harry
 */
public class SystemOperation {
    
    static String[] dataUpload;
    
    public static void infoDataIn() throws Exception{
        RMIInterface userOperation=(RMIInterface)Naming.lookup(URL);
        userOperation.firstDataExchange();
        Receiver receiver = new Receiver("Queue");
        Thread receiverThread = new Thread(receiver);
        receiverThread.start();
     
    }
    
    public static void courseDataUpload(String dataIn) throws Exception{
        
        RMIInterface userOperation=(RMIInterface)Naming.lookup(URL);
        
        Sender sender = new Sender("Queue2");
        DataInfo dataInfo = new DataInfo();
        
        dataUpload =  dataIn.split("\n"); 
       
        
        for(int i = 0;i<dataUpload.length;i++){
            
            String dataTemp = "(" + dataUpload[i] + ")";
            String studentInfo = getCTX(dataTemp,"(",">");
            String courseID = getCTX(dataTemp,"-",")");
            System.out.println("Student name & ID: "+studentInfo+" course ID: "+ courseID);
            dataInfo.setItemName(studentInfo);
            dataInfo.setItemID(courseID);
            dataInfo.printItem();
            sender.sendMessage(dataInfo);
        }
        
        userOperation.resultUpload();
        
    }
    
    
    public static void checkDataIn(String courseID) throws Exception{
        RMIInterface userOperation=(RMIInterface)Naming.lookup(URL);
        userOperation.checkExchange(courseID);
    }
    
}
