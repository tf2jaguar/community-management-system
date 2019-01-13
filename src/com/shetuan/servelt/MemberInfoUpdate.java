package com.shetuan.servelt;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shetuan.bean.Member;
import com.shetuan.dao.CommunityDao;
import com.shetuan.dao.MemberDao;

public class MemberInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDao memberdao = new MemberDao();
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			Map<String, String> fromFilds = new HashMap<String, String>();
			String fileName = null;
			if (isMultipart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);

				@SuppressWarnings("unchecked")
				List<FileItem> /* FileItem */ items = upload.parseRequest(request);

				@SuppressWarnings("rawtypes")
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();

					if (item.isFormField()) {
						// 获取文件名和类型
						String name = item.getFieldName();
						String value = item.getString("utf-8");
						fromFilds.put(name, value);

					} else {
						
						@SuppressWarnings("unused")
						String fieldName = item.getFieldName();
						fileName = item.getName();
						System.out.println("fileName " + fileName.length());
						if (fileName.length() > 0) {
		
							try {
								fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
							} catch (StringIndexOutOfBoundsException e) {
								System.out.println("String index out of range: -1");
							}

							@SuppressWarnings("unused")
							String strDirPath = request.getSession().getServletContext().getRealPath("header");
							String sysDirPath = "F:\\tianhaiworks\\shetuan\\WebContent\\header";
							// 
							File uploadFile = new File(sysDirPath + "//" + fileName);

							item.write(uploadFile);
						} else if (fileName.length() == 0) {
							fileName = "head.jpg";
						}
					}
				}

				Member member = new Member();
				member.setLoginName(fromFilds.get("loginname"));
				member.setMemberName(fromFilds.get("username"));
				member.setMemberGender(fromFilds.get("gender"));
				member.setMemberAdd(fromFilds.get("add"));
				member.setMemberGrade(fromFilds.get("grade"));
				member.setMemberInstitute(fromFilds.get("institute"));
				member.setMemberEmail(fromFilds.get("email"));
				member.setMemberPhone(fromFilds.get("phone"));
				member.setIscreatCommunity(Integer.parseInt(fromFilds.get("iscreat")));
				CommunityDao communityDao = new CommunityDao();
				member.setIsJoinCommunity(communityDao.getCommunityIdByCName(fromFilds.get("jcom")));
				member.setMemberHeader(fileName);

				System.out.println("name:" + member.getMemberName());
				System.out.println("institute:" + member.getMemberInstitute());
				System.out.println("header:" + member.getMemberHeader());

				int result = memberdao.updateMember(member);

				if (result > 0) {
					request.getRequestDispatcher("admin/Query?lru=ulist").forward(request, response);
					return;
				} else {
					request.setAttribute("returnURL", "main");
					response.sendRedirect("error.jsp");
					return;
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
