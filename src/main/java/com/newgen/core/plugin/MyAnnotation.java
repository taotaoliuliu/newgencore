package com.newgen.core.plugin;

import java.lang.annotation.Target;

import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;

@Retention (RetentionPolicy.RUNTIME) 
@Target(value=ElementType.TYPE)
public @interface MyAnnotation {

	public String value() default "className";;

	
	
}
