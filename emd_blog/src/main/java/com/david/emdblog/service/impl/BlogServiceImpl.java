package com.david.emdblog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.david.emdblog.dao.BlogDao;
import com.david.emdblog.entity.Blog;
import com.david.emdblog.service.BlogService;

/**
 * 博客，文章，日志的业务层
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */

@Service(value="blogService")
public class BlogServiceImpl implements BlogService{
	
	@Resource
	private BlogDao blogDao;
	
	/**
	 * 查看博客内容列表
	 */
	@Override
	public List<Blog> list(Map<String, Object> map) {
		return blogDao.list(map);
	}
	/**
	 * 查询博客的总数量
	 */
	@Override
	public long getTotal(Map<String, Object> map) {
		return blogDao.getTotal(map);
	}

}
