package com.tang.admin.controller;

import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tang.commons.constants.CachePrefix;
import com.tang.commons.model.CaptchaModel;
import com.tang.commons.utils.AjaxResult;
import com.tang.commons.utils.RedisUtils;
import com.tang.commons.utils.captcha.CaptchaType;
import com.tang.commons.utils.captcha.CaptchaUtils;

/**
 * 验证码逻辑控制层
 *
 * @author Tang
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    private final RedisUtils redisUtils;

    public CaptchaController(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @GetMapping
    public AjaxResult getCaptcha() {
        var captcha = CaptchaUtils.generate(CaptchaType.NUMBER);
        var base64 = Base64.getEncoder().encodeToString(captcha.getImage());
        redisUtils.set(CachePrefix.CAPTCHA + captcha.getId(), captcha.getText(), 60);
        return AjaxResult.success(new CaptchaModel(captcha.getId(), base64));
    }

}