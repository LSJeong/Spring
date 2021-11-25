package co.lsj.hello.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.lsj.hello.notice.service.NoticeService;
import co.lsj.hello.notice.service.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeDao; //noticeImpl을 자동 주입
	
	@RequestMapping("/noticeList.do")  //게시글 목록보기
	public String noticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList());
		return "notice/noticeList";
	}
	
	@RequestMapping("/noticeSelect.do")
	public String noticeSelect(Model model) {
		
		return "redirect:memberList.do";  //jsp를 호출하지않고 .do를 호출하고싶을때 redirect: 키워드 사용
	}
	
	@RequestMapping("/noticeForm.do")
	public String noticeForm() {
		return "notice/noticeForm";
	}
	
//	@PostMapping("/noticeResister.do")
//	//form 정보 넘길때 request로 받지않고 vo로 받을수있다, request나 session 필요하면 넣으면 가능
//	//vo에 자동으로 담아준다. vo에 없는거 받고싶을때 Param으로 받을수있다. @Param("bigo") String bigo
//	//타입도 알아서 변환해서 넣어줌..
//	public String noticeResister(NoticeVO vo, Model model, HttpSession session) {
//		System.out.println(vo.getBigo());
//		System.out.println(vo.getTitle());
//		noticeDao.noticeInsert(vo);
//		return "redirect:noticeList.do";
//	}
	
	//ModelAndView mv 쓸때는 mv.addObject("",값), mv.setViewName(""); 형식으로 쓸수있다.
	//성공과 실패에 따라 페이지 달라질때 쓸수있음, mv로 메세지랑 뷰페이지 한번에 넘김
	@PostMapping("/noticeResister.do")
	public ModelAndView noticeResister(NoticeVO vo, ModelAndView mv){
		if(vo != null) {
			mv.addObject("messga", "성공");
			mv.setViewName("notice/noticeSuccess");			
		}else {
			mv.addObject("messga", "실패");
			mv.setViewName("notice/noticeFail");	
		}
		return mv;
	}
	/*   ^
		위아래 같음..model(밑에꺼)를 더 많이씀
	     v*/
	@PostMapping("/noticeR.do")
	public String noticeResister(NoticeVO vo, Model model) {
		String path = null;
		if(vo != null) {
			model.addAttribute("messga", "성공");
			path = "notice/Success";
		}else {
			model.addAttribute("messga", "실패");
			path = "notice/noticeFail";
		}
		return path;
	}
}
