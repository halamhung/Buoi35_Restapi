package com.example.baitap.dto;

import java.util.List;

public class TagsDTO {
    private List<String> tags;

    public TagsDTO(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() { return tags; }
}