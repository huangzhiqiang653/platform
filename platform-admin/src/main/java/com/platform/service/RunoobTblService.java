package com.platform.service;

import com.platform.entity.RunoobTblEntity;

import java.util.List;
import java.util.Map;

/**
 * 测试生成代码表Service接口
 *
 * @author huangzhiqiang
 * @date 2019-01-19 20:46:46
 */
public interface RunoobTblService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    RunoobTblEntity queryObject(String id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<RunoobTblEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param runoobTbl 实体
     * @return 保存条数
     */
    int save(RunoobTblEntity runoobTbl);

    /**
     * 根据主键更新实体
     *
     * @param runoobTbl 实体
     * @return 更新条数
     */
    int update(RunoobTblEntity runoobTbl);

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 删除条数
     */
    int delete(String id);

    /**
     * 根据主键批量删除
     *
     * @param id 主键数组
     * @return 删除条数
     */
    int deleteBatch(String[] ids);
}
