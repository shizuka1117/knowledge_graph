package com.example.knowledge_graph.service;

import com.example.knowledge_graph.entity.Problem;
import org.springframework.stereotype.Service;

public interface ProblemService {
    Problem findById(String id);

    String findRelatedUser();
}
