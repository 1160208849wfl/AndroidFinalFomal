package top.wufl.service;

import java.util.List;

public interface Service<T> {
    void save(T model) throws Exception;

    void update(T model) throws Exception;

    void delete(T model) throws Exception;

    List<T> findAll() throws Exception;

    T findById(Object idValue) throws Exception;

    List<T> findByFieldName(String fieldName, Object fieldValue) throws Exception;
}
