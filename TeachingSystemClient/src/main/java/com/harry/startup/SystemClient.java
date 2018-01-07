/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harry.startup;
import com.harry.controller.UserInitial;
import java.util.*;

/**
 *
 * @author harry
 */
public class SystemClient {
    public static ArrayList<String> COURSE_LIST = new ArrayList<String>();
    public static ArrayList<String> STUDENT_LIST = new ArrayList<String>();
    public static ArrayList<String> CHECKING_LIST = new ArrayList<String>();
    public static String SERVER_IP;
    public static String URL; 
    public static String USER_NAME = null;
    public static String USER_NAME_IN = null;
    public static String DATA_TEMP = null;
    public static void main(String args[]) {
        UserInitial.initialInter();
    }
    
    public static String getCTX(String originalCTX,String firstSplit,String secondSplit){
        String resultCTX = originalCTX.substring(originalCTX.lastIndexOf(firstSplit), 
        originalCTX.lastIndexOf(secondSplit));
        resultCTX = resultCTX.substring(1,resultCTX.length());
        return resultCTX;
    }
}
