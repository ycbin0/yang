package com.bin.common.baseObj;

import com.bin.common.common.Constant;
import com.bin.common.common.HttpStatus;

import java.util.HashMap;

/**
 * @ClassName: ResultResponse
 * @Description: 响应结果类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class ResultResponse extends HashMap<String, Object> {

    /**
     * 状态码
     */
    private final static String CODE = "code";

    /**
     * 消息体
     */
    private final static String MSG = "msg";

    /**
     * 消息数据
     */
    private final static String DATA = "data";

    public ResultResponse(int code, String msg) {
        super.put(this.CODE, code);
        super.put(this.MSG, msg);
    }

    public ResultResponse(int code, String msg, Object data) {
        super.put(this.CODE, code);
        super.put(this.MSG, msg);
        super.put(this.DATA, data);
    }

    /**
     * 返回成功
     * @return
     */
    public static ResultResponse success(){
        return ResultResponse.success(Constant.SUCCESS);
    }

    public static ResultResponse success(String msg){
        return ResultResponse.success(msg, null);
    }

    public static ResultResponse success(Object data){
        return ResultResponse.success( Constant.SUCCESS, data);
    }

    public static ResultResponse success(String msg, Object data){
        return new ResultResponse(HttpStatus.SUCCESS, msg, data);
    }


    /**
     * 返回失败
     * @return
     */
    public static ResultResponse error(){
        return ResultResponse.error(Constant.Failed);
    }

    public static ResultResponse error(String msg){
        return ResultResponse.error(msg, null);
    }

    public static ResultResponse error(Object data){
        return ResultResponse.error( Constant.Failed, data);
    }

    public static ResultResponse error(String msg, Object data){
        return new ResultResponse(HttpStatus.ERROR, msg, data);
    }





}
