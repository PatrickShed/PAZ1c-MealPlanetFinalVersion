/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.mealplanet;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Patrik
 */
public class MySqlMealTypeDao implements MealTypeDao{
    
    private JdbcTemplate jdbcTemplate;
    
    
    public MySqlMealTypeDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/paz1c-mealplanet");
        dataSource.setUser("root");
        dataSource.setPassword("22111994");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<String> getAllNames() {        
        List<String> mealTypeNames = new ArrayList<>();
        for (MealType mealType : this.getAll()) {
            mealTypeNames.add(mealType.getName());
        }
        return mealTypeNames;
    }

    @Override
    public List<MealType> getAll() {
        String sql = "SELECT * FROM mealtypes";
        BeanPropertyRowMapper<MealType> mapper = BeanPropertyRowMapper.newInstance(MealType.class);//tovaren
        List<MealType> mealTypes = jdbcTemplate.query(sql, mapper);
        return mealTypes;
    }
    
    
    
}
