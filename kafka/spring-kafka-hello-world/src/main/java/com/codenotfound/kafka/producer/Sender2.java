package com.codenotfound.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender2 {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(Sender2.class);

  @SuppressWarnings("rawtypes")
  @Autowired
  private KafkaTemplate kafkaTemplate;

  final String kafkaTopic="msg";

  @SuppressWarnings("unchecked")
  public void send() {
      for(int i = 0; i < 100; i++){
         LOGGER.info(i+"");
         kafkaTemplate.send(kafkaTopic, Integer.toString(i),  "test message 2- - " + i );
     }
  }
}
