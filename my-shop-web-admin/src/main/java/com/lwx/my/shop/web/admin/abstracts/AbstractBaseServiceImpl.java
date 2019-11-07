package com.lwx.my.shop.web.admin.abstracts;

import com.lwx.my.shop.commons.dto.PageInfo;
import com.lwx.my.shop.commons.persistence.BaseDao;
import com.lwx.my.shop.commons.persistence.BaseEntity;
import com.lwx.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 刘武祥
 * @date 2019/9/2 0002 11:22
 */
public abstract class AbstractBaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    protected D dao;

    /**
     * 功能说明:查询全部数据
     *
     * @return java.util.List<T>
     * @author 刘武祥
     * @date 2019/8/27 0027 16:02
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 功能说明:删除用户信息
     *
     * @param id
     * @return void
     * @author 刘武祥
     * @date 2019/8/27 0027 16:02
     */
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    /**
     * 功能说明:根据 ID 获取信息
     *
     * @param id 获取信息的ID
     * @return T
     * @author 刘武祥
     * @date 2019/8/27 0027 16:02
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }

    /**
     * 功能说明:更新信息
     *
     * @param entity    实体类
     * @return void     无返回值
     * @author 刘武祥
     * @date 2019/8/27 0027 16:03
     */
    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    /**
     * 功能说明:批量删除
     *
     * @param ids   ID数组
     * @return void 无返回值
     * @author 刘武祥
     * @date 2019/8/27 0027 16:04
     */
    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);
    }

    /**
     * 功能说明:查询总笔数
     *
     * @param entity 实体类
     * @return int   返回的总笔数
     * @author 刘武祥
     * @date 2019/8/27 0027 16:05
     */
    @Override
    public int count(T entity) {
        return dao.count(entity);
    }

    /**
     * 功能说明:分页查询
     *
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return com.lwx.my.shop.commons.dto.PageInfo<T>
     * @author 刘武祥
     * @date 2019/8/27 0027 16:06
     */
    @Override
    public PageInfo<T> page(int start, int length, int draw, T entity) {
        int count = count(entity);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(params));

        return pageInfo;
    }
}
