package dev.project.boardserver.service;

import dev.project.boardserver.dto.PostDTO;
import dev.project.boardserver.dto.request.PostSearchRequest;

import java.util.List;

public interface PostSearchService {
    List<PostDTO> getPosts(PostSearchRequest postSearchRequest);
}
