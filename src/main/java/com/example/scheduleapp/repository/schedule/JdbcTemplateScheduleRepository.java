package com.example.scheduleapp.repository.schedule;

import com.example.scheduleapp.dto.ScheduleResponseDto;
import com.example.scheduleapp.entity.Schedule;
import com.example.scheduleapp.exception.NotFoundScheduleException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //생성
    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(this.jdbcTemplate);
        insert.withTableName("schedule").usingGeneratedKeyColumns("schedule_id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("todo", schedule.getTodo());
        parameters.put("user_id", schedule.getUserId());
        parameters.put("create_name", schedule.getCreateName());
        parameters.put("password", schedule.getPassword());
        parameters.put("create_date", schedule.getCreateDate());
        parameters.put("update_date", schedule.getUpdateDate());

        Number key = insert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScheduleResponseDto(key.longValue(), schedule);
    }

    //조회
    @Override
    public List<ScheduleResponseDto> findAllSchedules(String name, Long userId, Date updateDate) {
        StringBuilder sql = new StringBuilder("SELECT * FROM schedule WHERE 1=1 ");
        List<Object> params = new ArrayList<>();

        if (name != null) {
            sql.append("AND create_name = ? ");
            params.add(name);
        }
        if (updateDate != null) {
            sql.append("AND update_date = ? ");
            params.add(updateDate);
        }
        if (userId != null) {
            sql.append("AND user_id = ? ");
            params.add(userId);
        }
        sql.append("ORDER BY update_date DESC");

        return jdbcTemplate.query(sql.toString(), scheduleRowMapper(), params.toArray());
    }

    @Override
    public ScheduleResponseDto findScheduleByIdOrElseThrow(Long id) {
        List<ScheduleResponseDto> result = jdbcTemplate.query("SELECT * FROM schedule WHERE schedule_id = ? ORDER BY update_date DESC", scheduleRowMapper(), id);
        return result.stream().findAny().orElseThrow(() -> new NotFoundScheduleException("Does not exist schedule"));
    }

    //수정
    @Override
    public int updateMemoTitle(Long id, String todo, String name, String password) {
        StringBuilder sql = new StringBuilder("UPDATE schedule SET update_date = NOW(), todo = ?");
        List<Object> params = new ArrayList<>();

        params.add(todo);
        if (name != null) {
            sql.append(", create_name = ?");
            params.add(name);
        }
        sql.append(" WHERE schedule_id = ? AND password = ?");
        params.add(id);
        params.add(password);

        return jdbcTemplate.update(sql.toString(), params.toArray());
    }

    //삭제
    @Override
    public int removeSchedule(Long id, String password) {
        return jdbcTemplate.update("DELETE FROM schedule WHERE schedule_id = ? AND password = ?", id, password);
    }

    //Mapper
    private RowMapper<ScheduleResponseDto> scheduleRowMapper() {
        return (rs, rowNum) -> new ScheduleResponseDto(
                rs.getLong("schedule_id"),
                rs.getString("todo"),
                rs.getString("create_name"),
                rs.getString("password"),
                rs.getDate("create_date"),
                rs.getDate("update_date")
        );
    }
}