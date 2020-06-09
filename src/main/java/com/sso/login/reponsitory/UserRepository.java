package com.sso.login.reponsitory;


import com.sso.login.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

/**
 * @Author 大誌
 * @Date 2019/3/30 22:05
 * @Version 1.0
 */
@Transactional
public interface UserRepository extends JpaRepository<SysUser, Integer> {
    SysUser findByUsername(String username);

    SysUser findByUserId(Integer userId);

    List<SysUser> findAll();

}
