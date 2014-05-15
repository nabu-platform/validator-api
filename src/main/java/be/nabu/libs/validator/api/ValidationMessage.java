package be.nabu.libs.validator.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationMessage {
	
	public enum Severity {
		/**
		 * This calls attention to a certain situation that the developer might want to be aware of
		 * Either you can't predict the runtime outcome or situations exist that can not be entirely validated
		 */
		WARNING,
		
		/**
		 * This is a true validation error
		 */
		ERROR
	}
	
	private Severity severity;
	private String message, description;
	private Integer code;
	
	/**
	 * You can set zero or more contexts on a validation message which may further enlighten what exactly was validated
	 * or the circumstances it was validated in
	 */
	private List<String> contexts = new ArrayList<String>();
	
	public ValidationMessage(Severity severity, String message, Integer code, String description) {
		this.severity = severity;
		this.message = message;
		this.code = code;
		this.description = description;
	}
	
	public ValidationMessage(Severity severity, String message, Integer code) {
		this(severity, message, code, null);
	}

	public ValidationMessage(Severity severity, String message) {
		this(severity, message, null, null);
	}
	
	public ValidationMessage(Severity severity, String message, String description) {
		this(severity, message, null, description);
	}

	public Severity getSeverity() {
		return severity;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public Integer getCode() {
		return code;
	}
	
	public ValidationMessage addContext(String...contexts) {
		this.contexts.addAll(Arrays.asList(contexts));
		return this;
	}
	
	public List<String> getContext() {
		return new ArrayList<String>(contexts);
	}
	
	@Override
	public String toString() {
		return getContext() + " [" + getSeverity() + "] " + getMessage();
	}
}
