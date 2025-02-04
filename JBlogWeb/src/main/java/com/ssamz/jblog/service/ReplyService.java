package com.ssamz.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssamz.jblog.domain.Post;
import com.ssamz.jblog.domain.Reply;
import com.ssamz.jblog.domain.User;
import com.ssamz.jblog.persistence.PostRepository;
import com.ssamz.jblog.persistence.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	// 댓글 등록
	@Transactional
	public void insertReply(int postId, Reply reply, User user) {
		Post post = postRepository.findById(postId).get();	// 포스트 일련번호 가져오기
		reply.setUser(user);
		reply.setPost(post);
		replyRepository.save(reply);
	}
	// 댓글 삭제
	@Transactional
	public void deleteReply(int replyId) {
		replyRepository.deleteById(replyId);
	}
}
