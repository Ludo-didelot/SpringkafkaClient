package com.ldt.controller;

import com.ldt.kafka.consumer.ConsumerKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringkafkaController {


	@Autowired
	ConsumerKafka consumer;

	@RequestMapping(value="/admin/startconsumer", method=RequestMethod.GET)
	public ResponseEntity<String> startConsumer() {
		consumer.start();
		return new ResponseEntity<String>("Consumer status :"+consumer.isStart(), HttpStatus.OK);
	}
	@RequestMapping(value="/admin/stopconsumer", method=RequestMethod.GET)
	public ResponseEntity<String> stopConsumer() {
		consumer.stop();
		return new ResponseEntity<String>("Consumer status :"+consumer.isStart(), HttpStatus.OK);
	}
	@RequestMapping(value="/admin/status", method=RequestMethod.GET)
	public ResponseEntity<String> status() {
		return new ResponseEntity<String>("Consumer status :"+consumer.isStart(), HttpStatus.OK);
	}
}
