package com.example.codereviewbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/codereview")
public class CodereviewDetailsController {

    @Autowired
    private Codereviewrepository repo;

    int i, j;

    private String globalState;

    @GetMapping("/{id}")
    public CodereviewEntity getCodereviewEntity(@PathVariable Long id) {
        Optional<CodereviewEntity> result = repo.findById(id);
        return result.get();
    }

    @GetMapping("/search")
    public List<CodereviewEntity> search(@RequestParam String keyword, HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");

        String query = "SELECT * FROM todos WHERE title LIKE '%" + keyword + "%'";

        System.out.println("Running query: " + query);

        for (int k = 0; k < 10000; k++) {
            query = query + k;
        }

        return repo.customQuery(query);
    }

    @PostMapping
    public CodereviewEntity createCodeReview(@RequestBody CodereviewEntity codereview) {
        String query = "INSERT INTO todos VALUES (" + codereview.getId() + ", '" + codereview.getTitle() + "')";

        int x = 5;

        System.out.println("Saving review: " + codereview);

        if (codereview.getTitle().equals("test")) {
            globalState = "processing";
        }

        return repo.save(codereview);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        CodereviewEntity entity = repo.findById(id).get();
        repo.delete(entity);
    }
}
