package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")

public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public upload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uploadFolder = getServletContext().getRealPath("F:\\DOCUMENT\\LẬP TRÌNH MẠNG\\Lap_Trinh_Mang\\upload");
	//	String uploadFolder = "upload";
//		String rs = null;
		boolean uploadCompleted = false;
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				ServletFileUpload sv = new ServletFileUpload(new DiskFileItemFactory());
				List<FileItem> multiparts = sv.parseRequest(request);

				for (FileItem fileItem : multiparts) {
					if (!fileItem.isFormField()) {

						String name = new File(fileItem.getName()).getName();
						File a = new File(uploadFolder);
						if (!a.exists())
							a.mkdir();
						fileItem.write(new File(uploadFolder + "\\" + name));
//						rs = name;

					}

				}
				uploadCompleted = true;

			} catch (Exception e) {
				request.setAttribute("message", "File Upload Failed due to" + e);
			}
		} else {
			request.setAttribute("message", "Sorry! Well done!");
		}

		if (uploadCompleted) {
			request.setAttribute("message", "File Uploaded Successfully");
		} else {

			request.setAttribute("message", "File Uploaded Failed");
		}

		// trang hien len thong bao
		request.getRequestDispatcher("/uploadsuccess.jsp").forward(request, response);
	}

}
