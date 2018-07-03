package com.example.test_source;

import com.example.test_source.model.*;
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
        final EmailOutbound emailOutbound = this.createEmail();
        final Message<EmailOutbound> message = MessageBuilder
            .withPayload(emailOutbound)
            .build();

        this.output.send(message);

        return "success?";
    }

    private EmailOutbound createEmail()
    {
        final Email marryjane = Email.newBuilder("marry.jane@example.com")
            .withName("Marry Jane")
            .build();

        final Email johndoe1 = Email.newBuilder("john.doe1@example.com")
            .withName("Adriano Winck")
            .build();

        final Email johndoe2 = Email.newBuilder("john.doe2@example.com")
            .withName("Mauren Berti")
            .build();

        final Content content = Content.newBuilder()
            .withType("text/plain")
            .withBody("Testing this thing!")
            .build();

        final Mail mail = Mail.newBuilder(marryjane)
            .withReplyTo(marryjane)
            .withSubject("Testing email delivery")
            .addDestination(Destination.newBuilder()
                .addTo(johndoe1)
                .addTo(johndoe2)
                .build()
            )
            .withContent(content)
            .build();

        return EmailOutbound.newBuilder("example")
            .addMail(mail)
            .build();
    }
}
