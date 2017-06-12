/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.common.persistence;

import java.util.List;

import com.thinkgem.jeesite.sierac.entity.QueryReport;

/**
 * DAO支持类实现
 * 
 * @author ThinkGem
 * @version 2014-05-16
 * @param <T>
 */
public interface CrudDao<T> extends BaseDao {

    /**
     * 获取单条数据
     * 
     * @param id
     * @return
     */
    public T get(String id);

    /**
     * 获取单条数据
     * 
     * @param entity
     * @return
     */
    public T get(T entity);

    public List<T> findById(T entity);

    /**
     * 根据名称查id
     * 
     * @param name
     * @return
     */
    public List<T> findByname();

    /**
     * 根据名字查询对象
     * @param name
     * @return
     */
    public T findName(String name);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     * 
     * @param entity
     * @return
     */
    public List<T> findList(T entity);

    //出库单据根据状态查询
    public List<T> findListBillStatusready(T entity);
    public List<T> findListBillStatusnotready(T entity);

    /**
     * 根据仓库联表查询用户信息
     * 
     * @param entity
     * @return
     */
    public List<T> findListuser(T entity);

    public List<T> findListuserType(T entity);

    public List<T> findProductionTaskByProductId(T entity);

    /**
     * 增加user_rdcWarehouse表的操作
     * 
     */
    public int insertuserRdcwarehouse(String id, String userId);

    /**
     * 查询所有数据列表
     * 
     * @param entity
     * @return
     */
    public List<T> findAllList(T entity);

    /**
     * 查询所需要显示的数据
     * 
     * @param entity
     * @return
     */
    public List<T> findAll(T entity);

    public void updateAll(T entity);

    public T findByCode(String code);

    /**
     * 查询所有数据列表
     * 
     * @see public List<T> findAllList(T entity)
     * @return
     */
    @Deprecated
    public List<T> findAllList();

    /**
     * 插入数据
     * 
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * 更新数据
     * 
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * 
     * Description:批量更新 <br/>
     * 
     * @author majiaJun
     * @param list
     * @return
     */
    public void updateByMine(QueryReport queryReport);

    /**
     * 
     * Description: 清空数据表<br/>
     * 
     * @author mjj
     */
    public void truncate(String tableName);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     * 
     * @param id
     * @see public int delete(T entity)
     * @return
     */
    @Deprecated
    public int delete(String id);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     * 
     * @param entity
     * @return
     */
    public int delete(T entity);

}