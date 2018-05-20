package com.barclays.dispatcher.actors;

import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

	@KafkaListener(id = "foo", topics = "myTopic", clientIdPrefix = "myClientId")
	public void listen(String data) {

	}

}
