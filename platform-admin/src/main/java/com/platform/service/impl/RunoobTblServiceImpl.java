package com.platform.service.impl;

import com.platform.dao.RunoobTblDao;
import com.platform.entity.RunoobTblEntity;
import com.platform.service.RunoobTblService;
import com.platform.utils.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 测试生成代码表Service实现类
 *
 * @author huangzhiqiang
 * @date 2019-01-19 20:46:46
 */
@Service("runoobTblService")
public class RunoobTblServiceImpl implements RunoobTblService {
    @Autowired
    private RunoobTblDao runoobTblDao;

    @Override
    public RunoobTblEntity queryObject(String id) {
        return runoobTblDao.queryObject(id);
    }

    @Override
    public List<RunoobTblEntity> queryList(Map<String, Object> map) {
        return runoobTblDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return runoobTblDao.queryTotal(map);
    }

    @Override
    public int save(RunoobTblEntity runoobTbl) {
        runoobTbl.setId(IdUtil.createIdbyUUID());
        return runoobTblDao.save(runoobTbl);
    }

    @Override
    public int update(RunoobTblEntity runoobTbl) {
        return runoobTblDao.update(runoobTbl);
    }

    @Override
    public int delete(String id) {
        return runoobTblDao.delete(id);
    }

    @Override
    public int deleteBatch(String[]ids) {
        return runoobTblDao.deleteBatch(ids);
    }
}
