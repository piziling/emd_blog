package com.david.emdblog.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.david.emdblog.service.BlogService;
import com.david.emdblog.service.CommentService;

/**
 * 评论的功能。
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Resource(name="commentService")
	private CommentService commentService;
	
	@Resource(name="blogService")
	private BlogService blogService;
	
	
}
