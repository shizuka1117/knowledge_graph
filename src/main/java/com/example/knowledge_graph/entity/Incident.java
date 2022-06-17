package com.example.knowledge_graph.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.beans.factory.annotation.Value;

@NodeEntity
@Data
@NoArgsConstructor
public class Incident {
    @Id
    @Property("number")
    String id;
    String urgency;
    String impact;
    String short_description;
    String description;
    String category;
    String subcategory;
    String priority;
}
