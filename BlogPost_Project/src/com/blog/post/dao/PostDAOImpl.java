package com.blog.post.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.entity.Post;

@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override

	public List<Post> getPosts() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Post> theQuery = currentSession.createQuery("from Post", Post.class);

		List<Post> posts = theQuery.getResultList();

		return posts;
	}

	@Override
	public void savePost(Post thePost) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(thePost);

	}

	@Override
	public Post getPost(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Post thePost = currentSession.get(Post.class, theId);

		return thePost;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deletePost(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Post post = currentSession.get(Post.class, theId);
		currentSession.delete(post);

//		Session currentSession = sessionFactory.getCurrentSession();
//
//		Query theQuery = currentSession.createQuery("delete from Post where id=:postId");
//
//		theQuery.setParameter("postId", theId);
//
//		theQuery.executeUpdate();

	}

	@Override
	public List<Post> searchPosts(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Post> theQuery = null;

		if (theSearchName != null && theSearchName.trim().length() > 0) {

			theQuery = currentSession.createQuery("from Post where lower(title) like :theTitle", Post.class);

			theQuery.setParameter("theTitle", "%" + theSearchName.toLowerCase() + "%");
		} else {

			theQuery = currentSession.createQuery("from Post", Post.class);
		}

		List<Post> posts = theQuery.getResultList();

		return posts;

	}

}
