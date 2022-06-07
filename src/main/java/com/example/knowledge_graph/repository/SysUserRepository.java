package com.example.knowledge_graph.repository;

import com.example.knowledge_graph.entity.Problem;
import com.example.knowledge_graph.entity.SysUser;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends Neo4jRepository<SysUser, String> {
}
