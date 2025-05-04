package com.kongke.types.common;

import lombok.Data;

@Data
public class PageParam {

    private Integer page = 1;
    private Integer size = 10;
}
