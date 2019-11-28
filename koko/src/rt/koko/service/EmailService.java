package rt.koko.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import rt.koko.DAO.EmailDAO;
import rt.koko.domain.EmailDeleteDo;
import rt.koko.domain.EmailDo;
import rt.koko.domain.EmailListDo;
import rt.koko.domain.EmailListSearchDo;

public class EmailService {
	private static EmailService emailService = new EmailService();
	private static EmailDAO dao;
	private static final int PAGE_SIZE = 5;
	
	public static EmailService getInstance() {
		dao = EmailDAO.getInstance();
		return emailService;
	}
	
	public int emailInsertService(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, new DefaultFileRenamePolicy());
		EmailDo email = new EmailDo();
		
		email.setE_receipt(multi.getParameter("e_receipt"));
		email.setE_title(multi.getParameter("e_title"));
		email.setE_contents(multi.getParameter("e_contents"));
		
		String to = email.getE_receipt();
		String subject = email.getE_title();
		String content = email.getE_contents();
		// 입력값 받음
		 
		Properties p = new Properties(); // 정보를 담을 객체
	    PrintWriter out = response.getWriter();
	    
		p.put("mail.smtp.host","smtp.naver.com"); // 네이버 SMTP		 
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		// SMTP 서버에 접속하기 위한 정보들
		 
		try{
		    Authenticator auth = new SMTPAuthenticator();
		    Session ses = Session.getInstance(p, auth);
		    
		    ses.setDebug(true);
		     
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    msg.setSubject(subject); // 제목
		    
		    Address fromAddr = new InternetAddress("koko00055@naver.com");
		    msg.setFrom(fromAddr);
		    
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		     
		    msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩
		     
		    Transport.send(msg); // 전송
		} catch(Exception e){
		    e.printStackTrace();
		    out.flush();
		    out.close();

		}
		
		System.out.println("메일 전송 완료!");
		
		if(multi.getFilesystemName("e_file") != null) {
			String e_file = (String)multi.getFilesystemName("e_file");
			email.setE_file(e_file);
			
			String pattern = e_file.substring(e_file.indexOf(".") +1);
			String head = e_file.substring(0, e_file.indexOf("."));
			
			String imagePath = uploadPath + "\\" + e_file;
			File src = new File(imagePath);
			
			String thumPath = uploadPath + "\\" + head + "." + pattern;
			File dest = new File(thumPath);
			
			if(pattern.equals("gif") || pattern.equals("jpg")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}
		
		return dao.insertEmail(email);
	}
	
	public EmailListDo EmailListService(HttpServletRequest request)throws Exception{
		EmailListSearchDo searchDo = new EmailListSearchDo();
		HttpSession session = request.getSession();
		
		if(request.getParameterValues("area") != null) {
			session.removeAttribute("searchDo");
			searchDo.setArea(request.getParameterValues("area"));
			searchDo.setSearchKey("%"+request.getParameter("searchKey")+"%");
			session.setAttribute("searchDo", searchDo);	
		}else if(session.getAttribute("searchDo") != null){
			searchDo = (EmailListSearchDo)session.getAttribute("searchDo");
		}
		
		int totalCount = dao.countSenderList(searchDo);
		System.out.println(totalCount);
		int totalPageCount = totalCount / PAGE_SIZE;
		
		if(totalCount % PAGE_SIZE > 0) {
			totalPageCount++;
		}
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int requestPage = Integer.parseInt(pageNum);
		int startPage = requestPage - (requestPage -1) % 5;
		int endPage = startPage + 4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		int startRow = (requestPage -1) * PAGE_SIZE;
			
		List<EmailDo> Slist = dao.EmailSenderList(searchDo, startRow);		
		
		EmailListDo emaillistdo = new EmailListDo(Slist, requestPage, totalPageCount, startPage, endPage);
		
		return emaillistdo;
	}
	
	public int EmailDeleteService(EmailDeleteDo edelete) {
		return dao.emaildelete(edelete);
	}
}
