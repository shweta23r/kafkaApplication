package net.javaguides.springboot.consumer;


import net.javaguides.springboot.consumer.entity.WikimediaData;
import net.javaguides.springboot.consumer.repository.WikiMediaChangesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    @Autowired
    private WikiMediaChangesRepository wikiMediaChangesRepository;

    private static final Logger logger= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @KafkaListener(topics="wikimedia_recentchange",groupId = "myGroup")
    public void consumer(String message){
        logger.info(String.format("Message recieved -> %s",message));
        WikimediaData wikimediaData= new WikimediaData();
        wikimediaData.setWikiEventData(message.substring(0,100));
        wikiMediaChangesRepository.save(wikimediaData);


    }
}
