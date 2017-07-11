package com.utils;

import java.util.List;

import com.model.BaseEntiy;

/**
 * @Name  :PageHelper
 * @Desc  :TODO
 * @author:zhu
 * @param <T>
 * @date  :2016年8月30日
 */
public class PageResult<T>  extends BaseEntiy{

	private static final long serialVersionUID = 91633546203267104L;
	
	private List<T> dataList;//数据  
    
    private int pageNo = 1;//当前页  
      
    private int pageSize = 10;//条数  
      
    private long total;//总条数  
      
    private long pages;//总页面数目
    
    private boolean isPage = true;
    
    

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

	public boolean getIsPage() {
		return isPage;
	}

	public void setIsPage(boolean isPage) {
		this.isPage = isPage;
	}

}
