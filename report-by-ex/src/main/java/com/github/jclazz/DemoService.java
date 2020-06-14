package com.github.jclazz;

import com.github.jclazz.utils.BizException;
import com.github.jclazz.utils.R;

/**
 * @author CJ (jclazz@outlook.com)
 * @date 2020/6/14
 * @since 1.0
 */
public class DemoService {
    public static R<Integer> successNoThrown(){
        try {
            return R.ok(reportByThrow(false));
        }catch (BizException e){
            return R.fail(e.getMessage());
        }
    }
    public static R<Integer> success(){
        return reportByR(false);
    }
    public static R<Integer> failByCatch(){
        try {
            return R.ok(reportByThrow(true));
        }catch (BizException e){
            return R.fail(e.getMessage());
        }
    }
    public static R<Integer> fail(){
        return reportByR(true);
    }

    private static Integer reportByThrow(boolean failFlag){
        if(failFlag){
            throw new BizException("failed");
        }
        return Integer.MIN_VALUE;
    }
    private static R<Integer> reportByR(boolean failFlag){
        if(failFlag){
            return R.fail("failed");
        }
        return R.ok(Integer.MIN_VALUE);
    }
}
