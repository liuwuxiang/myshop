package com.lwx.my.shop.commons.persistence;

import com.lwx.my.shop.commons.dto.BaseResult;
import com.lwx.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层的基类
 * <p>Title: BaseService</p>
 * <p>Description: </p>
 *
 * @author 刘武祥
 * @version 1.0.0
 * @date 2018/6/28 11:55
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 功能说明:查询全部数据
     *
     * @return java.util.List<T>
     * @author 刘武祥
     * @date 2019/8/27 0027 16:02
     */
    public List<T> selectAll();

    /**
     * 保存信息
     * @param entity
     * @return
     */
    BaseResult save(T entity);

    /**
     * 删除用户信息
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 ID 获取信息
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新信息
     * @param entity
     */
    void update(T entity);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 查询总笔数
     * @return
     */
    int count(T entity);
}
