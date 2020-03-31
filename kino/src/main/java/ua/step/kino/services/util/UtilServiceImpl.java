package ua.step.kino.services.util;

import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {

	@Override
	public <T extends Enum<?>> T searchEnum(Class<T> enumeration, String search) {
		for (T each : enumeration.getEnumConstants()) {
	        if (each.name().compareToIgnoreCase(search) == 0) {
	            return each;
	        }
	    }
	    return null;
	}
	
}
