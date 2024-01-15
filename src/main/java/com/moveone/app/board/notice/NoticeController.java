package com.moveone.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.board.BoardDTO;
import com.moveone.app.board.BoardService;
import com.moveone.app.utils.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	@Qualifier("noticeService")
	private BoardService boardService;
	
	//@RequestMapping(value="list", method=RequestMethod.GET)
	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception {
		List<BoardDTO> list = boardService.getList(pager);
		
		model.addAttribute("list", list);
		model.addAttribute("title", "Notice");
		
		return "board/list";
	}
	
	@GetMapping("detail")
	public String getdetail(NoticeDTO noticeDto, Model model) throws Exception {
		NoticeDTO dto = (NoticeDTO) boardService.getDetail(noticeDto);
		
		model.addAttribute("dto", dto);
		model.addAttribute("title", "Notice");
		
		return "board/detail";
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(NoticeDTO noticeDTO, MultipartFile[] files) throws Exception {
		System.out.println(noticeDTO);
		int result = boardService.setAdd(noticeDTO, files);
		
		return "redirect:./list";
	}
}
