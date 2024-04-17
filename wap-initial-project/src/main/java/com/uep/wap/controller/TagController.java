package com.uep.wap.controller;
import com.uep.wap.dto.TagDTO;
import com.uep.wap.model.Tag;
import com.uep.wap.service.TagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(path = "/")
    public Iterable<Tag> getAllTags(){
        return tagService.getAllTags();
    }

    @PostMapping(path = "/")
    public String addTag(@RequestBody TagDTO tagDTO){
        tagService.addTag(tagDTO);
        return "Tag added!";
    }
}
