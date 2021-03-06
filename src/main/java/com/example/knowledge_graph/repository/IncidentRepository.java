package com.example.knowledge_graph.repository;

import com.example.knowledge_graph.entity.Incident;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends Neo4jRepository<Incident, String> {
    @Query("MATCH (i:Incident) where i.number=$id RETURN i ")
    Incident getIncidentByNumber(@Param("id") String id);

    @Query("MATCH (i:Incident) return i.number")
    List<String> getAllId();
}
