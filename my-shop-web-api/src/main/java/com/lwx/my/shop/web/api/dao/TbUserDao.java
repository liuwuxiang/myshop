package com.lwx.my.shop.web.api.dao;

import com.lwx.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * 会员管理
 * <p>Title: TbUserDao</p>
 * <p>Description: </p>
 *
 * @author 刘武祥
 * @version 1.0.0
 * @date 2018/7/6 9:11
 */
@Repository
public interface TbUserDao {
    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
