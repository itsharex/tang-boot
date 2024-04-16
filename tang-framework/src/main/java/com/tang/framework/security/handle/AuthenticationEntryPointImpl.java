package com.tang.framework.security.handle;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.tang.commons.constants.HttpStatus;
import com.tang.commons.utils.AjaxResult;
import com.tang.commons.utils.ServletUtils;
import com.tang.commons.utils.json.JSONUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 认证入口
 *
 * @author Tang
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    /**
     * 认证失败
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        var ajaxResult = AjaxResult.error(HttpStatus.UNAUTHORIZED, "认证失败，无法访问：" + request.getRequestURI());
        ServletUtils.renderString(response, JSONUtils.toStringPretty(ajaxResult));
    }

}
