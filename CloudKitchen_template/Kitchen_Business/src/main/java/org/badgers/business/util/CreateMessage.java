package org.badgers.business.util;

public class CreateMessage {

	public String selectMessage(String status) {
		return Status.valueOf(status).getmessage();
	}
}
