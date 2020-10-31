package com.mpather47.git.repository.person;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, Integer> {
    Set<Gender> getAll();
}
