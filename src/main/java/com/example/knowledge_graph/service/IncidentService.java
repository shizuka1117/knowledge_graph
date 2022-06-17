package com.example.knowledge_graph.service;

import com.example.knowledge_graph.entity.Incident;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IncidentService {
    Incident findById(String id);

    List<Object> findAll();
}
