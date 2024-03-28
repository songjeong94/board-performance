package dev.project.boardserver.mapper;

import dev.project.boardserver.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    public int register(CategoryDTO categoryDTO);
    public void updateCategory(CategoryDTO categoryDTO);
    public void deleteCategory(int categoryId);
}
