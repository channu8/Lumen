package com.example.demo;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.SpringApplication;
import reactor.core.*;
import reactor.core.publisher.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveSpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ReactiveSpringApplication.class, args);
		
		Flux<String> namePublisher = Flux.just("Channu","Sam","Guru");
		
		//namePublisher.subscribe(System.out::println);
		
		namePublisher.subscribe(new Subscriber() {

			@Override
			public void onSubscribe(Subscription s) {
				s.request(3);
            System.out.println(s);
				
			}

			@Override
			public void onNext(Object t) {
				   System.out.println("ON Next "+t.toString());
				
			}

			@Override
			public void onError(Throwable t) {
				   System.out.println(t.getMessage());
				
			}

			@Override
			public void onComplete() {
				System.out.println("Completed");
				
			}
		});
		
		ctx.close();
 	}

}
