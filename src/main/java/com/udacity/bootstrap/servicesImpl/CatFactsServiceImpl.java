package com.udacity.bootstrap.servicesImpl;

import com.udacity.bootstrap.KafkaProducer.KafkaProducer;
import com.udacity.bootstrap.services.CatFactsService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CatFactsServiceImpl implements CatFactsService {

    private final KafkaProducer<String> kafkaProducer;
    private final RestTemplate restTemplate;


    public CatFactsServiceImpl(KafkaProducer<String> kafkaProducer, RestTemplate restTemplate) {
        this.kafkaProducer = kafkaProducer;
        this.restTemplate = restTemplate;
    }

    @Override
    public String GetCatFact() {
        String url = "https://catfact.ninja/fact";
        String result = restTemplate.getForObject(url, String.class);
        result = result.split("\"")[3];
        kafkaProducer.sendmessage("Cat_Facts",result);
        return result;
    }
}
