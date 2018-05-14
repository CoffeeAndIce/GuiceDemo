package CoffeeAndIce.GuiceDemo.server.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.BindingAnnotation;

@Retention(RetentionPolicy.RUNTIME)//运行时起作用
@BindingAnnotation //让其绑定注释
public @interface SessionId {

}
