package net.javaguides.springbootkafkaproducer;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducerService {

    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaChangesProducerService.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    // constructor--?WikimediaChangesProducerService(Kafka)

    public void sendMessage() throws InterruptedException {
       // kafkaTemplate.send("wikimediachanges_topic",message);

        String topic="wikimedia_recentchange";
        EventHandler eventHandler=new WikimediaEventHandler(kafkaTemplate,topic);
        String url="https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource= builder.build();
        eventSource.start();;
        TimeUnit.MINUTES.sleep(10);
    }
}
