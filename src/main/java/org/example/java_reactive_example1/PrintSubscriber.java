package org.example.java_reactive_example1;

public class PrintSubscriber<T> extends SubscriberBase<T> {

	
	//Implementing three other call backs of Subscriber interface
	@Override
	public void onNext(T item) {
		System.out.println("item: "+item);
		subscription.request(5);
		
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("Error");
		
	}

	@Override
	public void onComplete() {
		System.out.println("onComplete");
	}

	
	
}
