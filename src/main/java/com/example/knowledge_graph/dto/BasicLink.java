package com.example.knowledge_graph.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicLink {
    String relation;
    String source;
    String target;
    Integer value;
}
