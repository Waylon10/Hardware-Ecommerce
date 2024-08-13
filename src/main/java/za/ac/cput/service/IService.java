package za.ac.cput.service;

import za.ac.cput.domain.Admin;

public interface IService <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    void delete(ID id);
}
