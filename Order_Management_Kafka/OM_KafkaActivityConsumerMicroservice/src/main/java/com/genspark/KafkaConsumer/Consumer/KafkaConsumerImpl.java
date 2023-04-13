package com.genspark.KafkaConsumer.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class KafkaConsumerImpl implements KafkaConsumerInt{
	String output;
	File file;
	FileWriter out;

	public KafkaConsumerImpl() throws IOException {
		output="Order_Activity_log.txt";
		file=new File(output);
		out=new FileWriter(file) ;
	}

	@KafkaListener(topics = "orderActivityTopic", groupId = "Group1")
	public void listen(String orderActivity)
	{

		System.out.println("Received '" + orderActivity +"' from the orderActivityTopic." );
		try {
			out.append(orderActivity);
			out.append("\n");
			out.flush();
			System.out.println("writing in a Order_Activity_log file!!!");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {

		}
	}
}
