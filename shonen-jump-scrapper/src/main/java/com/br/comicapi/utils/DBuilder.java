package com.br.comicapi.utils;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

public class DBuilder {

	private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	
	public static <T> T build(Object src, Class<T> klass) {
		if (src == null) return null;
		
		mapperFactory.classMap(src.getClass(), klass).use(src.getClass(), klass.getSuperclass());
	    
		MapperFacade mapper = mapperFactory.getMapperFacade();
	    
	    return mapper.map(src, klass);	
	}
	
	public static <T> Iterable<T> buildList(Iterable<?> src, Class<T> klass) {
		if (src == null) return null;
		
		mapperFactory.classMap(src.getClass().getClass(), klass).use(src.getClass().getClass(), src.getClass().getClass().getSuperclass());
	    
		MapperFacade mapper = mapperFactory.getMapperFacade();
	    
	    return mapper.mapAsList(src, klass);	
	}
	
	public static <T> List<T> buildList(List<?> src, Class<T> klass) {
		if (src == null) return null;
		
		mapperFactory.classMap(src.getClass().getClass(), klass).use(src.getClass().getClass(), src.getClass().getClass().getSuperclass());
	    
		MapperFacade mapper = mapperFactory.getMapperFacade();
	    
	    return mapper.mapAsList(src, klass);	
	}
	
	@SuppressWarnings("rawtypes")
	public static <T> List<T> buildList(List<?> src, Class<T> klass, List<String> fieldsToExclude) {
		if (src == null) return null;
		
		ClassMapBuilder<? extends List, T> builder = mapperFactory.classMap(src.getClass(), klass);
		fieldsToExclude.forEach(f -> builder.exclude(f));
		builder.byDefault().register();
	    
		MapperFacade mapper = mapperFactory.getMapperFacade();
	    
	    return mapper.mapAsList(src, klass);	
	}

	
}
