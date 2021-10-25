package com.cj.test.restdemo.database;

import java.util.HashMap;
import java.util.Map;

import com.cj.test.restdemo.model.Message;

public class DatabaseClass {

	private static Map<Long,Message> messages = new HashMap();
	
	public static Map<Long,Message> getMessage()
	{
		return messages;
	}
}
