package be.nabu.libs.validator.api;

public interface ContextUpdatableValidation<T> extends Validation<T> {
	public void addContext(T context);
}
