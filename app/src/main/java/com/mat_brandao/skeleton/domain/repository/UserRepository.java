package com.mat_brandao.skeleton.domain.repository;


import com.mat_brandao.skeleton.domain.model.User;

/**
 * Created by Mateus Brandão on 4/11/2016.
 */
public interface UserRepository {
    User getUser();

    void saveUser(User user);

    void clearUsers();
}
