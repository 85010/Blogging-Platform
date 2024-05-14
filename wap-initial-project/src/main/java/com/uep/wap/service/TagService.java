package com.uep.wap.service;

import com.uep.wap.dto.TagDTO;
import com.uep.wap.model.Post;
import com.uep.wap.model.Tag;
import com.uep.wap.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public void addTag(TagDTO tagDTO) {
        Tag tag = new Tag(tagDTO.getName(), new ArrayList<Post>());
        tagRepository.save(tag);

        System.out.println("Tag added");
    }

    public Iterable<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}

