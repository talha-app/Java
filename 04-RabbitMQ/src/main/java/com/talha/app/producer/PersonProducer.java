package com.talha.app.producer;

import com.talha.app.Pojo.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class PersonProducer {
    @Value("${rabbit.routing.name}")
    private String routingName;

    @Value("${rabbit.exchange.name}")
    private String exchangeName;

    private final static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final Random random;
    private final RabbitTemplate rabbitTemplate;

    public PersonProducer(RabbitTemplate rabbitTemplate)
    {
        this.rabbitTemplate = rabbitTemplate;
        this.random = new Random();
    }

    @Scheduled(fixedDelay = 10000, initialDelay = 2500)
    public void createPersonAndSendQueue()
    {
        var person = createRandomPerson();
        sendToQueue(person);
    }

    public void sendToQueue(Person person)
    {
        System.out.println("sending personId: " + person.getId());
        rabbitTemplate.convertAndSend(exchangeName, routingName, person);

    }

    private Person createRandomPerson()
    {
        var id = random.nextInt(50);
        StringBuilder name = new StringBuilder();
        StringBuilder surname = new StringBuilder();
        var isVip = random.nextBoolean();

        IntStream.range(0, random.nextInt(10) + 1).forEach(i -> {
            name.append(chars.charAt(random.nextInt(chars.length())));
            surname.append(chars.charAt(random.nextInt(chars.length())));
        });

        return new Person(id, name.toString(), surname.toString(), isVip);
    }


}
