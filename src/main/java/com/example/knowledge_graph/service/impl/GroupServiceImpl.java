package com.example.knowledge_graph.service.impl;

import com.example.knowledge_graph.entity.Group;
import com.example.knowledge_graph.repository.GroupRepository;
import com.example.knowledge_graph.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GroupServiceImpl implements GroupService {

    @Resource
    GroupRepository groupRepository;

    @Override
    public Group findById(String id) {
        return groupRepository.findById(id).orElse(null);
    }
}
