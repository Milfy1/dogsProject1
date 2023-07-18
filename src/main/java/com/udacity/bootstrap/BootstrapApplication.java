package com.udacity.bootstrap;
//zeadoo
//Mohammed-Aldrees
//Tareq-Assiri
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library APIS" , version = "1.0", description = "Library Management Apis."))
public class BootstrapApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootstrapApplication.class, args);
		KafkaTemplate<String,AirTag> kafkaTemplate = ctx.getBean(KafkaTemplate.class);
		kafkaTemplate.send("Dog","new record",
				AirTag.newBuilder().setBrand("gucci").
						setColor("red")
						.setId(1).build());
//		ctx.getBean(KafkaTemplate.class).send("MS.confluent", "not working");
	}
}

//@RequiredArgsConstructor
//class Producer{
//	private final KafkaTemplate<Integer,String> template;
//
//	Faker faker;
//	@EventListener(ApplicationStartedEvent.class)
//	public void generate(){
//  faker = Faker.instance();
//		final Flux<Long> interval = Flux.interval(Duration.ofMillis(1_000));
//		final Flux<String> quotes = Flux.fromStream(Stream.generate(() -> faker.hobbit().quote()));
//		Flux.zip(interval,quotes).map( it -> template.send("spring-kafka", faker.random().nextInt(42), it.getT2())).blockLast();
//	}
//}


