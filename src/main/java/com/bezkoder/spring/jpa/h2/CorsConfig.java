//package com.bezkoder.spring.jpa.h2;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/api/**")
//                .allowedOrigins("http://127.0.0.1:5173")
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .allowedHeaders("*");
//        registry.addMapping("/expense/**")
//        .allowedOrigins("http://127.0.0.1:5173")
//        .allowedMethods("GET", "POST", "PUT", "DELETE")
//        .allowedHeaders("*");
//        registry.addMapping("/exp/**")
//        .allowedOrigins("http://127.0.0.1:5173")
//        .allowedMethods("GET", "POST", "PUT", "DELETE")
//        .allowedHeaders("*");
//        registry.addMapping("/api/user/**")
//        .allowedOrigins("http://127.0.0.1:5173")
//        .allowedMethods("GET", "POST", "PUT", "DELETE")
//        .allowedHeaders("*");
//        registry.addMapping("/get/account/**")
//        .allowedOrigins("http://127.0.0.1:5173")
//        .allowedMethods("GET", "POST", "PUT", "DELETE")
//        .allowedHeaders("*");
//        registry.addMapping("/api/**")
//        .allowedOrigins("http://192.168.1.166:5173")
//        .allowedMethods("GET", "POST", "PUT", "DELETE")
//        .allowedHeaders("*");
//        registry.addMapping("/expense/**")
//        .allowedOrigins("http://192.168.1.166:5173")
//        .allowedMethods("GET", "POST", "PUT", "DELETE")
//        .allowedHeaders("*");
//        registry.addMapping("/exp/**")
//        .allowedOrigins("http://192.168.1.166:5173")
//        .allowedMethods("GET", "POST", "PUT", "DELETE")
//        .allowedHeaders("*");
//        registry.addMapping("/api/user/**")
//        .allowedOrigins("http://192.168.1.166:5173")
//        .allowedMethods("GET", "POST", "PUT", "DELETE")
//        .allowedHeaders("*");
//        registry.addMapping("/get/account/**")
//        .allowedOrigins("http://192.168.1.166:5173")
//        .allowedMethods("GET", "POST", "PUT", "DELETE")
//        .allowedHeaders("*");        
//        
//    }
//}

package com.bezkoder.spring.jpa.h2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Allow requests from any origin
        config.addAllowedMethod("*"); // Allow all HTTP methods
        config.addAllowedHeader("*"); // Allow all headers
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
