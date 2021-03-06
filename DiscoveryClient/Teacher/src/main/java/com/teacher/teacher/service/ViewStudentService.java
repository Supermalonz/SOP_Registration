package com.teacher.teacher.service;

import com.teacher.teacher.model.Student;
import com.teacher.teacher.model.array.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ViewStudentService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public Student getStudent(int id){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/student/%d" ,instances.get(0).getUri().toString(), id);
        ResponseEntity< Student > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, Student.class, id);
        return restExchange.getBody();
    }
    public StudentList getAllStudent() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("servicecrud");
        String serviceUri = String.format("%s/student" ,instances.get(0).getUri().toString());
        ResponseEntity< StudentList > restExchange = restTemplate.exchange( serviceUri, HttpMethod.GET, null, StudentList.class);
        return restExchange.getBody();
    }
}
