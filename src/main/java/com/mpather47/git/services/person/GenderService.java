package com.mpather47.git.services.person;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.services.IService;

import java.util.Set;

public interface GenderService extends IService<Gender, Integer> {
    Set<Gender> getAll();
}
