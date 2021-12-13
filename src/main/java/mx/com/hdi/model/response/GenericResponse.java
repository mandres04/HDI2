package mx.com.hdi.model.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class GenericResponse <T>{
	protected int code;
    protected String message;
    protected List<String> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected T response;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMenssage(String message) {
		this.message = message;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public GenericResponse() {
		this.code = 500;
		this.message = "";
		this.errors = new ArrayList<>();
	}
	public GenericResponse(int code, String message) {
		this.code = code;
		this.message = message;
		this.errors = new ArrayList<>();
	}
	public GenericResponse(int code, String message, List<String> errors) {
		this.code = code;
		this.message = message;
		this.errors = errors;
	}
	public GenericResponse(int code, String message, List<String> errors, T response) {
		this.code = code;
		this.message = message;
		this.errors = errors;
		this.response = response;
	}
	public GenericResponse(int code, String message, T response) {
		this.code = code;
		this.message = message;
		this.response = response;
	}
	@Override
	public String toString() {
		return "[code=" + code + ", message=" + message + ", errors=" + errors + ", response=" + response + "]";
	}
}
