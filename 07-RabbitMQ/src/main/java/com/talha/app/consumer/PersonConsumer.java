package com.talha.app.consumer;

import com.talha.app.Pojo.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PersonConsumer {
    @RabbitListener(queues = "talha-queue")
    public void handleMessage(Person person) throws Exception
    {
        System.out.println("message is recieved");
        System.out.println(person);
    }
}
