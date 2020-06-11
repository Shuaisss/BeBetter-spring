package cn.edu.scujcc.User;

import java.io.Serializable;

public class Response implements Serializable{
	private static final long serialVersionUID = 4059578639807608549L;
	//定义一些常见的常量
	public final static int STATUS_OK = 1;
	public final static int STATUS_ERROR = -1;
	
	private int status;//状态
	private String message;//消息
	private User data;//一个真正的数据（会出现矛盾 等一会修改 ）
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}

}
