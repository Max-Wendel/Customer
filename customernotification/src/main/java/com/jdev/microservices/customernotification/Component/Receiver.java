package com.jdev.microservices.customernotification.Component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class Receiver {

    @Autowired
    Mailer mailer;

    @Bean
    Queue queue(){
        return new Queue("CustomerQ",false);
    }

    @RabbitListener(queues = "CustomerQ")
    public void proccesMessage(String email){
        System.out.println("Send to : "+email);
        mailer.sendMail(email);
    }

}
