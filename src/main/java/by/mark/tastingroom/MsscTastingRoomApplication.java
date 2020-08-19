package by.mark.tastingroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsscTastingRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsscTastingRoomApplication.class, args);
    }
}
