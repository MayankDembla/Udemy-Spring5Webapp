package com.ayan.spring.webapp.service;

import com.ayan.spring.webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert(List<User> users) {

        for (User user : users) {

            System.out.println("Inserting Data For User Name " + user.getName());
            jdbcTemplate.update("insert into USER(Name, Dept, Salary) values (?,?,?)",
                    preparedStatement -> {
                        preparedStatement.setString(1, user.getName());
                        preparedStatement.setString(2, user.getDept());
                        preparedStatement.setLong(3, user.getSalary());
                    });
        }
    }

    public List<User> getUser() {

        List<User> userList =
                jdbcTemplate.query("Select * from USER",
                        (resultSet, i) -> new User(resultSet.getString("Name"),
                                resultSet.getString("Dept"),
                                resultSet.getLong("Salary")));

        return userList;
    }

}
