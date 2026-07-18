package com.security.java_project.system_design.inventory.repos;

import java.util.List;

public interface Repository <T, ID>{
    void save(T entity);

    T findById(ID id);

    List<T> findAll();

    void delete(ID id);
}
