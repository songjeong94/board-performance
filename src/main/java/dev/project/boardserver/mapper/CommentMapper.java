package dev.project.boardserver.mapper;

import dev.project.boardserver.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    public int register(CommentDTO commentDTO);
    public void updateComment(CommentDTO commentDTO);
    public void deletePostComment(int commentId);
}
