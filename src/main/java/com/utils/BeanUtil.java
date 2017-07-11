package com.utils;

import java.util.List;

import com.github.pagehelper.Page;

/**
 * @Name  :BeanUtil
 * @Desc  :TODO
 * @author:zhu
 * @date  :2016年8月30日
 */
public class BeanUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> PageResult<T> toPagedResult(List<T> datas, PageResult<T> result) {  
        if (datas instanceof Page) {  
            Page page = (Page) datas;  
            result.setPageNo(page.getPageNum());  
            result.setPageSize(page.getPageSize());  
            result.setDataList(page.getResult());  
            result.setTotal(page.getTotal());  
            result.setPages(page.getPages());  
        }  
        else {  
            result.setPageNo(1);  
            result.setPageSize(datas.size());  
            result.setDataList(datas);  
            result.setTotal(datas.size());  
        }  
  
        return result;  
    }  
}
