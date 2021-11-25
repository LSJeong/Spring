package co.lsj.hello.member.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import co.lsj.hello.member.service.MemberService;
import co.lsj.hello.member.service.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberDao;
	
	@GetMapping("/memberList.do")
	public String memberList(Model model) {
		model.addAttribute("members",memberDao.memberSelectList());  //request.setAttribute("members", memberDao.memberSelectList())와 같음
		return "member/memberList";
	}
	
	//member 관련 처리하는 모든것을 작성
	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO vo, Model model, HttpSession session) {
		String message;

		vo = memberDao.memberSelect(vo);
		
		if(vo != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			
			message = session.getAttribute("name") + " 님 환영합니다.";
		}else {
			message = "아이디 혹은 비밀번호를 확인하세요.";		
		}
		model.addAttribute("message",message);
		return "member/memberLogin";
	}
}
