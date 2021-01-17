package org.example.consumer;


import lombok.extern.slf4j.Slf4j;
import org.example.domain.MyXMlMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;

@Component
@Slf4j
public class BroadcastConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;
    public MyXMlMessage receiveMyXmlMessage(){
        MapMessage mapMessage = (MapMessage) jmsTemplate.receive();
        MyXMlMessage myXMlMessage;
        try{
            myXMlMessage = MyXMlMessage.builder()
                    .offerId(mapMessage.getLong("offerId"))
                    .description(mapMessage.getString("description"))
                    .build();
            if (log.isDebugEnabled()){
                log.debug("receiveMyXmlMessage {}",myXMlMessage);

            }
        }catch (JMSException e){
            throw JmsUtils.convertJmsAccessException(e);
        }

        return myXMlMessage;
    }

}
