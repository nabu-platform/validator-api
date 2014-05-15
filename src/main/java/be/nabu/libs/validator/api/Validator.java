package be.nabu.libs.validator.api;

import java.util.List;

public interface Validator<T> {
	public List<ValidationMessage> validate(T instance);
	public Class<T> getValueClass();
}
