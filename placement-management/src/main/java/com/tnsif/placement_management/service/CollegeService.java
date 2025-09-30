package com.tnsif.placement_management.service;

import com.tnsif.placement_management.entity.College;

import java.util.List;

public interface CollegeService {

    List<College> getAllColleges();
    College getCollegeById(Long id);
    College createCollege(College college);
    College updateCollege(Long id, College college);
    void deleteCollege(Long id);
}
