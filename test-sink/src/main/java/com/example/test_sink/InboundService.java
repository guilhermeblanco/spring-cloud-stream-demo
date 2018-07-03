package com.example.test_sink;

import com.example.test_sink.model.EmailOutbound;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class InboundService
{
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(final EmailOutbound emailOutbound)
    {
        System.out.println(emailOutbound.toString());
    }
}
