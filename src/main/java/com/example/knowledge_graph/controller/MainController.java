package com.example.knowledge_graph.controller;


import com.example.knowledge_graph.entity.Group;
import com.example.knowledge_graph.entity.Item;
import com.example.knowledge_graph.entity.SysUser;
import com.example.knowledge_graph.service.*;
import com.example.knowledge_graph.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("graph")
public class MainController {
    @Resource
    IncidentService incidentService;
    @Resource
    ProblemService problemService;
    @Resource
    SysUserService sysUserService;
    @Resource
    ItemService itemService;
    @Resource
    GroupService groupService;

    /**
     * 测试用的，最后删掉
     * @return
     */
    @GetMapping("/test")
    public Result getTest(){
        return Result.ok();
    }

    /**
     * 获取知识图谱基本信息
     * @return
     */
    @GetMapping("/basic")
    public Result getAllAssignments(){
        return Result.ok(incidentService.findAll());
    }

    /**
     * 查询单个Incident节点信息
     */
    @GetMapping("/incident/{incidentId}")
    public Result getIncident(@PathVariable("incidentId") String id){
        return Result.ok(incidentService.findById(id));
    }

    /**
     * 查询单个Problem节点信息
     */
    @GetMapping("/problem/{problemId}")
    public Result getProblem(@PathVariable("problemId") String id){
        return Result.ok(problemService.findById(id));
    }

    /**
     * 查询单个系统用户节点信息
     * @param username
     * @return
     */
    @GetMapping("/user/{userName}")
    public Result getUser(@PathVariable("userName") String username){
        SysUser sysUser = sysUserService.findById(username);
        return Result.ok(sysUser);
    }

    /**
     * 查询单个ci节点信息
     * @param itemName item名
     * @return
     */
    @GetMapping("/item/{itemName}")
    public Result getItem(@PathVariable("itemName") String itemName){
        Item item = itemService.findById(itemName);
        return Result.ok(item);
    }

    /**
     * 查询单个用户组节点信息
     * @param groupName item名
     * @return
     */
    @GetMapping("/group/{name}")
    public Result getGroup(@PathVariable("name") String groupName){
        Group group = groupService.findById(groupName);
        return Result.ok(group);
    }



    /**
     * todo: 删除单个Incident节点信息（包括关联）
     * @param Id Incident id
     * @return
     */
    @DeleteMapping("/incident/{incidentId}")
    public Result deleteIncident(@PathVariable("incidentId") String Id){
        return Result.ok();
    }

    /**
     * todo: 删除单个Problem节点信息（包括关联）
     * @param id Problem id
     * @return
     */
    @DeleteMapping("/problem/{problemId}")
    public Result deleteProblem(@PathVariable("problemId") String id){
        return Result.ok();
    }
}
