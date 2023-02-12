package com.api.ewys.repository.implemented;


import com.api.ewys.models.UserModel;
import com.api.ewys.repository.IUserRepository;
import com.api.ewys.repository.mapper.UserModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Класс UserRepository - реализует методы работы обработки информации по пользователям
 */
@Slf4j
@Repository
public class UserRepository implements IUserRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final UserModelMapper USER_MODEL_MAPPER = new UserModelMapper();

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<UserModel> getAll() {
        return jdbcTemplate.query("SELECT id, first_name, last_name, age, login, password FROM user_table", USER_MODEL_MAPPER);
    }

    @Override
    public UserModel getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id, first_name, last_name, age, login, password FROM user_table WHERE id = ?",
                USER_MODEL_MAPPER, id);
    }

    @Override
    public UserModel getByLogin(String login) {
        return jdbcTemplate.queryForObject("SELECT id, first_name, last_name, age, login, password FROM user_table WHERE login = ?",
                USER_MODEL_MAPPER, login);
    }

    @Override
    public void insertUser(UserModel user) {
        log.trace("insertUser(): post request with new user: {}", user);
        jdbcTemplate.update("insert into user_table (id, first_name, last_name, age, login, password) values (?, ?, ?, ?, ?, ?)",
                user.getId(), user.getFirstname(), user.getLastname(), user.getAge(), user.getLogin(), user.getPassword());
    }
}