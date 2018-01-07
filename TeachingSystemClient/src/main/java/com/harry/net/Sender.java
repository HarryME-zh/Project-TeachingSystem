/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harry.net;

/**
 *
 * @author harry
 */
import java.io.IOException;
import java.io.Serializable;
import org.apache.commons.lang.SerializationUtils;

public class Sender extends BaseConnector {
    public Sender(String queueName) throws Exception {
        super(queueName);
    }

    public void sendMessage(Serializable object) throws IOException {
        //The second parameter is the queue name. 
        //The fourth parameter is the serialize message body)
        channel.basicPublish("",queueName, null, SerializationUtils.serialize(object));
    }   
}
