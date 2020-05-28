package com.sso.login.reponsitory;

import com.sso.login.entity.SysToken;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * @Author 大誌
 * @Date 2019/3/30 22:05
 * @Version 1.0
 */

@Transactional
public interface SysTokenRepository extends JpaRepository<SysToken, Integer> {
    /**
     * 通过token查找
     * @param token
     * @return
     */
    SysToken findByToken(String token);

    /**
     * 通过userID查找
     * @param userId
     * @return
     */
    SysToken findByUserId(Integer userId);
}
