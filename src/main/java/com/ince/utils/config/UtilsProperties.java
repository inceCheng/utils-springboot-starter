package com.ince.utils.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 工具类配置属性
 */
@ConfigurationProperties(prefix = "ince.utils")
public class UtilsProperties {
    
    /**
     * 是否启用工具类
     */
    private boolean enabled = true;
    
    /**
     * 默认成功消息
     */
    private String successMessage = "ok";
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String getSuccessMessage() {
        return successMessage;
    }
    
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
} 