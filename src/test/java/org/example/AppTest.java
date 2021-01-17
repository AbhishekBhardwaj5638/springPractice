package org.example;

import static org.junit.Assert.assertTrue;

import org.example.consumer.BroadcastConsumer;
import org.example.domain.MyXMlMessage;
import org.example.producer.BroadcastProducer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
   // /**
    // * Rigorous Test :-)
   //  */
    //@Test
    //public void shouldAnswerWithTrue()
    //{
     //   assertTrue( true );
    //}

    private BroadcastProducer broadcastProducer;
    private BroadcastConsumer broadcastConsumer;



    @Before
    public void init(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        this.broadcastProducer = applicationContext.getBean(BroadcastProducer.class);
        this.broadcastConsumer = applicationContext.getBean(BroadcastConsumer.class);
    }

    @Test
    public void testMessagePublisherAndConsumer(){
        MyXMlMessage myXMlMessage = MyXMlMessage.builder().offerId(1000L).description("PS5 deal").build();
        broadcastProducer.sendOffer(myXMlMessage);
        MyXMlMessage myXMlMessage1 = broadcastConsumer.receiveMyXmlMessage();
        Assert.assertEquals(myXMlMessage.getOfferId(),myXMlMessage1.getOfferId());
        Assert.assertEquals(myXMlMessage.getOfferId(),myXMlMessage1.getDescription());
    }
}
