package org.sid.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sid.demo.dto.CommentsDto;
import org.sid.demo.model.Comment;
import org.sid.demo.model.Post;
import org.sid.demo.model.User;

@Mapper(componentModel = "spring")
public interface CommentMapper {
@Mapping(target = "id", ignore = true)
@Mapping(target = "text", source = "commentsDto.text")
@Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
@Mapping(target = "post", source = "post")
Comment map(CommentsDto commentsDto, Post post, User user);
@Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
@Mapping(target = "userName", expression = "java(comment.getUser().getUsername())")
CommentsDto mapToDto(Comment comment);
}