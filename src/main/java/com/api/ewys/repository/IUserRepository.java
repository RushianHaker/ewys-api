package com.api.ewys.repository;

import com.api.ewys.models.UserModel;

import java.util.List;

/**
 * Интерфейс IUserRepository - описывает методы работы обработки информации по пользователям
 *
 * @author Max Ivanov
 * created 12.02.2023
 */

public interface IUserRepository {

    /**
     * Получение пользователя по login
     *
     * @param login - пользовательский логин
     */
    UserModel getByLogin(String login);

    /**
     * Получение пользователя по id
     *
     * @param id - пользовательский идентификатор в БД
     */
    UserModel getById(Long id);

    /**
     * Получение всех пользователей
     *
     */
    List<UserModel> getAll();

    /**
     * Добавление пользователя
     *
     */
    void insertUser(UserModel user);

}
