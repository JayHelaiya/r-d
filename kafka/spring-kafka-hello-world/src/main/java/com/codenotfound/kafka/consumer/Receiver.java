package com.codenotfound.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

@SuppressWarnings("unused")
private static final Logger LOGGER =LoggerFactory.getLogger(Receiver.class);



  @KafkaListener(topics = "msg")
  public void receive(@SuppressWarnings("rawtypes") ConsumerRecord record) {
      LOGGER.info(String.format("Topic - %s, Partition - %d,offset - %d Value: %s", "msg", record.partition(),record.offset(), record.value()));
  }
}
