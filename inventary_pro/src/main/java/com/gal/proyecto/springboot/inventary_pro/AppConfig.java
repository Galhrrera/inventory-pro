package com.gal.proyecto.springboot.inventary_pro;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:messages.properties")
})
public class AppConfig {

}
