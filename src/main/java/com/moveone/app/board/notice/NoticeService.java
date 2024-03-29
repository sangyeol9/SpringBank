package com.moveone.app.board.notice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.board.BoardDAO;
import com.moveone.app.board.BoardDTO;
import com.moveone.app.board.BoardFileDTO;
import com.moveone.app.board.BoardService;
import com.moveone.app.utils.FileManager;
import com.moveone.app.utils.Pager;
import com.moveone.app.utils.TagChanger;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private BoardDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;


	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeBlock(totalCount);
		
		return noticeDAO.getList(pager);
		
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		boardDTO.setNoticeTitle(TagChanger.tagChange(boardDTO.getNoticeTitle()));
		
		int result = noticeDAO.setAdd(boardDTO);
		String path = servletContext.getRealPath("/resources/upload/notice");

		if(files == null) {
			return result;
		}
		
		for (MultipartFile file : files) {
			if (file.isEmpty())
				continue;

			String filename = fileManager.fileSave(file, path);

			BoardFileDTO fileDTO = new BoardFileDTO();
			fileDTO.setFileName(filename);
			fileDTO.setOriName(file.getOriginalFilename());
			fileDTO.setNoticeNum(boardDTO.getNoticeNum());

			noticeDAO.setAddFile(fileDTO);
		}

		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		//파일을 저장
		
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// DB에서 파일 조회
		List<BoardFileDTO> files = noticeDAO.getFileList(boardDTO);

		// 파일 삭제
		String path = servletContext.getRealPath("/resources/upload/notice");
		for (BoardFileDTO file : files) {
			fileManager.fileDelete(file.getFileName(), path);
		}

		// 글 삭제
		int result = noticeDAO.setDelete(boardDTO);
		System.out.println("delete : " + result);

		return result;
	}

}
