package com.crudOp.model.response;

public class CustomResponse<T> {
	String messsage;
	
	public CustomResponse(String messsage, T data) {
		super();
		this.messsage = messsage;
		this.data = data;
	}
	T data;
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	

}
