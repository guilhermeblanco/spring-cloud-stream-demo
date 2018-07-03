package com.example.test_source;

import com.example.test_source.model.EmailOutbound;
import com.example.test_source.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class Application
{
    public static void main(final String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

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
            final Mail mail = Mail.newBuilder("marry.jane@example.com")
                .withTo("john.doe@example.com")
                .withSubject("Testing email delivery")
                .withContent("Testing this thing!")
                .build();

            return EmailOutbound.newBuilder("example")
                .addMail(mail)
                .build();
        }
    }
}
