package com.david.emdblog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.david.emdblog.dao.BlogTypeDao;
import com.david.emdblog.entity.BlogType;
import com.david.emdblog.service.BlogTypeService;
/**
 * 博客，文章类型
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Service(value="blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
	
	@Resource
	private BlogTypeDao blogTypeDao;
	/**
	 * 查询所有博客类别以及对应的数量
	 */
	@Override
	public List<BlogType> countList() {
		return blogTypeDao.countList();
	}

}
