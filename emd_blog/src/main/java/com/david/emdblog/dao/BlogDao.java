package com.david.emdblog.dao;

import java.util.List;
import java.util.Map;

import com.david.emdblog.entity.Blog;

/**
 * 博客的持久层
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public interface BlogDao {
	/**
	 * 分页查询博客
	 */
	public List<Blog> list(Map<String, Object> map);
	/**
	 * 获取博客总数量
	 */
	public long getTotal(Map<String, Object> map);

}
