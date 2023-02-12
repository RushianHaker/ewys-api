package com.api.ewys.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс UserModel - модель пользователя
 *
 * @author Max Ivanov
 * created 12.02.2023
 */

@Data
@AllArgsConstructor
public class UserModel {
    private long id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private Integer age;

}
