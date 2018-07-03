package com.example.test_source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableBinding(Source.class)
public class OutboundController
{
    private final MessageChannel output;

    @Autowired
    public OutboundController(@Qualifier("output") final MessageChannel output)
    {
        this.output = output;
    }

    @RequestMapping(path = "/output", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String send()
    {
        final Model model = new Model();

        model.message = "Test";

        final Message<Model> message = MessageBuilder
            .withPayload(model)
            .build();

        this.output.send(message);

        return "success?";
    }
}
