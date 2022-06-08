package com.example.knowledge_graph.service.impl;

import com.example.knowledge_graph.entity.SysUser;
import com.example.knowledge_graph.repository.ProblemRepository;
import com.example.knowledge_graph.repository.SysUserRepository;
import com.example.knowledge_graph.service.SysUserService;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    Session session;
    @Resource
    SysUserRepository sysUserRepository;

    @Override
    public SysUser findById(String id) {
        return sysUserRepository.findById(id).orElse(null);
    }

    @Override
    public List<SysUser> findUserByRelatedProblem(String id) {
        return sysUserRepository.findAllByRelatedProblem(id);
    }

    @Override
    public List<SysUser> findUserByRelatedIncident(String id) {
        return sysUserRepository.findAllByRelatedIncident(id);
    }
}
