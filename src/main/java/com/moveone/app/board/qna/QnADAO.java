package com.moveone.app.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moveone.app.board.BoardDAO;
import com.moveone.app.board.BoardDTO;
import com.moveone.app.board.BoardFileDTO;
import com.moveone.app.utils.Pager;

@Repository
public class QnADAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.moveone.app.board.notice.qna.QnADAO.";
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(namespace + "getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(namespace + "getDetail", boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(namespace + "setAdd", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(namespace + "setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(namespace + "setDelete", boardDTO);
	}

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(namespace + "getTotalCount", pager);
	}

	@Override
	public int setAddFile(BoardFileDTO fileDTO) throws Exception {
		return sqlSession.insert(namespace + "setAddFile", fileDTO);
	}

	@Override
	public List<BoardFileDTO> getFileList(BoardDTO boardDTO) {
		return sqlSession.selectList(namespace + "getFileList", boardDTO);
	}
	
	@Override
	public int setDeleteFiles(BoardDTO boardDTO) {
		return sqlSession.delete(namespace + "setDeleteFiles", boardDTO);
	}
	
	public int setUpdateStep(QnADTO parentDTO) {
		return sqlSession.update(namespace + "setUpdateStep", parentDTO);
	}
	
	public int setAddReply(QnADTO qnaDTO) {
		return sqlSession.insert(namespace + "setAddReply", qnaDTO);
	}



}
