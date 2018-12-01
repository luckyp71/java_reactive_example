package org.example.java_reactive_example1;

public class CoreApp {

	public static void main (String... args) {
		NumberPublisher numberPublisher = new NumberPublisher();
		
		MappingProcessor<Integer, String> mappingProcessor = new MappingProcessor<Integer, String>(i -> "i = "+i);
		
//		PrintSubscriber<Integer> printingSubscriber = new PrintSubscriber<>();

		PrintSubscriber<String> printingSubscriber = new PrintSubscriber<>();

		
		//Connect publisher to subscriber
		//There are two approaches below, connect the publisher to subscriber directly or by using 
		//an intermediary called processor
//		numberPublisher.subscribe(printingSubscriber);
		numberPublisher.subscribe(mappingProcessor);
		mappingProcessor.subscribe(printingSubscriber);
		
		numberPublisher.start();
	}
	
}
