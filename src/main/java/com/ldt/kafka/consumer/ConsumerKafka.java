package com.ldt.kafka.consumer;

import com.ldt.kafka.config.ConsumerKafkaConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
@Getter
@Setter
@EnableAsync
public class ConsumerKafka {

	@Autowired
	ConsumerKafkaConfiguration config;

	private KafkaConsumer consumer;
	private boolean isActive;
	@Value("${kafka.topic}")
	private String topic;
	@Async
	public void start() {
		
		Map properties=config.consumerConfigs();
		if(consumer == null)
			consumer=new KafkaConsumer<String, String>(properties);


		ArrayList<String> topics=new ArrayList<String>();
		topics.add(topic);
		
		consumer.subscribe(topics);
		
		try {
			isActive = true;
			while(true || isActive ){

				ConsumerRecords<String, String> records = consumer.poll(1000);
				
				for(ConsumerRecord<String, String> record : records){
					
					System.out.println("Record read in KafkaConsumerApp : " +  record.toString());
					
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Inside exception loop : ");
			e.printStackTrace();
		}finally{
			consumer.close();
			isActive = false;
		}
	}

	public boolean isStart() {
		return isActive;
	}
	public void stop(){
		isActive = false;
	}

}
