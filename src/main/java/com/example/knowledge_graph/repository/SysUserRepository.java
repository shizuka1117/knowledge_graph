package com.example.knowledge_graph.repository;

import com.example.knowledge_graph.entity.SysUser;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRepository extends Neo4jRepository<SysUser, String> {
    @Query("MATCH (u:Sys_User)-[]-(p:Problem) where p.id=$id RETURN u")
    List<SysUser> findAllByRelatedProblem(@Param("id") String id);

    @Query("MATCH (u:Sys_User)-[]-(i:Incident) where i.id=$id RETURN u")
    List<SysUser> findAllByRelatedIncident(@Param("id") String id);
}
