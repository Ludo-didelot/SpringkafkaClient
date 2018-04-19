package com.ldt.controller;

import com.ldt.kafka.consumer.ConsumerKafka;
import com.ldt.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SpringkafkaController {


	@Autowired
	ConsumerKafka consumer;
	@Autowired
	HumanRepository repo;

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
//	@RequestMapping(value="/searchFriends", method=RequestMethod.GET)
//	public ResponseEntity<Collection> friends() {
//		return new ResponseEntity<Collection>(repo.graph(10,"Han Solo"));
//	}
}
