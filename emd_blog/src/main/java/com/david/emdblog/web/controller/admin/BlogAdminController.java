package com.david.emdblog.web.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.david.emdblog.constant.Constants;
import com.david.emdblog.constant.JsonConstant;
import com.david.emdblog.entity.Blog;
import com.david.emdblog.entity.Comment;
import com.david.emdblog.entity.PageBean;
import com.david.emdblog.lucene.BlogIndex;
import com.david.emdblog.service.BlogService;
import com.david.emdblog.utils.ResponseUtils;
import com.david.emdblog.utils.UtilFuns;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

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
//	http://localhost/Blog/static/ueditor/jsp/controller.jsp?action=config&&noCache=1505793074364
//	http://localhost:18080/Blog/static/ueditor/jsp/controller.jsp?action=config&&noCache=1505792914168	
	/**
	 * UE添加或者修改文章信息。
	 */
	@RequestMapping("/save")
	public String save(Blog blog, HttpServletResponse response) throws Exception {
		int resultTotal = 0;// 操作的记录条数
		if (blog.getId() == null) {
			// 则说明是新增
			resultTotal = blogService.add(blog);
			blogIndex.addIndex(blog);//添加博客索引
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
	/**
	 * Markdown语法添加或者修改文章信息。
	 */
	@RequestMapping("/saveMarkdownBlog")
	public String saveMarkdownBlog(Blog blog, HttpServletResponse response) throws Exception {
		int resultTotal = 0;// 操作的记录条数
		if (blog.getId() == null) {
			// 则说明是新增
			resultTotal = blogService.add(blog);
			blogIndex.addIndex(blog);//添加博客索引
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

	/**
	 * 分页查询所有的文章博客 文章列表展示时。搜索：s_blog
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, Blog s_blog, HttpServletResponse response)
					throws Exception {
		if (UtilFuns.isEmpty(page) || UtilFuns.isEmpty(page.trim())) {
			page = "1";
		}
		if (UtilFuns.isEmpty(rows) || UtilFuns.isEmpty(rows.trim())) {
			rows = Constants.PAGE_SIZE + "";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		/**
		 * 这个地方设置具体的javabean的类型，不然会报类型转换错误
		 */
		map.put("start", pageBean.getStart());// 起始页
		map.put("size", pageBean.getPageSize());
		map.put("title", UtilFuns.formatLike(s_blog.getTitle()));
		List<Blog> blogList = blogService.list(map);// 获取文章的列表
		Long total = blogService.getTotal(map);// 获取文章的总数量
		JSONObject jsonObject = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		// 因为有日期，所以转换一下
		JSONArray jsonArray = JSONArray.fromObject(blogList, jsonConfig);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtils.write(response, jsonObject);
		return null;
	}

	/**
	 * 根据ID查找实例
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value = "id", required = true) String id, HttpServletResponse response)
			throws Exception {
		Blog blog = blogService.findById(Integer.parseInt(id));
		JSONObject jsonObject = JSONObject.fromObject(blog);
		ResponseUtils.write(response, jsonObject);
		return null;
	}

	/**
	 * 根据ID删除实例.因为可能批量删除，所以用数组
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids", required = true) String ids, HttpServletResponse response)
			throws Exception {
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			blogService.deleteById(Integer.parseInt(idsStr[i]));
			blogIndex.deleteIndex(idsStr[i]);// 删除对应的博客的索引
		}
		JSONObject jsonObject = new JSONObject();
		// 操作成功
		jsonObject.put(JsonConstant.SUCCESS, JsonConstant.TRUE);
		ResponseUtils.write(response, jsonObject);
		return null;
	}

}
