package com.niit.choco.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.niit.choco.model.BlogComment;
@Repository
@ComponentScan("com.nik")
public interface BlogCommentDao {

	void addComment(BlogComment blogComment);
	List<BlogComment> viewComments(String blogid);
}
