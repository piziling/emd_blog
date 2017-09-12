package com.david.emdblog.service;

import java.util.List;

import com.david.emdblog.entity.BlogType;

/**
 * 博客,日志，文章类型
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public interface BlogTypeService {

	/**
	 * 查询所有博客类别以及对应的数量
	 */
	public  List<BlogType> countList();

}
