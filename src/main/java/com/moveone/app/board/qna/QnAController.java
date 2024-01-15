package com.moveone.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moveone.app.board.BoardDTO;
import com.moveone.app.board.BoardService;
import com.moveone.app.utils.Pager;

@Controller
@RequestMapping(value="/qna/*")
public class QnAController {
	
	@Autowired
	@Qualifier("qnAService")
	private BoardService boardService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception {
		List<BoardDTO> list = boardService.getList(pager);
		model.addAttribute("list", list);
		
		return "board/list";
	}
}
