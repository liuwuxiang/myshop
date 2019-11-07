package com.lwx.my.shop.web.admin.dao;

import com.lwx.my.shop.commons.persistence.BaseDao;
import com.lwx.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @author 刘武祥
 */
@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
