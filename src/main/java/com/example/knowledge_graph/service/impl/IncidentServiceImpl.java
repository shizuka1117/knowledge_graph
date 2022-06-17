package com.example.knowledge_graph.service.impl;

import com.example.knowledge_graph.dto.BasicInfoWithId;
import com.example.knowledge_graph.dto.BasicInfoWithName;
import com.example.knowledge_graph.dto.BasicLink;
import com.example.knowledge_graph.entity.Incident;
import com.example.knowledge_graph.repository.IncidentRepository;
import com.example.knowledge_graph.repository.ProblemRepository;
import com.example.knowledge_graph.service.IncidentService;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List findAll() {
        List<String> incidentIdList = incidentRepository.getAllId();
        List<String> problemIdList = problemRepository.getAllId();
        String cql1 = "match (i:Incident)-[r]-(t) return i.number, type(r), t.name, labels(t)[0]";
        String cql2 = "match (p:Problem)-[r]-(t) return p.number, type(r), t.name, labels(t)[0]";
        Result result1 = session.run(cql1);
        Result result2 = session.run(cql2);
        List<Record> list = result1.list();
        list.addAll(result2.list());
        List<BasicInfoWithId> basicInfoWithIdList = new ArrayList<>();
        for(String id: incidentIdList){
            basicInfoWithIdList.add(new BasicInfoWithId("incident", id, 5));
        }
        for(String id: problemIdList){
            basicInfoWithIdList.add(new BasicInfoWithId("problem", id, 5));
        }
        for(Record record:list){
            BasicLink link = new BasicLink(record.get(1).asString(), record.get(0).asString(), record.get(2).asString(), 1);
            basicInfoWithIdList.add(new BasicInfoWithId(record.get(3).asString(), record.get(2).asString(), 3));
        }
        return basicInfoWithIdList;
    }
}
