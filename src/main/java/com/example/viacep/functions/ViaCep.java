package com.example.viacep.functions;

import com.example.viacep.model.ViaCepRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

public class ViaCep implements Function<ViaCepRequest, String> {

    @Override
    public String apply(ViaCepRequest viaCep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/";

        ResponseEntity<String> response
                = restTemplate.getForEntity(url + viaCep.getCep() +"/json/", String.class);
        return response.getBody();
    }
}