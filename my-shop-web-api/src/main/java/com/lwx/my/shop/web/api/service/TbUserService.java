package com.lwx.my.shop.web.api.service;

import com.lwx.my.shop.domain.TbUser;

/**
 * 会员管理
 * <p>Title: TbUserService</p>
 * <p>Description: </p>
 *
 * @author 刘武祥
 * @version 1.0.0
 * @date 2018/7/6 9:12
 */
public interface TbUserService {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
