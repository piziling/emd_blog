package com.david.emdblog.service;

import com.david.emdblog.entity.Blogger;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public interface BloggerService {
	/**
	 * 查询博主信息
	 */
	Blogger findBloggerInfo();
	/**
	 * 根据用户名查找用户
	 */
	Blogger findBloggerByUsername(String userName);

	
}
