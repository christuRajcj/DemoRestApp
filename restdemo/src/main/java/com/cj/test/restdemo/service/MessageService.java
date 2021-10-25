package com.cj.test.restdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cj.test.restdemo.database.DatabaseClass;
import com.cj.test.restdemo.model.Message;

public class MessageService {

	private Map<Long,Message> messages = DatabaseClass.getMessage();
	
	public MessageService()
	{
		messages.put(1L, new Message(1,"hello","Kook"));
		messages.put(2L, new Message(2,"How you doin","Jk"));
	}
	public List<Message> getAllMessages()
	{
		return new ArrayList<>(messages.values());
	}
	
	public Message getMessage(long id)
	{
		return messages.get(id);
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Message updateMessage(Message message)
	{
		if(message.getId() <= 0)
		{
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	public void deleteMessage(long id)
	{
		messages.remove(id);
	}
}
