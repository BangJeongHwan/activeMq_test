package com.bang.msg;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MsgSender {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // default broker URL is : tcp://localhost:61616

    private static String subject = "BANG_QUEUE";

    public static void main(String[] args) throws JMSException {

        // Getting JMS connection from the server and starting it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // /Library/Java/JavaVirtualMachines/jdk1.8.0_152.jdk/Contents/Home
        // Creating a non transactional seesion to send/receive JMS message
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Destination represents here our queue 'BANG_QUEUE' on the JMS server
        // The queue will be created automatically on the server
        Destination destination = session.createQueue(subject);

        // MessageProducer is used for sending messages to the queue
        MessageProducer producer = session.createProducer(destination);

        // We will send a small text message saying 'Hello World'
        TextMessage message = session.createTextMessage("Hello World BANG");

        producer.send(message);

        System.out.println("BANG QUEUE : " + message.getText());

        connection.close();
    }
}