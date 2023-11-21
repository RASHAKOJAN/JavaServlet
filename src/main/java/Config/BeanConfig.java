package Config;


import Containers.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;



@Configuration
public class BeanConfig {

    @Bean // if we want to make bean like that where found in applicationContext
    @Scope("prototype")
    public Department department(){
        return  new Department();
    }
}
