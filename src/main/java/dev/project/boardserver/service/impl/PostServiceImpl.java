package dev.project.boardserver.service.impl;

import dev.project.boardserver.dto.PostDTO;
import dev.project.boardserver.dto.UserDTO;
import dev.project.boardserver.mapper.PostMapper;
import dev.project.boardserver.mapper.UserProfileMapper;
import dev.project.boardserver.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserProfileMapper userProfileMapper;

    @Override
    public void register(String id, PostDTO postDTO) {
        UserDTO memberInfo = userProfileMapper.getUserProfile(id);
        postDTO.setUserId(memberInfo.getId());
        postDTO.setCreateTime(new Date());

        if (memberInfo != null) {
            postMapper.register(postDTO);
        } else {
            log.error("register Error! {}", postDTO);
            throw new RuntimeException("register Error! 게시글 등록 메서드를 확인해 주세요 " + postDTO);
        }
    }

    @Override
    public List<PostDTO> getMyPosts(int accountId) {
        List<PostDTO> postDTOList = postMapper.selectMyPosts(accountId);
        return postDTOList;
    }

    @Override
    public void updatePosts(PostDTO postDTO) {
        if(postDTO != null && postDTO.getId() !=0) {
            postMapper.updatePosts(postDTO);
        } else {
            log.error("update posts Error! {}", postDTO);
            throw new RuntimeException("update posts Error! 게시글 수정 메서드를 확인해 주세요 " + postDTO);
        }
    }

    @Override
    public void deletePosts(int userId, int postId) {
        if (userId != 0 && postId != 0) {
            postMapper.deletePosts(postId);
        } else {
            log.error("delete posts Error! {}", postId);
            throw new RuntimeException("delete posts Error! 게시글 등록 메서드를 확인해 주세요 " + postId);
        }
    }
}
