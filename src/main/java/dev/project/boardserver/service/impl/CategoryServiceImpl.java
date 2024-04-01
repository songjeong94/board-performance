package dev.project.boardserver.service.impl;

import dev.project.boardserver.dto.CategoryDTO;
import dev.project.boardserver.exception.BoardServerException;
import dev.project.boardserver.mapper.CategoryMapper;
import dev.project.boardserver.service.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void register(String accountId, CategoryDTO categoryDTO) {
        if (accountId != null) {
            try {
                categoryMapper.register(categoryDTO);
            } catch (RuntimeException e) {
                log.error("register Error! {}", categoryDTO);
                throw new RuntimeException("register Error! 게시글 카테고리 등록 메서드를 확인해 주세요 " + categoryDTO);

            }
        } else {
            log.error("register Error! {}", categoryDTO);
            throw new RuntimeException("register Error! 게시글 카테고리 등록 메서드를 확인해 주세요 " + categoryDTO);
        }
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        if (categoryDTO != null && categoryDTO.getName() == null) {
            try {
                categoryMapper.updateCategory(categoryDTO);
            } catch (RuntimeException e) {
                log.error("update 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("update ERROR! {}", categoryDTO);
            throw new RuntimeException("update ERROR! 물품 카테고리 변경 메서드를 확인해주세요\n" + "Params : " + categoryDTO);
        }
    }

    @Override
    public void delete(int categoryId) {
        if (categoryId != 0) {
            try {
                categoryMapper.deleteCategory(categoryId);
            } catch (RuntimeException e) {
                log.error("delete 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("deleteCategory ERROR! {}", categoryId);
            throw new RuntimeException("deleteCategory ERROR! 물품 카테고리 삭제 메서드를 확인해주세요\n" + "Params : " + categoryId);
        }
    }
}