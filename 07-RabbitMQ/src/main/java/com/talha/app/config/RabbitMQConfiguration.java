package com.talha.app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Value("${rabbit.queue.name}")
    private String queueName;

    @Value("${rabbit.routing.name}")
    private String routingName;

    @Value("${rabbit.exchange.name}")
    private String exchangeName;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQConfiguration(RabbitTemplate rabbitTemplate)
    {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Queue queue()
    {
        return new Queue(queueName, true);
    }

    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding(final Queue queue, final DirectExchange directExchange)
    {
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }
}
