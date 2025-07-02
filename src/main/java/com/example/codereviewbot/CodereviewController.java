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
        return repo.findById(id).get();
    }

    @PostMapping
    public CodereviewEntity createTodo(@RequestBody CodereviewEntity codereview) {
        return repo.save(codereview);
    }
}
