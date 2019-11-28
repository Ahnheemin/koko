package rt.koko.service;

import java.io.File;
/*
import kosta.model.*;

*/
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import rt.koko.DAO.DocumentDAO;
import rt.koko.domain.DocumentDO;
import rt.koko.domain.DocumentListDO;
import rt.koko.domain.DocumentSearchDO;

public class DocumentService {
	private static DocumentService service = new DocumentService();
	private static DocumentDAO dao;
	private static final int PAGE_SIZE = 10;
	
	public static DocumentService getInstance() {
		dao = DocumentDAO.getInstance();
		return service;
	}
	
	public int documentInsertService(HttpServletRequest request) throws Exception {
	      request.setCharacterEncoding("utf-8");
	      
	      //���Ͼ��ε�(���, ����ũ��,���ڵ�, �����̸���ø ��å)
	      String uploadPath = request.getRealPath("upload");
	      System.out.println(uploadPath);
	      int size = 20*1024*1024; //20MB
	      
	      //cos.jar
	      MultipartRequest multi = 
	            new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy()); //�����̸���ø��å api: new DefaultFileRenamePolicy()
	      
	      //
	      DocumentDO documentDO = new DocumentDO();
	      documentDO.setDoc_content(multi.getParameter("doc_content"));
	      documentDO.setDoc_title(multi.getParameter("doc_title"));
	      documentDO.setDoc_file(multi.getParameter("doc_file"));
	      
	      //���Ͼ��ε��, DB(��������), ����� �̹��� ����
	      if(multi.getFilesystemName("doc_file") != null) {
	         String doc_file=(String)multi.getFilesystemName("doc_file");
	         documentDO.setDoc_file(doc_file);
	         
	         //����� �̹���(GIF,jpg) =>aaa.gif => aaa_small.gif
	         String pattern = doc_file.substring(doc_file.indexOf(".")+1); //.�� ���ؼ� ã�� +1�ؼ� gif�� ã��
	         String head = doc_file.substring(0, doc_file.indexOf(".")); //aaa
	         
	         //���� file��ü
	         String imagePath = uploadPath + "\\" + doc_file; //���� ���ε�� ��� + ���ε��ϰ����ϴ� �����̸�
	         File src = new File(imagePath);
	         
	         //����� ������ file��ü
	         String thumPath = uploadPath + "\\" + head + "_small." + pattern; //����� �̹���(_small)���� �ִ� ��� ����
	         File dest = new File(thumPath);
	         
	         if(pattern.equals("gif") || pattern.equals("jpg")) {
	        	 ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
	         }
	      }
	      
	      return dao.documentInsert(documentDO);
	   }
	public DocumentListDO documentListService(HttpServletRequest request)throws Exception{
	      DocumentSearchDO search = new DocumentSearchDO();
	      HttpSession session = request.getSession();
	      
	      // �˻� - ��ưŬ��
	      if(request.getParameterValues("area") != null) {
	         session.removeAttribute("search");
	         search.setArea(request.getParameterValues("area"));
	         search.setSearchKey("%"+request.getParameter("searchKey")+"%");
	         session.setAttribute("search", search);
	      }
	      
	      // �˻� �� ����¡ó��
	      else if(session.getAttribute("search") != null) {
	         search = (DocumentSearchDO)session.getAttribute("search");
	      }
	      
	      //������ó������ //����¡�� �۰���, �ѱ۰���, ����������, ���������� //startPage, endPage, startRow, endRow
	      
	      // �ѱ۰���
	      int totalCount = dao.documentCount(search);
	      
	      //����������
	      int totalPageCount = totalCount/PAGE_SIZE;
	      if(totalCount%PAGE_SIZE > 0) {
	         totalPageCount++;
	      }
	      
	      String pageNum = request.getParameter("pageNum");
	      if(pageNum == null) {
	         pageNum = "1";
	      }
	      int requestPage = Integer.parseInt(pageNum);
	      
	      //���������� -Ŭ���̾�Ʈ�� Ŭ���� ���������̼��� �޾Ƽ� �����(����BoardService)���޹޾ƾ� �˼����ִ�.  ������������ ���İ� �߿�! ���� ��û���������� ����!
	      int startPage = requestPage - (requestPage - 1) % 5;
	      
	      //endPage
	      int endPage = startPage + 4;
	      if(endPage > totalPageCount) {
	         endPage = totalPageCount;
	      }
	      
	      //startRow //startPage //startPage = ���������� - (���������� -1)%5 (5:������ ���������̼� 123345 5678910 1112131415 )  //RoWBounds 
	      int startRow = (requestPage - 1) * PAGE_SIZE;      
	      
	      List<DocumentDO> list = dao.documentList(search, startRow);
	      
	      DocumentListDO listModelDO = new DocumentListDO(list, requestPage, totalPageCount, startPage, endPage);
	      
	      return listModelDO;
	      
	   }
	   
	
	public DocumentDO documentDetailService(int doc_seq){
		DocumentDO documentDO = dao.documentDetail(doc_seq);
		
		return documentDO;
	}
	
	public int documentUpdateService(HttpServletRequest request)throws Exception {	
		request.setCharacterEncoding("utf-8");
		 
		DocumentDO documentDO = new DocumentDO();
		documentDO.setDoc_content(request.getParameter("doc_content"));
		documentDO.setDoc_file(request.getParameter("doc_file"));
		documentDO.setDoc_title(request.getParameter("doc_title")); 
		int doc_seq = Integer.parseInt(request.getParameter("doc_seq"));
		documentDO.setDoc_seq(doc_seq);
					
		return dao.documentUpdate(documentDO);
	}
	
	public int documentDeleteService(int doc_seq) {
		return dao.documentDelete(doc_seq);
	}
	
	

}
