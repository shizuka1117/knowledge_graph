package com.example.knowledge_graph.repository;

import com.example.knowledge_graph.entity.Item;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends Neo4jRepository<Item, String> {
}
