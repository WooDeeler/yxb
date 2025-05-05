package com.kongke.domain.univ.utils;

import cn.hutool.core.bean.BeanUtil;

public class Convert {

    public static <S, T> T convert(S source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            BeanUtil.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Convert failed: " + e.getMessage());
        }
    }
}
