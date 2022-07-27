package com.tx.common.util;

import java.util.List;

/**
 * @author TanXiao
 * @date 2022-06-01 14:30
 */
public class QueryPage <T>{
    private int currentPage = 1;//当前页，默认显示第一页

    private int pageCount = 10;//每页显示的行数（查询返回的行数），默认每页显示10行

    private int totalCount ;//数据库表中的总记录数

    private int totalPage;//总页数  =  总记录数  /    每页显示的行数（+1）

    private List<T> data;//分页查询到的数据

    public QueryPage(int currentPage, int totalCount,int pageCount) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        if(this.currentPage < 0){
            this.currentPage = 0;
        }else if(this.currentPage > this.getTotalPage()){
            this.currentPage = this.getTotalPage();
        }
        return currentPage * pageCount;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return this.totalCount/ this.pageCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    //    private int currentPage = 1;//当前页，默认显示第一页
//    private int pageCount = 8;//每页显示的行数（查询返回的行数），默认每页显示3行
//    private int totalCount ;//数据库表中的总记录数
//    private int totalPage;//总页数  =  总记录数  /    每页显示的行数（+1）
//    private List<T> list;//分页查询到的数据

//    //返回总页数
//    public int getTotalPage() {
//        //若总页数是奇数是页数增加的逻辑判断
//        if (totalCount % pageCount == 0) {
//            totalPage = totalCount / pageCount;
//        } else {
//            totalPage = totalCount / pageCount + 1;
//        }
//    }
////基本属性
//        /**当前页数，由用户指定				*/
//        private int currentPageNum;
//        /**每页显示的条数，可以由用户指定每页显示多少		*/
//        private int pageSize =5;
//        /**总记录条数，数据库查出来的			    */
//        private int totalRecords;
//        /**总页数，计算出来的					*/
//        private int totalPageNum;
//        /**每页开始记录的索引，计算出来的		（当前页-1）*（每页数量）=起始值	    */
//        private int startIndex;
//        /**上一页							    */
//        private int prePageNum;
//        /**下一页							    */
//        private int nextPageNum;
//        /**已经分好页的结果集,存放我们查出来的结果集*/
//        private List list;

//        /**扩展属性
//         一共每页显示9个页码按钮*/
//        /**开始页码*/
//        private int startPage;
//        /**结束页码*/
//        private int endPage;
//
//        /**完善属性*/
//        private String url;


//        /**要想使用我的分页，必须给我两个参数。一个是要看哪一页，另一个是总记录条数*/
//	public QueryPage(int currentPageNum,int totalRecords,int pageSize){
//            this.currentPageNum = currentPageNum;
//            this.totalRecords = totalRecords;
//            this.pageSize=pageSize;
//
//            //计算查询记录的开始索引
//            startIndex = (currentPageNum-1)*pageSize;
//            //计算总页数
//            totalPageNum = totalRecords%pageSize==0?(totalRecords/pageSize):(totalRecords/pageSize+1);
//
//            //5
//            startPage = currentPageNum - 4;
//            //结束页码
//            endPage = currentPageNum + 4;
//            //看看总页数够不够9页
//            if(totalPageNum>9){
//                //超过了9页
//                if(startPage < 1){
//                    startPage = 1;
//                    endPage = startPage+8;
//                }
//                if(endPage>totalPageNum){
//                    endPage = totalPageNum;
//                    startPage = endPage-8;
//                }
//            }else{
//                //不够9页
//                startPage = 1;
//                endPage = totalPageNum;
//            }
//        }
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        public int getStartPage() {
//            return startPage;
//        }
//
//        public void setStartPage(int startPage) {
//            this.startPage = startPage;
//        }
//
//        public int getEndPage() {
//            return endPage;
//        }
//        public void setEndPage(int endPage) {
//            this.endPage = endPage;
//        }
//        public int getPrePageNum() {
//            prePageNum = currentPageNum-1;
//            if(prePageNum<1){
//                prePageNum = 1;
//            }
//            return prePageNum;
//        }
//        public int getNextPageNum() {
//            nextPageNum = currentPageNum+1;
//            if(nextPageNum>totalPageNum){
//                nextPageNum = totalPageNum;
//            }
//            return nextPageNum;
//        }
//        public int getCurrentPageNum() {
//            return currentPageNum;
//        }
//        public void setCurrentPageNum(int currentPageNum) {
//            this.currentPageNum = currentPageNum;
//        }
//        public int getPageSize() {
//            return pageSize;
//        }
//        public void setPageSize(int pageSize) {
//            this.pageSize = pageSize;
//        }
//        public int getTotalRecords() {
//            return totalRecords;
//        }
//        public void setTotalRecords(int totalRecords) {
//            this.totalRecords = totalRecords;
//        }
//        public int getTotalPageNum() {
//            return totalPageNum;
//        }
//        public void setTotalPageNum(int totalPageNum) {
//            this.totalPageNum = totalPageNum;
//        }
//        public int getStartIndex() {
//            return startIndex;
//        }
//        public void setStartIndex(int startIndex) {
//            this.startIndex = startIndex;
//        }
//        public void setPrePageNum(int prePageNum) {
//            this.prePageNum = prePageNum;
//        }
//        public void setNextPageNum(int nextPageNum) {
//            this.nextPageNum = nextPageNum;
//        }
//        public List getList() {
//            return list;
//        }
//        public void setList(List list) {
//            this.list = list;
//        }

}
