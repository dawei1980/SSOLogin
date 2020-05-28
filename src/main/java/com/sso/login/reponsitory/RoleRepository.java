package com.sso.login.reponsitory;

import com.sso.login.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * @Author 大誌
 * @Date 2019/3/30 22:05
 * @Version 1.0
 */
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
