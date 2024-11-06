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
