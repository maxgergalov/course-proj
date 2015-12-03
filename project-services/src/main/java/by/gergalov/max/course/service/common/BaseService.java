package by.gergalov.max.course.service.common;

public interface BaseService<T> {

    long count();

    T getById(long id);

}
