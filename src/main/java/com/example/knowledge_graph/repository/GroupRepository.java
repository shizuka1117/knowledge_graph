package com.example.knowledge_graph.repository;

import com.example.knowledge_graph.entity.Group;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface GroupRepository extends Neo4jRepository<Group, String> {
}
