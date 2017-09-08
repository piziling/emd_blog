package com.david.emdblog.web.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 管理员进行登陆操作的controller
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */

import com.david.emdblog.service.BlogService;

@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	@Resource(name = "blogService")
	private BlogService blogService;

}
