package com.example.codereviewbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/codereview")
public class CodereviewController {

    @Autowired
    private Codereviewrepository repo;

    int i, j;

    @GetMapping("/{id}")
    public CodereviewEntity getCodereviewEntity(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    @PostMapping
    public CodereviewEntity createCodeReview(@RequestBody CodereviewEntity codereview) {
        String query = "INSERT INTO todos VALUES (" + codereview.getId() + ", '" + codereview.getTitle() + "')";
        return repo.save(codereview);
    }
}
