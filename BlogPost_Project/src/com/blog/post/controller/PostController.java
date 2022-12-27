package com.blog.post.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.Tag;
import com.blog.post.service.CommentService;
import com.blog.post.service.PostService;
import com.blog.post.service.TagService;

@Controller
@RequestMapping("/post")
public class PostController {

	// need to inject the customer dao
	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private TagService tagService;

	@RequestMapping("/list")
	public String Posts(Model theModel) {

		List<Post> thePosts = postService.getPosts();

		theModel.addAttribute("post", thePosts);

		return "list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Post thePost = new Post();
		
		Map<Tag, String> tagOptions = tagService.getTags();

		theModel.addAttribute("post", thePost);
		
		theModel.addAttribute("tagOptions", tagOptions);

//		System.out.println(theModel);

		return "post-form";
	}

	@PostMapping("/savePost")
	public String savePost(@ModelAttribute("post") Post thePost, int postId) {

		postService.savePost(thePost, postId);

		return "redirect:/post/list";
	}

	@GetMapping("/showFormForView")
	public String showFormForView(@RequestParam("postId") int theId, Model theModel) {

		Post thePost = postService.getPost(theId);

		theModel.addAttribute("post", thePost);

		return "content-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("postId") int theId, Model theModel) {

		Post thePost = postService.getPost(theId);

		theModel.addAttribute("post", thePost);

		return "post-form";
	}

	@GetMapping("/delete")
	public String deletePost(@RequestParam("postId") int theId, Model theModel) {

		postService.deletePost(theId);

		return "redirect:/post/list";
	}

	@RequestMapping("/addcomment")
	public String addComment(@RequestParam("postId") int postId, Model theModel) {

		Comment comment = new Comment();

		theModel.addAttribute("comment", comment);

		return "add-comment";
	}

	@RequestMapping("/savecomment")
	public String saveComment(Model theModel, @ModelAttribute("comment") Comment comment,
			@RequestParam("postId") int postId, @RequestParam("commentId") int commentId) {

		System.out.println(postId);
		commentService.saveComment(postId, comment, commentId);
		Post post = postService.getPost(postId);
		theModel.addAttribute("post", post);
		return "post-form";
	}

	@RequestMapping("/deletecomment")
	public String deleteComment(Model theModel, @RequestParam("commentId") int commentId,
			@RequestParam("postId") int postId) {

		commentService.deleteComment(commentId);

		theModel.addAttribute(postService.getPost(postId));

		return "post-form";
	}

	@RequestMapping("/editcomment")
	public String editComment(Model theModel, @RequestParam("commentId") int commentId,
			@RequestParam("postId") int postId) {

		theModel.addAttribute("comment", commentService.getComment(commentId));
		return "add-comment";
	}

	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		// search customers from the service
		List<Post> thePosts = postService.searchPost(theSearchName);

		// add the customers to the model
		theModel.addAttribute("post", thePosts);
		return "list";
	}
}
