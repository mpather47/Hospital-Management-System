package com.mpather47.git.repository.hospital;

import com.mpather47.git.entity.hospital.Ward;
import com.mpather47.git.repository.IRepository;

import java.util.Set;

public interface WardRepository extends IRepository<Ward, Integer> {
    Set<Ward> getAll();
}
