package com.example.knowledge_graph.service.impl;

import com.example.knowledge_graph.entity.Incident;
import com.example.knowledge_graph.repository.IncidentRepository;
import com.example.knowledge_graph.repository.ProblemRepository;
import com.example.knowledge_graph.service.IncidentService;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IncidentServiceImpl implements IncidentService {
    @Resource
    Session session;
    @Resource
    IncidentRepository incidentRepository;
    @Resource
    ProblemRepository problemRepository;

    @Override
    public Incident findById(String id) {
        return incidentRepository.findById(id).orElse(null);
    }

    /**
     * todo: 确认一下关系都建好了，写完基本信息获取
     * 关系：Item和Problem/Incident，User和Problem/Incident，SubCategory和Problem/Incident，Category和SubCategory，User和Group
     * @return
     */
    @Override
    public List<Object> findAll() {
        List<String> incidentIdList = incidentRepository.getAllId();
        List<String> problemIdList = problemRepository.getAllId();

        return null;
    }
}
