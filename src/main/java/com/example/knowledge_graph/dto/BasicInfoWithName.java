package com.example.knowledge_graph.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


//todo: 告诉前端把字段class改为了label
@Data
@AllArgsConstructor
public class BasicInfoWithName {
    String label;
    String name;
    Integer size;
}
