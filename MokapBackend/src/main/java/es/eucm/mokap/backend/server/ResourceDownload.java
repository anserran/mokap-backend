package es.eucm.mokap.backend.server;

import es.eucm.mokap.backend.controller.download.MokapDownloadController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to process download requests.
 */
public class ResourceDownload extends HttpServlet {

	private static final long serialVersionUID = 5191318392003026466L;
	//private static BackendController controller = new MokapBackendController();
	private MokapDownloadController dCont;
	
	/**
	 * Method: GET
	 * Retrieves the file specified in the parameter filename
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		dCont = new MokapDownloadController();
		//Get the filename from the parameters
		String fileName = req.getParameter("filename");
		if(!fileName.equals("") && fileName != null){
			//Set the header
			resp.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
			try {
				dCont.launchFileDownload(fileName, resp.getOutputStream());
			}catch(Exception e){
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,ServerReturnMessages.m(ServerReturnMessages.INVALID_DOWNLOAD_FILENNOTFOUND, fileName, e.getMessage()));
			}
		}else{
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, ServerReturnMessages.INVALID_DOWNLOAD_FILENAMENULL);
		}	
	}

}
