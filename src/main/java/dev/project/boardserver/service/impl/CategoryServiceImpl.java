package dev.project.boardserver.service.impl;

import dev.project.boardserver.dto.CategoryDTO;
import dev.project.boardserver.mapper.CategoryMapper;
import dev.project.boardserver.service.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void register(String accountId, CategoryDTO categoryDTO) {
        if (accountId != null) {
            categoryMapper.register(categoryDTO);
        } else {
            log.error("register Error! {}", categoryDTO);
            throw new RuntimeException("register Error! 게시글 카테고리 등록 메서드를 확인해 주세요 " + categoryDTO);
        }
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        if (categoryDTO != null) {
            categoryMapper.updateCategory(categoryDTO);
        } else {
            log.error("update Error! {}", categoryDTO);
            throw new RuntimeException("update Error! 게시글 카테고리 수정 메서드를 확인해 주세요 " + categoryDTO);
        }
    }

    @Override
    public void delete(int categoryId) {
        if (categoryId != 0) {
            categoryMapper.deleteCategory(categoryId);
        } else {
            log.error("delete Error! {}", categoryId);
            throw new RuntimeException("delete Error! 게시글 카테고리 삭제 메서드를 확인해 주세요 " + categoryId);
        }
    }
}
