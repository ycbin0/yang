package com.bin.common.util;

import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: RequestBodyUtil
 * @Description: 获取 @RequestBody 的数据
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class RequestBodyUtil {

    public static String getRequestBody(ServletRequest request){
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try{
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line = "";
            while ((line = reader.readLine()) != null){
                stringBuffer.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return stringBuffer.toString();
        }
    }
}
