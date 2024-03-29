package com.mycom.happy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.happy.dto.BoardDto;
import com.mycom.happy.dto.BoardFileDto;
import com.mycom.happy.dto.BoardParamDto;

@Mapper
public interface BoardDao {
	
	public BoardDto boardDetail(BoardParamDto boardParamDto);
	public List<BoardFileDto> boardDetailFileList(int boardId);
	
	// map - Dto
	public int boardUserReadCount(BoardParamDto boardParamDto); 
	
	// map - @param
	public int boardUserReadInsert( // 
			@Param("boardId") int boardId, 
			@Param("userSeq") int userSeq ); 
	
	public int boardReadCountUpdate(int boardId);
	
	
	public int boardDelete(int boardId);	
	public int boardFileDelete(int boardId);
	public List<String> boardFileUrlDeleteList(int boardId); // 실제로 저장된 url 가져옴
	public int boardReadCountDelete(int boardId); 
	
	public int boardInsert(BoardDto dto);
	public int boardFileInsert(BoardFileDto dto);
	
	public List<BoardDto> boardList(BoardParamDto boardParamDto);
	public int boardListTotalCount();
	
	public List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);
	public int boardListSearchWordTotalCount(BoardParamDto boardParamDto);	

	public int boardUpdate(BoardDto dto);
}
