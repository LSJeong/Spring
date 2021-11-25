package co.lsj.hello.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import co.lsj.hello.notice.service.NoticeMapper;
import co.lsj.hello.notice.service.NoticeService;
import co.lsj.hello.notice.service.NoticeVO;

// 3개 동일하게 사용 가능, 일반적으로 Service 많이씀
//@Repository("noticeDao")
 @Service("noticeDao") 
// @Component("noticeDao") 
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper map;  //Autowired 한행에만 적용, 이 밑에 한줄 더 적는다고해서 더 적용x
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	@Override
	public List<NoticeVO> noticeSearchList(String searchKey) {
		return map.noticeSearchList(searchKey);
	}

}
