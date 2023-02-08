package com.api.ewys.repository.mapper;

import com.api.ewys.models.DemoModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DemoModelMapper implements RowMapper<DemoModel> {
    @NotNull
    @Override
    public DemoModel mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
        return new DemoModel(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("full_name"));
    }
}