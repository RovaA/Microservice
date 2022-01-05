package com.example.demopayment;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageBrokerConfiguration {

    @Bean
    public Queue myQueue() {
        return new Queue("AMPQ", false);
    }
}
