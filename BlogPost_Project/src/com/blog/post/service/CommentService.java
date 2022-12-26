package com.blog.post.service;

import com.blog.entity.Comment;

public interface CommentService {

	public void saveComment(int postId,Comment comment, int commentId);

	public void deleteComment(int id);

	public Comment getComment(int commentId);

}
