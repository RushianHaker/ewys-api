package com.api.ewys.repository.mapper;

import com.api.ewys.models.UserModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserModelMapper implements RowMapper<UserModel> {
    @NotNull
    @Override
    public UserModel mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
        return new UserModel(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("age"),
                rs.getString("login"),
                rs.getInt("password"));
    }
}