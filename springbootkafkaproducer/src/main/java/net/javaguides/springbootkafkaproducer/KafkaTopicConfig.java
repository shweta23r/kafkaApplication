package net.javaguides.springbootkafkaproducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    //public
    public NewTopic topic(){
        return TopicBuilder.name("wikimedia_recentchange")
                .build();
    }
}
