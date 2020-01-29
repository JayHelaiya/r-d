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
public class ProducerTest {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {

		 	Map<String, Object> props = new HashMap<String, Object>();
		    // list of host:port pairs used for establishing the initial connections to the Kakfa cluster
		    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092,localhost:9093,localhost:9094");
		    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);

        //create producer
        Producer<Integer, String> producer = new KafkaProducer<Integer, String>(props);
        String kafkaTopic="office-employees";
        
        ArrayList<String> list=new ArrayList<String>();
	  	list.add("jitu");
	  	list.add("kumar");
	  	list.add("nency");
	  	for (String name : list) {
			ProducerRecord producerRecord = new ProducerRecord(kafkaTopic, 0,"android-team",name);
	            producer.send(producerRecord);
		}
	  	ArrayList<String> list2=new ArrayList<String>();
	  	list2.add("bhavlo");
	  	list2.add("vala");
	  	list2.add("jay");
	  	for (String name : list2) {
	         ProducerRecord producerRecord = new ProducerRecord(kafkaTopic, 1,"java-team",name);
	            producer.send(producerRecord);
		}
	  	ArrayList<String> list3=new ArrayList<String>();
	  	list3.add("hiral");
	  	list3.add("mala");
	  	list3.add("rutu");
	  	for (String name : list3) {
	         ProducerRecord producerRecord = new ProducerRecord(kafkaTopic, 2,"QA-team",name);
	            producer.send(producerRecord);
		}

        //close producer
        producer.close();
    }


}
