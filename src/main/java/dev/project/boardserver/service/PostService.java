package dev.project.boardserver.service;

import dev.project.boardserver.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface PostService {

    void register(String id, PostDTO postDTO);
    List<PostDTO> getMyPosts(int accountId);
    void updatePosts(PostDTO postDTO);
    void deletePosts(int userId, int postId);
}
