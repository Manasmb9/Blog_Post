package com.blog.post.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.entity.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveComment(Comment comment) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(comment);
	}

	
	public void deleteComment(Comment comment) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(comment);
	}


	public Comment getComment(int commentId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Comment.class, commentId);
	}
}
