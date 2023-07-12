package com.udacity.bootstrap;
//zeadoo
//Mohammed-Aldrees
//Tareq-Assiri
import com.github.javafaker.Faker;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library APIS" , version = "1.0", description = "Library Management Apis."))
public class BootstrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootstrapApplication.class, args);
	}

}

@RequiredArgsConstructor
class Producer{
	private final KafkaTemplate<Integer,String> template;

	Faker faker;
	@EventListener(ApplicationStartedEvent.class)
	public void generate(){
  faker = Faker.instance();
		final Flux<Long> interval = Flux.interval(Duration.ofMillis(1_000));
		final Flux<String> quotes = Flux.fromStream(Stream.generate(() -> faker.hobbit().quote()));
		Flux.zip(interval,quotes).map( it -> template.send("spring-kafka", faker.random().nextInt(42), it.getT2())).blockLast();
	}
}


