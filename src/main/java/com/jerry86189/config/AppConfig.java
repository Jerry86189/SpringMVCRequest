package com.jerry86189.config;/**
 * @project SpringMVCRequest
 * @description TODO
 * @author Jerry
 * @date 2023/5/3 10:43
 * @version 1.0
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Jerry
 * @version 1.0
 * @description: TODO
 * @date 2023/5/3 10:43
 */
@Configuration
@ComponentScan("com.jerry86189")
@Import({AopConfig.class, DatabaseConfig.class, WebMvcConfig.class})
public class AppConfig {
}
