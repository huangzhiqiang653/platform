# 创建短信发送记录表
DROP TABLE IF EXISTS `sys_sms_log`;
CREATE TABLE `sys_sms_log` (
  `id` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键',
  `user_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '操作人',
  `content` text COLLATE utf8_unicode_ci COMMENT '必填参数。发送内容（1-500 个汉字）UTF-8编码',
  `mobile` text COLLATE utf8_unicode_ci COMMENT '必填参数。手机号码。多个以英文逗号隔开',
  `stime` datetime DEFAULT NULL COMMENT '可选参数。发送时间，填写时已填写的时间发送，不填时为当前时间发送',
  `sign` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '必填参数。用户签名',
  `type` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '必填参数。固定值 pt',
  `extno` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '可选参数。扩展码，用户定义扩展码，只能为数字',
  `send_status` int(11) DEFAULT NULL COMMENT '1成功 0失败',
  `send_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发送编号',
  `invalid_num` int(11) DEFAULT NULL COMMENT '无效号码数',
  `success_num` int(11) DEFAULT NULL COMMENT '成功提交数',
  `black_num` int(11) DEFAULT NULL COMMENT '黑名单数',
  `return_msg` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '返回消息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
# 添加菜单
INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num, domain_id, status, create_user, create_time, update_user, update_time) VALUES ('04', '0', '短信平台', null, null, 0, 'fa fa-television', 4, '735e3dd6bb4f4a9191a66761d6g73918', 1, '1', '2017-12-16 23:42:22', '1', '2017-12-17 11:55:56');
INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num, domain_id, status, create_user, create_time, update_user, update_time) VALUES ('0401', '04', '短信配置', 'sys/smslog.html', null, 1, 'fa fa-envelope-open', 2, '735e3dd6bb4f4a9191a66761d6g73918', 1, '1', '2017-12-16 23:45:35', '1', '2017-12-17 11:56:26');
INSERT INTO sys_menu (menu_id, parent_id, name, url, perms, type, icon, order_num, domain_id, status, create_user, create_time, update_user, update_time) VALUES ('040101', '0401', '查看', null, 'sys:smslog:list,sys:smslog:info', 2, null, 0, '735e3dd6bb4f4a9191a66761d6g73918', 1, '1', '2017-12-16 23:46:10', null, null);
# 短信配置
INSERT INTO sys_config (id, conf_key, conf_value, status, remark) VALUES ('2', 'SMS_CONFIG_KEY', '{"domain":"http://web.cr6868.com/asmx/smsservice.aspx?","name":"","pwd":"","sign":"","type":1}', 0, '短信配置');