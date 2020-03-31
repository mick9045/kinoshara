package ua.step.kino.services.util;

public interface UtilService {
	public <T extends Enum<?>> T searchEnum(Class<T> enumeration, String search);
}
