package com.david.emdblog.web.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.david.emdblog.entity.Blog;
import com.david.emdblog.service.BlogService;

/**
 * 管理员界面。controller
 * 
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	@Resource(name = "blogService")
	private BlogService blogService;

	/**
	 * 添加或者修改文章信息。
	 */
	@RequestMapping("/save")
	public String save(Blog blog, HttpServletResponse response) {
		return null;
	}

}
