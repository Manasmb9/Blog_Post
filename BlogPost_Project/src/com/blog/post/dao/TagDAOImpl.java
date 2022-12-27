package com.blog.post.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.entity.Tag;

@Repository
public class TagDAOImpl implements TagDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tag> getTags() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Tag> theQuery = currentSession.createQuery("from Tag", Tag.class);
		List<Tag> tags = theQuery.getResultList();
		return tags;
		
	}

}
