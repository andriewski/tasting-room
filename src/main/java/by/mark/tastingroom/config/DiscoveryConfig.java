package by.mark.tastingroom.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("digitalocean")
@Configuration
@EnableDiscoveryClient
public class DiscoveryConfig {
}
