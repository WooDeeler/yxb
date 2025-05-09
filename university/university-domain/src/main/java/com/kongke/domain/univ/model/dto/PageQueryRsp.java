package com.kongke.domain.univ.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageQueryRsp<T> {
    private Long total;

    private List<T> list;

}
