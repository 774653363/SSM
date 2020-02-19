package ek.zhou.util;

public class Page {
private int startIndex = 0;
private int pageNum = 1;
private int pageSize = 5;
private int lastPage = 0;
private int totalRecord = 0;
public Page() {
	// TODO Auto-generated constructor stub
}
public Page(int pageNum,int pageSize,int totalRecord) {
	this.pageNum = pageNum;
	this.pageSize = pageSize;
	this.totalRecord = totalRecord;
	if(totalRecord%pageSize==0){
		lastPage = totalRecord/pageSize;
	}else{
		lastPage = totalRecord/pageSize + 1;
	}
	startIndex = (pageNum-1)*pageSize;
}
public void caculate(int totalRecord){
	this.totalRecord = totalRecord;
	if(totalRecord%pageSize==0){
		lastPage = totalRecord/pageSize;
	}else{
		lastPage = totalRecord/pageSize + 1;
	}
	startIndex = (pageNum-1)*pageSize;
}
public int getStartIndex() {
	startIndex = (pageNum-1)*pageSize;
	return startIndex;
}
public void setStartIndex(int startIndex) {
	this.startIndex = startIndex;
}
public int getPageNum() {
	return pageNum;
}
public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getLastPage() {
	return lastPage;
}
public void setLastPage(int lastPage) {
	this.lastPage = lastPage;
}
public int getTotalRecord() {
	return totalRecord;
}
public void setTotalRecord(int totalRecord) {
	this.totalRecord = totalRecord;
}
@Override
public String toString() {
	return "Page [startIndex=" + startIndex + ", pageNum=" + pageNum + ", pageSize=" + pageSize + ", lastPage="
			+ lastPage + ", totalRecord=" + totalRecord + "]";
}


}
