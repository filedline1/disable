package com.personInfo.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//@Configuration
public class CORSConfig implements WebMvcConfigurer{


//    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").exposedHeaders("Authorization").exposedHeaders("code");
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*").allowedOrigins("*");
            }
        };
    }

//    @Bean
//    public CorsFilter corsFilter(){
//       final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//       final CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
//        return  new CorsFilter(urlBasedCorsConfigurationSource);

//    }


   /* @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","HEAD","POST","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true).maxAge(3000).allowedHeaders("*");
    }*/
}
