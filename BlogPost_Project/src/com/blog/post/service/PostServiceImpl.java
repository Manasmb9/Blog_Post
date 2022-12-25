package com.blog.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.blog.post.dao.PostDAO;
import com.blog.post.entity.Post;


@Service
public class PostServiceImpl implements PostService {

	
	@Autowired
	private PostDAO postDAO;
	
	@Override
	@Transactional
	public List<Post> getPosts() {
		
		
		return postDAO.getPosts();
	}


	@Override
	@Transactional
	public void savePost(Post thePost) {
		
		thePost.setIs_published(true);
		
		postDAO.savePost(thePost);
		
	}


	@Override
	@Transactional
	public Post getPost(int theId) {
		
		return postDAO.getPost(theId);
	}


	@Override
	@Transactional
	public void deletePost(int theId) {
		
		postDAO.deletePost(theId);
	}


}
