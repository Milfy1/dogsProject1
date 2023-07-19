package com.udacity.bootstrap;
//zeadoo
//Mohammed-Aldrees
//Tareq-Assiri
import com.udacity.bootstrap.AvroRecords.AirTagRecord;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library APIS" , version = "1.0", description = "Library Management Apis."))
public class BootstrapApplication {

	public static void main(String[] args) {
	 SpringApplication.run(BootstrapApplication.class, args);
//		KafkaTemplate<String, AirTagRecord> kafkaTemplate = ctx.getBean(KafkaTemplate.class);
//		kafkaTemplate.send("AirTag","new record",
//				AirTagRecord.newBuilder().setBrand("gucci").
//						setColor("red")
//						.setId(1).build());
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


