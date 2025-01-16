package com.ssamz.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssamz.jblog.domain.Post;
import com.ssamz.jblog.persistence.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void insertPost(Post post) {
		post.setCnt(0);
		postRepository.save(post);
	}
	
	// 포스트 목록
	// Page를 이용하여 페이징 처리
	@Transactional(readOnly = true)
	public Page<Post> getPostList(Pageable pageable){
		return postRepository.findAll(pageable);
	}
	
	// 상세 정보 조회
	@Transactional(readOnly = true)
	public Post getPost(int id) {
		return postRepository.findById(id).get();
	}
	
	// 포스트 수정
	@Transactional
	public void updatePost(Post post) {
		Post findPost = postRepository.findById(post.getId()).get();
		findPost.setTitle(post.getTitle());
		findPost.setContent(post.getContent());
	}
	
	// 포스트 삭제
	@Transactional
	public void deletePost(int id) {
		postRepository.deleteById(id);
	}
}
