package org.example.java_reactive_example1;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public abstract class SubscriberBase<T> implements Subscriber<T> {

	protected Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		if (this.subscription == null) {
			this.subscription = subscription;
			this.subscription.request(5);
		} else {
			//don't receive another publisher
			//only one publisher talks to this subscriber
			subscription.cancel(); 
		}
		
	}
	
}
