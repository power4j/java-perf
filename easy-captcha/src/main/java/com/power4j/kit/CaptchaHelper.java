package com.power4j.kit;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.ChineseGifCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;

/**
 * @author CJ (power4j@outlook.com)
 * @date 2021/1/12
 * @since 1.0
 */
public class CaptchaHelper {
    private CaptchaHelper(){}

    public static SpecCaptcha specCaptcha(int width, int height){
        return new SpecCaptcha(width, height);
    }

    public static GifCaptcha gifCaptcha(int width, int height){
        return new GifCaptcha(width, height);
    }

    public static ChineseCaptcha chineseCaptcha(int width, int height){
        return new ChineseCaptcha(width, height);
    }

    public static ChineseGifCaptcha chineseGifCaptcha(int width, int height){
        return new ChineseGifCaptcha(width, height);
    }

    public static ArithmeticCaptcha arithmeticCaptcha(int width, int height){
        return new ArithmeticCaptcha(width, height);
    }
}
