package com.example.knowledge_graph.dto;

import lombok.Data;


//todo: 告诉前端把字段class改为了label
@Data
public class BasicInfoWithName {
    String label;
    String name;
    String size;
}
