package com.example.knowledge_graph.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
@Data
@NoArgsConstructor
public class Item {
    @Id
    String name;
    String asset;
    String category;
    String subcategory;
    String department;
}
