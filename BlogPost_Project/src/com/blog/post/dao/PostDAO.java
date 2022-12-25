package com.blog.post.dao;

import java.util.List;

import com.blog.post.entity.Post;

public interface PostDAO {

	public List<Post> getPosts();

	public void savePost(Post thePost);

	public Post getPost(int theId);

	public void deletePost(int theId);	
}
