package com.example.knowledge_graph.service.impl;

import com.example.knowledge_graph.entity.Incident;
import com.example.knowledge_graph.repository.IncidentRepository;
import com.example.knowledge_graph.service.IncidentService;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IncidentServiceImpl implements IncidentService {
    @Resource
    Session session;
    @Resource
    IncidentRepository incidentRepository;

    @Override
    public Incident findById(String id) {
        return incidentRepository.findById(id).orElse(null);
    }
}
