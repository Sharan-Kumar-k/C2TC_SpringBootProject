package com.tnsif.placement_management.controller;

import com.tnsif.placement_management.entity.College;
import com.tnsif.placement_management.service.CollegeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    private final CollegeService service;

    public CollegeController(CollegeService service) {
        this.service = service;
    }

    @GetMapping
    public List<College> getAll() {
        return service.getAllColleges();
    }

    @GetMapping("/{id}")
    public College getOne(@PathVariable Long id) {
        return service.getCollegeById(id);
    }

    @PostMapping
    public College create(@RequestBody College c) {
        return service.createCollege(c);
    }

    @PutMapping("/{id}")
    public College update(@PathVariable Long id, @RequestBody College c) {
        return service.updateCollege(id, c);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteCollege(id);
        return "College deleted successfully!";
    }
}
