package com.sopreg.student.service;

import com.sopreg.student.model.Score;
import com.sopreg.student.model.array.ScoreList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ViewScoreService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public Score getScoreByID(int id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/scores/%d" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Score > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Score.class, id);
        return restExchange.getBody();
    }

    public ScoreList getAllScore() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/scores" ,instances.get(0).getUri().toString());
        ResponseEntity< ScoreList > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, ScoreList.class);
        return restExchange.getBody();
    }
}
