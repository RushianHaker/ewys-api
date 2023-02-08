package com.api.ewys.repository.implemented;


import com.api.ewys.models.DemoModel;
import com.api.ewys.repository.IDemoRepository;
import com.api.ewys.repository.mapper.DemoModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс DemoRepository - реализует методы работы обработки информации по карточкам
 */

@Slf4j
@Repository
public class DemoRepository implements IDemoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final DemoModelMapper DEMO_MODEL_MAPPER = new DemoModelMapper();

    public DemoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<DemoModel> batchSelect(@NotNull List<String> names) {

        /*С пустым IN запрос не пройдёт в этом виде, но оно и не нужно*/
        if (names.size() == 0) return new ArrayList<>();

        SqlParameterSource param = new MapSqlParameterSource("names", names);

        return namedParameterJdbcTemplate.query(
                "select id, \"name\", full_name " +
                    "from demo_table " +
                    "where \"name\" in ( :names ) group by id, \"name\", full_name",
                param, DEMO_MODEL_MAPPER);
    }

    @Override
    public void batchInsert(@NotNull List<DemoModel> demoList) {
        try {
            List<Object[]> batchArgs = new ArrayList<>();
            for (var item : demoList) {
                batchArgs.add(new Object[]{
                        item.getId(), item.getName(), item.getFullName()
                });
            }

            jdbcTemplate.batchUpdate("insert into demo_table (id, \"name\", full_name) values (?, ?, ?)", batchArgs);
            log.trace("batchInsert(): post request with [{}] demoList is added", demoList.size());
        } catch (DataAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}