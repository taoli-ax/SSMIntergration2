package com.coh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.coh.controller","com.coh.exception"})
@EnableWebMvc
public class SpringMVCConfig {
}
