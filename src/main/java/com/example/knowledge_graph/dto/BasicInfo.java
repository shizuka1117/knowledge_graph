package com.example.knowledge_graph.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class BasicInfo {
    String label;
    String id;
    Integer size;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicInfo info = (BasicInfo) o;
        return Objects.equals(id, info.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
