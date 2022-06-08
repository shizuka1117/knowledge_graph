package com.example.knowledge_graph.service;

import com.example.knowledge_graph.entity.SysUser;

import java.util.List;

public interface SysUserService {
    SysUser findById(String id);

    List<SysUser> findUserByRelatedProblem(String id);

    List<SysUser> findUserByRelatedIncident(String related_incident_id);
}
