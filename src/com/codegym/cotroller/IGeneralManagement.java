package com.codegym.cotroller;

public interface IGeneralManagement<T> {
    void showAll();

    void addNew(T t);

    void updateById(String id, T t);

    void removeById(String id);

    int findByPhoneNumber(String phoneNumber);
}
