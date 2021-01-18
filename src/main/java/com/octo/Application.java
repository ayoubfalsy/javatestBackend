package com.octo;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.services.TestService;
import com.octo.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class Application implements CommandLineRunner {
    @Autowired
    private VideoService videoService;

    @Autowired
    private TestService testService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
    @Override
    public void run(String... args) throws Exception {
        //  Tester tous les scénarios.
        testService.firstSenario(); // null,null
        // ---> la résultat : Id : 1 Url Youtube :https://www.youtube.com/watch?v=K40FzwiGts0
//                            Id : 2 Url Youtube :https://www.youtube.com/watch?v=nl_uZtq_7d0
        testService.secondSenario(); // not null,null
        // ---> la résultat : aucune video
        testService.ThirdSenario(); // null,not null
        // ---> la résultat : Id : 1 Url Youtube :https://www.youtube.com/watch?v=K40FzwiGts0
        testService.FourthSenario(); // not null,not null
        // ---> la résultat : aucune video

        System.out.println("Application is running" );
    }
}
