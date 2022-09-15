package com.bin.common.util;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: JwtUtil
 * @Description: jwt工具类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Component
public class JwtUtil {

    /**
     * 盐值
     */
    private static  String SALT;

    /**
     * 过期时间
     */
    private static long EXPIPATION_TIME;

//    @NacosValue(value = "${jwt.salt}", autoRefreshed = true)
    @Value("${jwt.salt}")
    public void setSalt(String salt){
        SALT = salt;
    }

    /**
     * 对于不是String类型注入
     * @param expipationTime
     */
    @Value("#{${jwt.expipationTime}}")
    public void setExpipationTime(long expipationTime){
        EXPIPATION_TIME = expipationTime;
    }

    /**
     * 生成token
     * @param obj
     * @return
     */
    public static String createToken(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String userTotal = objectMapper.writeValueAsString(obj);
        return JWT.create()
                .withClaim("user", userTotal)
                .withIssuer("bin")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(Instant.now().toEpochMilli() + EXPIPATION_TIME))
                .sign(Algorithm.HMAC256(SALT));
    }


    /**
     * 验证token 通过token的前俩部分和加密算法，密钥（盐值）重新生成第三部分，比较验证
     * @param token
     * @return
     */
    public static boolean verity(String token){
        try{
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SALT))
                    .build();
            DecodedJWT verify = verifier.verify(token);
            return true;
        } catch (JWTVerificationException e){
            System.out.println("解密无效 token");
            return false;
        }
    }

    /**
     * 返回需要的token中的值
     * @param field
     * @param token
     * @return
     */
    public static Claim getData(String field, String token){
        return JWT.decode(token).getClaim(field);
    }


    /**
     * 是否过期，过期返回 true
     * @param token
     * @return
     */
    public static boolean isExpired(String token){
        System.out.println(JWT.decode(token).getExpiresAt().toLocaleString());
        return JWT.decode(token).getExpiresAt().before(new Date());
    }



}
