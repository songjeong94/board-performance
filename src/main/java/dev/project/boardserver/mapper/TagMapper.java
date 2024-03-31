package dev.project.boardserver.mapper;

import dev.project.boardserver.dto.TagDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {

    public int register(TagDTO tagDTO);
    public void updateTag(TagDTO tagDTO);
    public void deletePostTag(int tagId);
    public void createPostTag(Integer tagId, Integer postId);
}
