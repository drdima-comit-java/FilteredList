package ru.javabegin.training.interfaces;

import ru.javabegin.training.objects.User;

public interface UserDao {


    void insert(User user);
    boolean checkUserNameExist(User user);
    User checkUserPassword(User user);

    void delete(User user);






}
