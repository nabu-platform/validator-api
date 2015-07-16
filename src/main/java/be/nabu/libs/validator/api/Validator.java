package be.nabu.libs.validator.api;

import java.util.List;

public interface Validator<T> {
	public List<? extends Validation<?>> validate(T instance);
	public Class<T> getValueClass();
}
