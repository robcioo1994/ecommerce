package com.robert.ecommerce.utils;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MapperFacadeFactoryBean implements FactoryBean<MapperFacade> {

    private final Set<Converter> converters;

    @Autowired(required = false)
    public MapperFacadeFactoryBean(Set<Converter> converters) {
        super();
        this.converters = converters;
    }

    @Override
    public MapperFacade getObject() throws Exception {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converters.forEach(converterFactory::registerConverter);

        return mapperFactory.getMapperFacade();
    }

    @Override
    public Class<?> getObjectType() {
        return MapperFacade.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
