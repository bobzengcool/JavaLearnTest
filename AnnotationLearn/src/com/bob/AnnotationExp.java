package com.bob;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.lang.reflect.Field;
import java.util.Set;

public class AnnotationExp extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Class clazz = null;
        try {
            clazz = Class.forName("EaipMsg8917.class");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取Person类所有属性
        Field[] fields = clazz.getDeclaredFields();
        Set<? extends Element> elements = roundEnvironment.
        return false;
    }
}
