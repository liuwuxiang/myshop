package com.lwx.my.shop.web.admin.dao;

import com.lwx.my.shop.commons.persistence.BaseDao;
import com.lwx.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

/**
 * @author 刘武祥
 */
@Repository
public interface TbContentDao extends BaseDao<TbContent> {
    /**
     * 根据类目 ID 删除内容
     *
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}
