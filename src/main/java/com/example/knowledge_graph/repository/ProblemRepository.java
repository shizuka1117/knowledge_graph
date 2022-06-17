package com.example.knowledge_graph.repository;


import com.example.knowledge_graph.entity.Problem;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends Neo4jRepository<Problem, String> {
    @Query("MATCH (p:Problem) where p.id=$id RETURN p")
    Problem getProblemByNumber(@Param("id") String id);

    @Query("MATCH (p:Problem) return p.id")
    List<String> getAllId();
}
