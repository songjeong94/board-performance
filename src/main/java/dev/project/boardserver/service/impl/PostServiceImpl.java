package dev.project.boardserver.service.impl;

import dev.project.boardserver.dto.CommentDTO;
import dev.project.boardserver.dto.PostDTO;
import dev.project.boardserver.dto.TagDTO;
import dev.project.boardserver.dto.UserDTO;
import dev.project.boardserver.exception.BoardServerException;
import dev.project.boardserver.mapper.CommentMapper;
import dev.project.boardserver.mapper.PostMapper;
import dev.project.boardserver.mapper.TagMapper;
import dev.project.boardserver.mapper.UserProfileMapper;
import dev.project.boardserver.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private TagMapper tagMapper;


    @CacheEvict(value = "getPosts", allEntries = true)
    @Override
    public void register(String id, PostDTO postDTO) {
        UserDTO memberInfo = userProfileMapper.getUserProfile(id);
        postDTO.setUserId(memberInfo.getId());
        postDTO.setCreateTime(new Date());

        if (memberInfo != null) {
            try {
                postMapper.register(postDTO);
            } catch (RuntimeException e) {
                log.error("register 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("register ERROR! {}", postDTO);
            throw new RuntimeException("register ERROR! 상품 등록 메서드를 확인해주세요\n" + "Params : " + postDTO);
        }
    }

    @Override
    public List<PostDTO> getMyPosts(int accountId) {
        List<PostDTO> postDTOList = null;
        try {
            postDTOList = postMapper.selectMyPosts(accountId);
        } catch (RuntimeException e) {
            log.error("getMyPosts 실패");
            throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return postDTOList;
    }

    @Override
    public void updatePosts(PostDTO postDTO) {
        if (postDTO != null && postDTO.getId() != 0 && postDTO.getUserId() != 0) {
            try {
                postMapper.updatePosts(postDTO);
            } catch (RuntimeException e) {
                log.error("updatePosts 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("updatePosts ERROR! {}", postDTO);
            throw new RuntimeException("updatePosts ERROR! 물품 변경 메서드를 확인해주세요\n" + "Params : " + postDTO);
        }
    }

    @Override
    public void deletePosts(int userId, int productId) {
        if (userId != 0 && productId != 0) {
            try {
                postMapper.deletePosts(productId);
            } catch (RuntimeException e) {
                log.error("deleteProduct 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("deleteProudct ERROR! {}", productId);
            throw new RuntimeException("updatePosts ERROR! 물품 삭제 메서드를 확인해주세요\n" + "Params : " + productId);
        }
    }

    @Override
    public void registerComment(CommentDTO commentDTO) {
        if (commentDTO.getPostId() != 0) {
            try {
                commentMapper.register(commentDTO);
            } catch (RuntimeException e) {
                log.error("register 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("registerComment ERROR! {}", commentDTO);
            throw new RuntimeException("registerComment ERROR! 댓글 추가 메서드를 확인해주세요\n" + "Params : " + commentDTO);
        }
    }

    @Override
    public void updateComment(CommentDTO commentDTO) {
        if (commentDTO != null) {
            try {
                commentMapper.updateComment(commentDTO);
            } catch (RuntimeException e) {
                log.error("updateComments 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("updateComment ERROR! {}", commentDTO);
            throw new RuntimeException("updateComment ERROR! 댓글 변경 메서드를 확인해주세요\n" + "Params : " + commentDTO);
        }
    }

    @Override
    public void deletePostComment(int userId, int commentId) {
        if (userId != 0 && commentId != 0) {
            try {
                commentMapper.deletePostComment(commentId);
            } catch (RuntimeException e) {
                log.error("deletePostComment 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("deletePostComment ERROR! {}", commentId);
            throw new RuntimeException("deletePostComment ERROR! 댓글 삭제 메서드를 확인해주세요\n" + "Params : " + commentId);
        }
    }

    @Override
    public void registerTag(TagDTO tagDTO) {
        if (tagDTO.getPostId() != 0) {
            try {
                tagMapper.register(tagDTO);
            } catch (RuntimeException e) {
                log.error("register 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("registerTag ERROR! {}", tagDTO);
            throw new RuntimeException("registerTag ERROR! 태그 추가 메서드를 확인해주세요\n" + "Params : " + tagDTO);
        }
    }

    @Override
    public void updateTag(TagDTO tagDTO) {
        if (tagDTO != null) {
            try {
                tagMapper.updateTag(tagDTO);
            } catch (RuntimeException e) {
                log.error("updateTags 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("updateTag ERROR! {}", tagDTO);
            throw new RuntimeException("updateTag ERROR! 태그 변경 메서드를 확인해주세요\n" + "Params : " + tagDTO);
        }
    }

    @Override
    public void deletePostTag(int userId, int tagId) {
        if (userId != 0 && tagId != 0) {
            try {
                tagMapper.deletePostTag(tagId);
            } catch (RuntimeException e) {
                log.error("deletePostTag 실패");
                throw new BoardServerException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            log.error("deletePostTag ERROR! {}", tagId);
            throw new RuntimeException("deletePostTag ERROR! 태그 삭제 메서드를 확인해주세요\n" + "Params : " + tagId);
        }
    }
}