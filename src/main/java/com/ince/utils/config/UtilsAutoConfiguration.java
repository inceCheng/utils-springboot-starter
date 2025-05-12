package com.ince.utils.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 工具类自动配置
 */
@Configuration
@EnableConfigurationProperties(UtilsProperties.class)
@ConditionalOnProperty(prefix = "ince.utils", name = "enabled", havingValue = "true", matchIfMissing = true)
@ComponentScan(basePackages = {"com.ince.utils"})
public class UtilsAutoConfiguration {
    
} 