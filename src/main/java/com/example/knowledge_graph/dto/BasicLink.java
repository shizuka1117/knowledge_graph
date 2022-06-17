package com.example.knowledge_graph.dto;

import com.example.knowledge_graph.entity.Incident;
import lombok.Data;

@Data
public class BasicLink {
    String relation;
    String source;
    String target;
    Integer value;
}
