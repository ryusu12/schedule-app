package com.example.scheduleapp.repository.user;

import com.example.scheduleapp.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcTemplateUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //생성
    @Override
    public User saveUser(User user) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(this.jdbcTemplate);
        insert.withTableName("user").usingGeneratedKeyColumns("user_id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", user.getName());
        parameters.put("email", user.getEmail());
        parameters.put("create_date", user.getCreateDate());
        parameters.put("update_date", user.getUpdateDate());

        Number key = insert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        user.setUserId(key.longValue());
        return user;
    }

    //조회
    @Override
    public User findUserByNameAndEmailOrElseThrow(String name, String email) {
        List<User> result = jdbcTemplate.query("SELECT * FROM user WHERE name = ? AND  email = ? ORDER BY update_date DESC", userRowMapper(), name, email);
        return result.stream().findAny().orElse(null);
    }

    //Mapper
    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> new User(
                rs.getLong("user_id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getDate("create_date"),
                rs.getDate("update_date")
        );
    }
}