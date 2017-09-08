package com.david.emdblog.dao;

import com.david.emdblog.entity.BlogType;

/**
 * 博客类型Dao接口
 * 
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public interface BlogTypeDao {
	/**
	 * 根据ID查询博客类型
	 */
	public BlogType findById(Integer id);
}
