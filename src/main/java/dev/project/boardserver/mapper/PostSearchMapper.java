package dev.project.boardserver.mapper;

import dev.project.boardserver.dto.PostDTO;
import dev.project.boardserver.dto.request.PostSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostSearchMapper {

    public List<PostDTO> selectPosts(PostSearchRequest postSearchRequest);

}
