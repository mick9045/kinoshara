package ua.step.kino.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import ua.step.kino.entities.Position;

public class StringListToPositionListConverter implements Converter<String, Position> {

	@Override
	public Position convert(String pos) {
		return Position.values()[Integer.valueOf(pos)];
	}
}
