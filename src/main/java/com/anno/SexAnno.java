package com.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface SexAnno {

    public enum GenderType {
        MAN("男"),WOMAN("女")
        ;
        private String sex;

        GenderType(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "GenderType{" +
                    "sex='" + sex + '\'' +
                    '}';
        }
    }

    GenderType gender() default GenderType.MAN;

}
