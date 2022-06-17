package com.example.knowledge_graph.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicInfoWithId {
    String label;
    String id;
    Integer size;
}
