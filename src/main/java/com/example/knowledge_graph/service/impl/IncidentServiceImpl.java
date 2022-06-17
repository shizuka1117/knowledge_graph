package com.example.knowledge_graph.service.impl;

import com.example.knowledge_graph.dto.BasicInfo;
import com.example.knowledge_graph.dto.BasicLink;
import com.example.knowledge_graph.dto.BasicResultSet;
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
    public BasicResultSet findAll() {
        List<BasicInfo> basicInfoList = new ArrayList<>();
        List<BasicLink> basicLinkList = new ArrayList<>();

        String cql1 = "match (i:Incident)-[r]-(t) where labels(t)[0]<>\"Problem\" return i.number, type(r), t.name, labels(t)[0], labels(i)[0]";
        String cql2 = "match (p:Problem)-[r]-(t) where labels(t)[0]<>\"Incident\" return p.number, type(r), t.name, labels(t)[0], labels(p)[0]";
        String cql3 = "match (i:Incident)-[r]-(p:Problem) return i.number, type(r), p.number, labels(p)[0], labels(i)[0]";

        List<Record> resultList = new ArrayList<>();
        Result result1 = session.run(cql1);
        Result result2 = session.run(cql2);
        Result result3 = session.run(cql3);
        resultList.addAll(result1.list());
        resultList.addAll(result2.list());
        resultList.addAll(result3.list());

        for (Record record: resultList){
            BasicLink link = new BasicLink(record.get(1).asString(), record.get(0).asString(), record.get(2).asString(), 1);
            basicLinkList.add(link);
            BasicInfo info1 = new BasicInfo(record.get(4).asString(), record.get(0).asString(), 3);
            BasicInfo info2 = new BasicInfo(record.get(3).asString(), record.get(2).asString(), 3);
            if (!basicInfoList.contains(info1))
                basicInfoList.add(info1);
            if (!basicInfoList.contains(info2)) {
                basicInfoList.add(info2);
            }
        }

        BasicResultSet resultSet = new BasicResultSet(basicInfoList, basicLinkList);
        return resultSet;
    }
}
