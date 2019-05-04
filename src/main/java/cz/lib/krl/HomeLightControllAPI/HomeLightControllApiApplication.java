package cz.lib.krl.HomeLightControllAPI;

import cz.lib.krl.HomeLightControllAPI.Model.JobGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HomeLightControllApiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HomeLightControllApiApplication.class, args);
        context.getBean(JobGenerator.class).generateJobs();
    }

}
