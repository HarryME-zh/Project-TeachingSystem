/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harry.startup;

import com.harry.controller.SystemInitial;
/**
 *
 * @author harry
 */
public class SystemServer {


public static String SERVER_IP;

public static void main(String[] args) throws Exception{ 
    SystemInitial.interfaceInitial();
    
} 

public static String getCTX(String originalCTX,String firstSplit,String secondSplit){
        String resultCTX = originalCTX.substring(originalCTX.lastIndexOf(firstSplit), 
        originalCTX.lastIndexOf(secondSplit));
        resultCTX = resultCTX.substring(1,resultCTX.length());
        return resultCTX;
    }


}  

