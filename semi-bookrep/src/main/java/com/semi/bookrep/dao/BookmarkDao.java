package com.semi.bookrep.dao;

import com.semi.bookrep.dto.BookmarkDTO;

public interface BookmarkDao {

	int isBookmark(BookmarkDTO bookmarkDTO);

	void setBookmark(BookmarkDTO bookmarkDTO);

	void removeBookmark(BookmarkDTO bookmarkDTO);


}
