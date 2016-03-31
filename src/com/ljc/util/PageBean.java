package com.ljc.util;

import java.util.List;

//分页类
public class PageBean<T> {
	private int count;//总条数
	private int currentPage=1;//当前页数
	private int countOfPage=2;//一页的条数
	private int allPages;//总页数
	private List<T> data;//当前页的数据
	public  PageBean(int count){
		this.count=count;
		if(count%countOfPage==0){
			this.allPages=count / countOfPage;
		}else{
			this.allPages=count / countOfPage + 1;
		}
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		if(currentPage<1){
			this.currentPage=1;
		}
		if(currentPage>allPages){
			this.currentPage=allPages;
		}
	}
	public int getCountOfPage() {
		return countOfPage;
	}
	public void setCountOfPage(int countOfPage) {
		this.countOfPage = countOfPage;
	}
	public int getAllPages() {
		return allPages;
	}
	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
