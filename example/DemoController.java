package com.example.demo;

import com.ince.utils.ResultUtils;
import com.ince.utils.ThrowUtils;
import com.ince.utils.common.BaseResponse;
import com.ince.utils.enums.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例控制器，展示如何使用工具类
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    /**
     * 成功返回示例
     */
    @GetMapping("/success")
    public BaseResponse<String> success() {
        return ResultUtils.success("操作成功");
    }

    /**
     * 错误返回示例
     */
    @GetMapping("/error")
    public BaseResponse<?> error() {
        return ResultUtils.error(ErrorCode.PARAMS_ERROR);
    }

    /**
     * 自定义错误信息示例
     */
    @GetMapping("/custom-error")
    public BaseResponse<?> customError() {
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "服务器内部错误，请稍后再试");
    }

    /**
     * 异常抛出示例
     */
    @GetMapping("/check")
    public BaseResponse<String> checkParam(@RequestParam(required = false) String param) {
        // 参数为空则抛出异常
        ThrowUtils.throwIf(param == null || param.isEmpty(), ErrorCode.PARAMS_ERROR, "参数不能为空");
        
        // 正常返回
        return ResultUtils.success("参数校验通过: " + param);
    }
} 