package com.robert.ecommerce.utils;


import ma.glasnost.orika.MapperFactory;

public interface MappingConfigurer {
    void configure(MapperFactory mapperFactory);
}
