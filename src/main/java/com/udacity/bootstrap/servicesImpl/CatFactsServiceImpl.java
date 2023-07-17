package com.udacity.bootstrap.servicesImpl;

import com.udacity.bootstrap.KafkaProducer.KafkaProducer;
import com.udacity.bootstrap.services.CatFactsService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CatFactsServiceImpl implements CatFactsService {

    private final KafkaProducer<String> kafkaProducer;

    public CatFactsServiceImpl(KafkaProducer<String> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public String GetCatFact() {
        String url = "https://catfact.ninja/fact";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        kafkaProducer.sendmessage("Cat_Facts",result);
        return result;
    }
}
