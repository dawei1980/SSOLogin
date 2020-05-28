package com.sso.login.service;

import com.sso.login.entity.SysToken;
import com.sso.login.entity.User;

import java.util.Map;

/**
 * @Author 大誌
 * @Date 2019/3/30 22:18
 * @Version 1.0
 */
public interface ShiroService {
     /**
      * Find user by username
      * @param username
      * @return
      */
     User findByUsername(String username);

     /**
      * create token by userId
      * @param userId
      * @return
      */
     Map<String,Object> createToken(Integer userId);

     /**
      * logout
      * @param token
      */
     void logout(String token);

     /**
      * find token by token
      * @param accessToken
      * @return
      */
     SysToken findByToken(String accessToken);

     /**
      * find user by userId
      * @param userId
      * @return
      */
     User findByUserId(Integer userId);
}
