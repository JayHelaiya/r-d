package com.jay.kafka;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

@SuppressWarnings("rawtypes")
public class StringProducerExample {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {

		 	Map<String, Object> props = new HashMap<String, Object>();
		    // list of host:port pairs used for establishing the initial connections to the Kakfa cluster
		    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092,localhost:9093,localhost:9094");
		    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);

        //create producer
        Producer<Integer, String> producer = new KafkaProducer<Integer, String>(props);
        String kafkaTopic="employees";
        
        ArrayList<String> list=new ArrayList<String>();
	  	list.add("jayesh");
	  	list.add("avnish");
	  	list.add("vala");
	  	for (String name : list) {
			ProducerRecord producerRecord = new ProducerRecord(kafkaTopic, 0,"Java-dev",name);
	            producer.send(producerRecord);
		}
	  	ArrayList<String> list2=new ArrayList<String>();
	  	list2.add("jitu");
	  	list2.add("nenchi");
	  	list2.add("kumar");
	  	for (String name : list2) {
	         ProducerRecord producerRecord = new ProducerRecord(kafkaTopic, 1,"android-dev",name);
	            producer.send(producerRecord);
		}

		ArrayList<String> list3=new ArrayList<String>();
	  	list2.add("anu");
	  	list2.add("mira");
	  	list2.add("ram");
	  	for (String name : list3) {
	         ProducerRecord producerRecord = new ProducerRecord(kafkaTopic,2,"php-dev",name);
	            producer.send(producerRecord);
		}
	  	
        //close producer
        producer.close();
    }


}
