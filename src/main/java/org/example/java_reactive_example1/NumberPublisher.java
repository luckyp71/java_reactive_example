package org.example.java_reactive_example1;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

public class NumberPublisher implements Publisher<Integer>{

	private final SubmissionPublisher<Integer> submissionPublisher = new SubmissionPublisher<>();
	
	@Override
	public void subscribe(Subscriber<? super Integer> subscriber) {
		submissionPublisher.subscribe(subscriber);	//Sending data
		
	}
	
	public void start() {
//		IntStream.iterate(1, i -> i+1).forEach(i -> {
//			submissionPublisher.submit(i);
//			sleep();
//		});
		IntStream.range(1, 100).forEach(i -> {
			submissionPublisher.submit(i);
			sleep();
		});
	}
	
	private void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println("Submission finished");
		}
	}

}
