package com.mpather47.git.repository.employee;

public interface Repository <T , ID>{


    T create (T t);
    T read (ID id);
    T update(T t);
    void delete(ID id);




}
