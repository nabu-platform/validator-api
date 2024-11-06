/*
* Copyright (C) 2014 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

package be.nabu.libs.validator.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is here for legacy reasons
 */
public class ValidationMessage implements ContextUpdatableValidation<String> {
	
	/**
	 * This should be extracted into a separate class
	 * Currently left here for legacy reasons
	 */
	public enum Severity {
		/**
		 * Non erroneous information that should be passed along
		 */
		INFO,
		/**
		 * This calls attention to a certain situation that the developer might want to be aware of
		 * Either you can't predict the runtime outcome or situations exist that can not be entirely validated
		 */
		WARNING,
		/**
		 * This is a true validation error
		 */
		ERROR,
		/**
		 * This is not only erroneous but for example dangerous 
		 */
		CRITICAL
	}
	
	private Severity severity;
	private String message, description;
	private String code;
	private Date created;
	
	/**
	 * You can set zero or more contexts on a validation message which may further enlighten what exactly was validated
	 * or the circumstances it was validated in
	 */
	private List<String> contexts = new ArrayList<String>();
	
	public ValidationMessage() {
		// auto construct
	}
	
	public ValidationMessage(Severity severity, String message, String code, String description) {
		this.severity = severity;
		this.message = message;
		this.code = code;
		this.description = description;
		this.created = new Date();
	}
	
	public ValidationMessage(Severity severity, String message) {
		this(severity, message, (String) null, null);
	}
	
	public ValidationMessage(Severity severity, String message, String description) {
		this(severity, message, (String) null, description);
	}

	@Override
	public Severity getSeverity() {
		return severity;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getCode() {
		return code;
	}
	
	@Override
	public void addContext(String context) {
		this.contexts.add(context);
	}
	
	@Override
	public List<String> getContext() {
		return new ArrayList<String>(contexts);
	}
	
	@Override
	public String toString() {
		return getContext() + " [" + getSeverity() + "] " + getMessage();
	}

	public void setContext(List<String> contexts) {
		this.contexts = contexts;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}
