package com.example.knowledge_graph.service.impl;

import com.example.knowledge_graph.entity.Problem;
import com.example.knowledge_graph.repository.ProblemRepository;
import com.example.knowledge_graph.service.ProblemService;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Resource
    Session session;
    @Resource
    ProblemRepository problemRepository;

    @Override
    public Problem findById(String id) {
        return problemRepository.findById(id).orElse(null);
    }

    @Override
    public String findRelatedUser() {
        return null;
    }
}
