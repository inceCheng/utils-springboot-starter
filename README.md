# Utils Spring Boot Starter

这是一个工具类 Spring Boot Starter，提供了常用的工具类，包括结果返回工具（ResultUtils）和异常抛出工具（ThrowUtils）。

## 功能

- ResultUtils: 提供统一的 API 响应结果封装
- ThrowUtils: 提供条件异常抛出工具
- 内置常用的错误码和业务异常处理

## 使用方法

### 1. 添加依赖

```xml
<dependency>
    <groupId>com.ince</groupId>
    <artifactId>utils-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 2. 配置属性 (可选)

在 `application.yml` 中添加以下配置:

```yaml
ince:
  utils:
    enabled: true # 默认为 true
    success-message: "ok" # 默认的成功消息
```

### 3. 使用示例

#### ResultUtils 使用示例

```java
import com.ince.utils.ResultUtils;
import com.ince.utils.common.BaseResponse;
import com.ince.utils.enums.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/success")
    public BaseResponse<String> success() {
        return ResultUtils.success("成功示例");
    }

    @GetMapping("/error")
    public BaseResponse<?> error() {
        return ResultUtils.error(ErrorCode.PARAMS_ERROR);
    }

    @GetMapping("/custom-error")
    public BaseResponse<?> customError() {
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "自定义错误信息");
    }
}
```

#### ThrowUtils 使用示例

```java
import com.ince.utils.ThrowUtils;
import com.ince.utils.enums.ErrorCode;

public class DemoService {

    public void checkParam(String param) {
        // 如果条件成立则抛出异常
        ThrowUtils.throwIf(param == null, ErrorCode.PARAMS_ERROR);
        
        // 自定义错误信息
        ThrowUtils.throwIf(param.isEmpty(), ErrorCode.PARAMS_ERROR, "参数不能为空");
    }
}
```

## 许可证

MIT 