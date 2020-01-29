package com.jay.kafka;

public class KafkaBrokerInfo {

	 public final String brokerHost;
	    public final int brokerPort;

	    public KafkaBrokerInfo(String brokerHost, int brokerPort) {
	        this.brokerHost = brokerHost;
	        this.brokerPort = brokerPort;
	    }

	    public KafkaBrokerInfo(String brokerHost) {
	        this(brokerHost, 9092);
	    }
}
