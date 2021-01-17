package org.example.producer;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.MyXMlMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.print.attribute.standard.Destination;

@Component
@Slf4j
public class BroadcastProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("memberOffersDestination")
    private Destination destination;

    public void sendOffer(final MyXMlMessage message){
        if (log.isDebugEnabled()){
            log.debug("sendOffer {}",message);
        }
        //replace the MessageCreator with lambda expression

        jmsTemplate.send(String.valueOf(destination), new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("description",message.getDescription());
                return mapMessage;
            }
        });

    }
}
