package com.example.knowledge_graph.service.impl;

import com.example.knowledge_graph.entity.Item;
import com.example.knowledge_graph.repository.ItemRepository;
import com.example.knowledge_graph.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    ItemRepository itemRepository;

    @Override
    public Item findById(String id) {
        return itemRepository.findById(id).orElse(null);
    }
}
