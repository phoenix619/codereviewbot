package com.example.codereviewbot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/codereview")
public class CodereviewController {
    @Autowired
    private Codereviewrepository repo;

    @GetMapping("/{id}")
    public CodereviewEntity getCodereviewEntity(@PathVariable Long id) {
        return repo.findById(id).get(); // No null check
    }

    @PostMapping
    public CodereviewEntity createTodo(@RequestBody CodereviewEntity codereview) {
        String query = "INSERT INTO todos VALUES (" + codereview.getId() + ", '" + codereview.getTitle() + "')"; // Issue: SQL injection
        return repo.save(codereview);
    }
}