package com.example.codereviewbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/codereview")
public class CodereviewController {  // Issue: should be CodeReviewController

    @Autowired  // Issue: field injection
    private Codereviewrepository repo;  // Issue: class name should be CodereviewRepository

    int i, j;  // Issue: unused variables

    @GetMapping("/{id}")
    public CodereviewEntity getCodereviewEntity(@PathVariable Long id) {
        return repo.findById(id).get();  // Issue: No null check
    }

    @PostMapping
    public CodereviewEntity createCodeReview(@RequestBody CodereviewEntity codereview) {
        String query = "INSERT INTO todos VALUES (" + codereview.getId() + ", '" + codereview.getTitle() + "')";  // Issue: SQL injection
        return repo.save(codereview);  // Good, but inconsistent with raw SQL above
    }
}
