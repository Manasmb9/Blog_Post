package com.blog.post.dao;

import com.blog.entity.Comment;

public interface CommentDAO {


	public void saveComment(Comment comment);

	public void deleteComment(Comment comment);

	public Comment getComment(int commentId);
}
