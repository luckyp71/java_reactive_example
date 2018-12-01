package org.example.java_reactive_example1;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

public abstract class ProcessorBase<In, Out> extends SubscriberBase<In> implements 
	Publisher<Out> {
	
	private final SubmissionPublisher<Out> submissionPublisher = new SubmissionPublisher<>();

	@Override
	public void subscribe(Subscriber<? super Out> subscriber) {
		submissionPublisher.subscribe(subscriber);
		
	}
	
	@Override
	public void onError(Throwable throwable) {
		submissionPublisher.closeExceptionally(throwable);
	}

	@Override
	public void onComplete() {
		submissionPublisher.close();
	}	
	
	protected void submit(Out item) {
		submissionPublisher.submit(item);
	}
}
