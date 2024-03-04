package com.semi.bookrep.dao;

import java.util.List;

import com.semi.bookrep.dto.CommentDTO;

public interface CommentDao {

	List<CommentDTO> getCommentByReportId(Long id);

	void setComment(CommentDTO commentDTO);

}
