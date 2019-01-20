package com.platform.controller;

import com.platform.entity.RunoobTblEntity;
import com.platform.service.RunoobTblService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 测试生成代码表Controller
 *
 * @author huangzhiqiang
 * @date 2019-01-19 20:46:46
 */
@Controller
@RequestMapping("runoobtbl")
public class RunoobTblController {
    @Autowired
    private RunoobTblService runoobTblService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("runoobtbl:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<RunoobTblEntity> runoobTblList = runoobTblService.queryList(query);
        int total = runoobTblService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(runoobTblList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("runoobtbl:info")
    @ResponseBody
    public R info(@PathVariable("id") String id) {
        RunoobTblEntity runoobTbl = runoobTblService.queryObject(id);

        return R.ok().put("runoobTbl", runoobTbl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("runoobtbl:save")
    @ResponseBody
    public R save(@RequestBody RunoobTblEntity runoobTbl) {
        runoobTblService.save(runoobTbl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("runoobtbl:update")
    @ResponseBody
    public R update(@RequestBody RunoobTblEntity runoobTbl) {
        runoobTblService.update(runoobTbl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("runoobtbl:delete")
    @ResponseBody
    public R delete(@RequestBody String[]ids) {
        runoobTblService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<RunoobTblEntity> list = runoobTblService.queryList(params);

        return R.ok().put("list", list);
    }
}
