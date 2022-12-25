package com.blog.post.service;

import java.util.List;

import com.blog.post.entity.Post;

public interface PostService {
	
	public List<Post> getPosts();

	public void savePost(Post thePost);
	
	public Post getPost(int theId);

	public void deletePost(int theId);

}
