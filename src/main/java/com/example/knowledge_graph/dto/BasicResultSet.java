package com.example.knowledge_graph.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BasicResultSet {
    List<BasicInfo> nodes;
    List<BasicLink> links;
}
