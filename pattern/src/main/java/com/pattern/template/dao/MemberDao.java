package com.pattern.template.dao;

import com.pattern.template.JdbcTemplate;
import com.pattern.template.RowMapper;
import com.pattern.template.entity.Member;

import java.sql.ResultSet;
import java.util.List;

/**
 * 解耦
 * Created by Tom on 2018/3/11.
 */
public class MemberDao {

    //为什么不继承，主要是为了解耦
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<?> query() {
        String sql = "select * from t_member";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Member>() {
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        }, null);
    }


}
