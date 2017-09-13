package com.david.emdblog.lucene;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.david.emdblog.entity.Blog;
import com.david.emdblog.utils.DateUtil;

/**
 * 博客索引类
 * 
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class BlogIndex {

	private Directory directory = null;

	/**
	 * 获取IndexWriter实例
	 */

	private IndexWriter getWriter() throws Exception {
		directory = FSDirectory.open(Paths.get("C://lucene"));
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
		return indexWriter;
	}

	/**
	 * 更新文章博客索引
	 */
	public void updateIndex(Blog blog) throws Exception {
		IndexWriter writer = getWriter();
		Document document = new Document();
		document.add(new StringField("id", String.valueOf(blog.getId()), Field.Store.YES));
		document.add(new TextField("title", blog.getTitle(), Field.Store.YES));
		document.add(new StringField("releaseDate", DateUtil.formatDate(new Date(), "yyyy-MM-dd"), Field.Store.YES));
		document.add(new TextField("content", blog.getContentNoTag(), Field.Store.YES));
		writer.addDocument(document);
		if (writer!=null) {
			writer.close();
		}
	}

}
