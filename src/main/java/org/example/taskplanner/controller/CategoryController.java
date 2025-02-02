package org.example.taskplanner.controller;

import lombok.AllArgsConstructor;
import org.example.taskplanner.entity.Category;
import org.example.taskplanner.requests.CategorySearchValues;
import org.example.taskplanner.service.CategoryService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService service;

    @PostMapping("/all")
    public List<Category> findAll(@RequestBody String email) {
        return service.findAll(email);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category) {
        if (category.getId() != null && category.getId() != 0) {
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() == null || category.getTitle().trim().isEmpty()) {
            return new ResponseEntity("missed param: title MUST be not null", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(service.add(category));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Category category) {
        if (category.getId() == null || category.getId() == 0) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() == null || category.getTitle().trim().isEmpty()) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        service.update(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            service.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategorySearchValues categorySearchValues) {
        if (categorySearchValues.getEmail() == null || categorySearchValues.getEmail().trim().isEmpty()) {
            return new ResponseEntity("missed param: email", HttpStatus.NOT_ACCEPTABLE);
        }
        List<Category> list = service.findByTitle(categorySearchValues.getTitle(), categorySearchValues.getEmail());
        return ResponseEntity.ok(list);
    }

    @PostMapping("/id")
    public ResponseEntity<Category> findById(@RequestBody Long id) {
        Category category = null;
        try {
            category = service.findById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(category);
    }
}
