package com.semi.bookrep.dao;

import com.semi.bookrep.dto.LikeDTO;

public interface LikeDao {

   Integer getLikeValueByReportId(Long id);

   void setLike(LikeDTO likeDTO);
   
   void removeLike(LikeDTO likeDTO);

}