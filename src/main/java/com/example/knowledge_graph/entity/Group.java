package com.example.knowledge_graph.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

//todo: 把字段为空的都包装一下
@NodeEntity
@Data
@NoArgsConstructor
public class Group {
    @Id
    String name;
    String description;
    String email;
}
