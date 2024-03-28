package dev.project.boardserver.service;

import dev.project.boardserver.dto.CategoryDTO;

public interface CategoryService {
    void register(String accountId, CategoryDTO categoryDTO);
    void update(CategoryDTO categoryDTO);
    void delete(int categoryId);
}
