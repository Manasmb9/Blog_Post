package com.blog.post.service;

import java.util.List;

import com.blog.entity.Post;

public interface PostService {

	public List<Post> getPosts();

	public void savePost(Post thePost, int postId);

	public Post getPost(int theId);

	public void deletePost(int theId);

	public List<Post> searchPost(String theSearchName);

}
