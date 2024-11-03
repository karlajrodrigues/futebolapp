package com.futebol.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.futebol.webapp.model.Campeonato;

@Service
public class CampeonatoService {

    @Value("${api.url}")
    private String  urlApi;

    @Value("${api.token}")
    private String token;

    private RestTemplate restTemplate;
    
    /*public CampeonatoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    public List<Campeonato> listarCampeonatos() {
        String url =  urlApi + "/3.1/campeonatos";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Campeonato>> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Campeonato>>() {});
        return response.getBody();

    }
    

}
