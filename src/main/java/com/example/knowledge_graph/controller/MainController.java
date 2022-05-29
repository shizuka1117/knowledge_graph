package com.example.knowledge_graph.controller;


import com.example.knowledge_graph.entity.Incident;
import com.example.knowledge_graph.entity.Problem;
import com.example.knowledge_graph.service.IncidentService;
import com.example.knowledge_graph.service.ProblemService;
import com.example.knowledge_graph.service.impl.ProblemServiceImpl;
import com.example.knowledge_graph.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("main")
public class MainController {
    @Resource
    IncidentService incidentService;
    @Resource
    ProblemService problemService;

    /**
     * 获取知识图谱信息
     * @return
     */
    @GetMapping("/all")
    public Result getAllAssignments(){
        return Result.ok();
    }

    /**
     * 查询单个Incident节点信息
     */
    @GetMapping("/incident/{incidentId}")
    public Result getIncident(@PathVariable("incidentId") String id){
        return Result.ok(incidentService.findIncidentById(id));
    }

    /**
     * 查询单个Problem节点信息
     */
    @GetMapping("/problem/{problemId}")
    public Result getProblem(@PathVariable("problemId") String Id){
        return Result.ok();
    }

    /**
     * 删除单个Incident节点信息（包括关联）
     * @param Id Incident id
     * @return
     */
    @DeleteMapping("/incident/{incidentId}")
    public Result deleteIncident(@PathVariable("incidentId") String Id){
        return Result.ok();
    }

    /**
     * 删除单个Problem节点信息（包括关联）
     * @param Id Problem id
     * @return
     */
    @DeleteMapping("/problem/{problemId}")
    public Result deleteProblem(@PathVariable("problemId") String Id){
        return Result.ok();
    }
}
