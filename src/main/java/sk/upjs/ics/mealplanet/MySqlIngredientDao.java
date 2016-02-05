package sk.upjs.ics.mealplanet;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlIngredientDao implements IngredientDao {

    private JdbcTemplate jdbcTemplate;
    
    
    public MySqlIngredientDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/paz1c-mealplanet");
        dataSource.setUser("root");
        dataSource.setPassword("22111994");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        String sql = "INSERT INTO ingredients VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, null, ingredient.getName(), ingredient.getProtein(),
                ingredient.getFat(), ingredient.getCarb());

    }

    @Override
    public List<Ingredient> getAllOrdered() {
        String sql = "SELECT * FROM ingredients ORDER BY ingredients.name";
        BeanPropertyRowMapper<Ingredient> mapper = BeanPropertyRowMapper.newInstance(Ingredient.class);//tovaren
        List<Ingredient> orderedIngredients = jdbcTemplate.query(sql, mapper);
        return orderedIngredients;
    }
}
