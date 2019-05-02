package be.nabu.libs.validator.api;

import java.util.Date;
import java.util.List;

import be.nabu.libs.validator.api.ValidationMessage.Severity;

public interface Validation<T> {
	/**
	 * The severity of the validation
	 */
	public Severity getSeverity();
	
	/**
	 * The context that the validation occurred in
	 */
	public List<T> getContext();
	
	/**
	 * A structural code for this validation, handy for automatically identifying validations
	 */
	public String getCode();
	
	/**
	 * A short message describing the validation
	 */
	public String getMessage();
	
	/**
	 * A longer description concerning the validation or things you can do about it
	 */
	public String getDescription();
	
	/**
	 * When the validation was created
	 */
	public Date getCreated();
}
