package com.cj.test.restdemo.messageresources;

import java.util.List;

import com.cj.test.restdemo.model.Message;
import com.cj.test.restdemo.service.MessageService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/message")
public class MessageResources {

	MessageService messageService = new MessageService();
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }
	
	@GET
	@Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId) {
        return messageService.getMessage(messageId);
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
    }
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long id,Message message) {
		message.setId(id);
        return messageService.updateMessage(message);
    }
	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	 public void deleteMessage(@PathParam("messageId") long id) {
		 messageService.deleteMessage(id);
    }
}
