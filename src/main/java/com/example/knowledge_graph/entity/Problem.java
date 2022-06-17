package com.example.knowledge_graph.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
@Data
@NoArgsConstructor
public class Problem {
    @Id
    @Property("number")
    String id;
    String urgency;
    String impact;
    String statement;
    String description;
    String category;
    String subcategory;
    String priority;
}
