package sunibas.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by ibas on 12/19/16.
 */
public class TestFirst {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(){
        template.execute("insert into t_mytable(`col2`) values('one');");
    }
}
