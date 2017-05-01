package tn.me.rest;


import javax.enterprise.context.RequestScoped;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.typicode.jsonplaceholder.Mail;




@Path("/mail")
@RequestScoped
public class MailServices {


	@GET 
	public void mail(){} 

	
	@GET @Path("/mailsend/{subject}")
    @Produces({MediaType.TEXT_PLAIN})
	public String mailsend(@PathParam("subject") String subject) {
		Mail.setUSER_NAME((String) /*AuthenticationController.getAuth().getMail()*/"majdeddine.letaief" );
        Mail.setPASSWORD(/*(String) PwTF.getText()*/"Ice&Fire16");
        Mail.setRECIPIENT(/*(String) CommentsAndReportsController.selected.getSenderMail()*/"majdeddine.letaief@esprit.tn");
        
        Mail.setSsubject(subject);
        String Texte="Bonjour Monsieur !";
        Mail.setBbody(Texte);
        String[] to = {Mail.getRECIPIENT()};
        Mail.sendFromGMaill(Mail.getUSER_NAME(), Mail.getPASSWORD(), to, Mail.getSsubject(), Mail.getBbody());
        
        return "success!";
	
	}
}
