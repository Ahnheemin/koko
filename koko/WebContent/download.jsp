<%@page import="rt.koko.service.FileDownloadHelper"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	response.reset();
	String fileName = request.getParameter("filename");
	//String fileName = URLEncoder.encode(new String(fileName2.getBytes("8859_1"), "UTF-8"), "utf-8");

	System.out.println(fileName);

	String uploadPath = request.getRealPath("upload"); //경로가 일치해야된다.
	String path = uploadPath.trim() + "\\" + fileName.trim();

	String fileName2 = URLEncoder.encode(fileName, "UTF-8");

	//response.setContentType("application/octet-stream");
	response.setContentType("application/x-msdownload");
	response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName2 + "\"");
	response.setHeader("Content-Transfer-Encoding", "binary");
	response.setHeader("Pragma", "no-cache;");
	response.setHeader("Expires", "-1;");

	out.clear();
	out = pageContext.pushBody();

	try {
		FileDownloadHelper.copy(path, response.getOutputStream());
		response.getOutputStream().close();
	} catch (Exception e) {
		System.out.println("ok");
		e.printStackTrace();
	}
%>
