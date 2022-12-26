package com.blog.post.service;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Post;
import com.blog.post.dao.PostDAO;


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
	public Post getPost(int theId) {
		
		return postDAO.getPost(theId);
	}


	@Override
	@Transactional
	public void deletePost(int theId) {
		
		postDAO.deletePost(theId);
	}




	@Override
	@Transactional
	public void savePost(Post post,int postId) {

		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		if(postId != 0) {
			
			Post existingPost = getPost(postId);
			existingPost.setTitle(post.getTitle());
			existingPost.setContent(post.getContent());
			existingPost.setUpdated_at(currentDate);
			existingPost.setExcerpt(post.getExcerpt());
			existingPost.setAuthor(post.getAuthor());
			postDAO.savePost(existingPost);
		}
		else {
			
			post.setPublished_at(currentDate);
			
			if(post.getCreated_at()==null) {
				
				post.setCreated_at(currentDate);
			}
			post.setIs_published(true);
			post.setUpdated_at(currentDate);
			
			postDAO.savePost(post);
		}
	}

}
