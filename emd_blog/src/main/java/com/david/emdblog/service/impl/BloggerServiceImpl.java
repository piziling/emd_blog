package com.david.emdblog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.david.emdblog.dao.BloggerDao;
import com.david.emdblog.entity.Blogger;
import com.david.emdblog.service.BloggerService;

/**
 * 博主，作者站长信息
 * 
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Service(value = "bloggerService")
public class BloggerServiceImpl implements BloggerService {

	@Resource
	private BloggerDao bloggerDao;

	/**
	 * 查看博主。站长。作者的信息
	 */
	@Override
	public Blogger findBloggerInfo() {
		return bloggerDao.find();
	}

	/**
	 * 根据用户名查找用户
	 */
	@Override
	public Blogger findBloggerByUsername(String userName) {
		return bloggerDao.findBloggerByUsername(userName);
	}

	/**
	 * 更新博主的信息
	 */
	@Override
	public int update(Blogger blogger) {
		return bloggerDao.update(blogger);
	}
}
