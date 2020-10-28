package com.mpather47.git.repository.person;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {
    //List<Gender> getAll();
}
