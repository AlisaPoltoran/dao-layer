package ru.netology.doalayer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataBaseRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    String script;

    public DataBaseRepository() {
        this.script = read("myScript.sql");
    }

    public static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", "%" + name + "%");
        List<String> result = namedParameterJdbcTemplate.queryForList(script, namedParameters, String.class);
        return result.isEmpty() ? "No results is found" : result.get(0);
    }

}
