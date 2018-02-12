package com.sav.common.util.jwt;


import com.sav.common.constant.CommonConstants;
import com.sav.common.util.KeyHelper;
import com.sav.common.util.StringHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * Created by kaikai on 2018/1/15.
 */
public class JWTHelper {

    /**
     * 生成密钥
     */
    public static String generateToken(String priPath,IJWTInfo ijwtInfo,int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(ijwtInfo.getUserName())
                .claim(CommonConstants.JWT_KEY_NAME,ijwtInfo.getName())
                .claim(CommonConstants.JWT_KEY_USER_ID,ijwtInfo.getUserId())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, KeyHelper.getPrivateKey(priPath))
                .compact();
        return compactJws;
    }

    /**
     * 解析token
     */
    public static Jws<Claims> parseToken(String token,String pubPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(KeyHelper.getPublicKey(pubPath))
                .parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取存放在token中的用户信息
     */
    public static IJWTInfo getUserFromToken(String token,String pubPath) throws Exception {
        Jws<Claims> claimsJws = parseToken(token, pubPath);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_NAME)),StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_ID)));
    }
}
