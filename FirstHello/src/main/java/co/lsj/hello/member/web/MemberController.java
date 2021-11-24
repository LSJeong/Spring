package co.lsj.hello.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	@GetMapping("/memberList.do")
	public String memberList(Model model) {
		model.addAttribute("message","멤버 리스트입니다.");  //request.setAttribute("members", memberDao.memberSelectList())와 같음
		return "member/memberList";
	}
	
	//member 관련 처리하는 모든것을 작성
}
