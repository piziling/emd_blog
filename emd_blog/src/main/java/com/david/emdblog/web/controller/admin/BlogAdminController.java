package com.david.emdblog.web.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.david.emdblog.constant.JsonConstant;
import com.david.emdblog.entity.Blog;
import com.david.emdblog.lucene.BlogIndex;
import com.david.emdblog.service.BlogService;
import com.david.emdblog.utils.ResponseUtils;

import net.sf.json.JSONObject;

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
	// 博客索引
	private BlogIndex blogIndex = new BlogIndex();

	/**
	 * 添加或者修改文章信息。
	 */
	@RequestMapping("/save")
	public String save(Blog blog, HttpServletResponse response) throws Exception {
		int resultTotal = 0;// 操作的记录条数
		if (blog.getId() == null) {
			// 则说明是新增
			resultTotal = blogService.add(blog);
		} else {
			// 则说明是更新博客 更新文章
			resultTotal = blogService.update(blog);
			blogIndex.updateIndex(blog);// 更新文章索引
		}
		JSONObject jsonObject = new JSONObject();
		if (resultTotal > 0) {
			jsonObject.put(JsonConstant.SUCCESS, JsonConstant.TRUE);
		} else {
			jsonObject.put(JsonConstant.SUCCESS, JsonConstant.FALSE);
		}
		ResponseUtils.write(response, jsonObject);
		return null;
	}

}
