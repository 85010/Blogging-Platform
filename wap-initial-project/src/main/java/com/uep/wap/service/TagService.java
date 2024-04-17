package com.uep.wap.service;

import com.uep.wap.model.User;
import com.uep.wap.repository.StudentRepository;
import com.uep.wap.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public void addTag(TagDTO tagDTO) {
        Tag tag = new Tag(tagDTO.getName(), tagDTO.getQuestions());
        tagRepository.save(tag);

        System.out.println("Tag added");
    }

    public Iterable<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}

