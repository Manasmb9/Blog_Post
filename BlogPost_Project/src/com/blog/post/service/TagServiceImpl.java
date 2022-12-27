package com.blog.post.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Tag;
import com.blog.post.dao.TagDAO;

@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagDAO tagDAO;

	@Override
	@Transactional
	public Map<Tag, String> getTags() {
		
		List<Tag> tags = tagDAO.getTags();
		Map<Tag, String> tagOptions = new LinkedHashMap<>();
		for(Tag tag : tags) {
			tagOptions.put(tag, tag.getName());
		}
		System.out.println(tagOptions);
		return tagOptions;
	}

}
