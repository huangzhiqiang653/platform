package com.platform.controller;

import com.alibaba.fastjson.JSON;
import com.platform.entity.SmsConfig;
import com.platform.entity.SysSmsLogEntity;
import com.platform.service.SysConfigService;
import com.platform.service.SysSmsLogService;
import com.platform.utils.ConfigConstant;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author lipengjun
 * @date 2017-12-16 23:38:05
 */
@RestController
@RequestMapping("/sys/smslog")
public class SysSmsLogController {
    @Autowired
    private SysSmsLogService smsLogService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = ConfigConstant.SMS_CONFIG_KEY;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:smslog:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SysSmsLogEntity> smsLogList = smsLogService.queryList(query);
        int total = smsLogService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(smsLogList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:smslog:info")
    public R info(@PathVariable("id") String id) {
        SysSmsLogEntity smsLog = smsLogService.queryObject(id);

        return R.ok().put("smsLog", smsLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:smslog:save")
    public R save(@RequestBody SysSmsLogEntity smsLog) {
        smsLogService.save(smsLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:smslog:update")
    public R update(@RequestBody SysSmsLogEntity smsLog) {
        smsLogService.update(smsLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:smslog:delete")
    public R delete(@RequestBody String[] ids) {
        smsLogService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<SysSmsLogEntity> list = smsLogService.queryList(params);

        return R.ok().put("list", list);
    }

    /**
     * 短信配置信息
     */
    @RequestMapping("/config")
    public R config() {
        SmsConfig config = sysConfigService.getConfigObject(KEY, SmsConfig.class);

        return R.ok().put("config", config);
    }

    /**
     * 保存短信配置信息
     */
    @RequestMapping("/saveConfig")
    @RequiresPermissions("sys:smslog:saveConfig")
    public R saveConfig(@RequestBody SmsConfig config) {
        sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config));
        return R.ok();
    }

    /**
     * 发送短信
     */
    @RequestMapping("/sendSms")
    @RequiresPermissions("sys:smslog:sendSms")
    public R sendSms(@RequestBody SysSmsLogEntity smsLog) {
        SysSmsLogEntity sysSmsLogEntity = smsLogService.sendSms(smsLog);
        return R.ok().put("result", sysSmsLogEntity);
    }
}
