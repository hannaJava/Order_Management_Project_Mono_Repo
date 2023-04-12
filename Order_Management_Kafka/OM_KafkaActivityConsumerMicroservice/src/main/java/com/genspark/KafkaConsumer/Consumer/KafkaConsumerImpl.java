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
		output="HR_Activity_log.txt";
		file=new File(output);
		out=new FileWriter(file) ;
	}

	@KafkaListener(topics = "HrEventTopic", groupId = "Group1")
	public void listen(String hrEvent)
	{

		System.out.println("Received '" + hrEvent +"' from the HrEventTopic." );
		try {
			out.append(hrEvent);
			out.append("\n");
			out.flush();
			System.out.println("writing in a HR_Activity_log file!!!");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {

		}
	}
}
