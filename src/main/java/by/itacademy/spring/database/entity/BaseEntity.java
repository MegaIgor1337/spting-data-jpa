package by.itacademy.spring.database.entity;

import lombok.ToString;

import java.io.Serializable;


public interface BaseEntity<T extends Serializable> {
    T getId();

    void setId(T id);
}
