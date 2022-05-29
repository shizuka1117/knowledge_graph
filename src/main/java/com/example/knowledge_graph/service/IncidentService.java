package com.example.knowledge_graph.service;

import com.example.knowledge_graph.entity.Incident;
import org.springframework.stereotype.Service;


public interface IncidentService {
    Incident findIncidentById(String id);
}
