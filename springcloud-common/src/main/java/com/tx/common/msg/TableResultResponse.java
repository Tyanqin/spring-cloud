package com.tx.common.msg;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author TanXiao
 * @date 2022-05-19 10:25
 */
public class TableResultResponse <T> extends BaseResponse{

    TableData<T> data;

    public TableResultResponse(long total,List<T> rows){
        this.data = new TableData<T>(total,rows);
    }
    public TableResultResponse(){
        this.data = new TableData<T>();
    }

   public TableResultResponse<T> total(long total){
        this.data.setTotal(total);
        return this;
   }

   public TableResultResponse<T> rows(List<T> rows){
        this.data.setRows(rows);
        return this;
   }
    public TableData<T> getData() {
        return data;
    }

    public void setData(TableData<T> data) {
        this.data = data;
    }

    class TableData<T>{
        @ApiModelProperty(value = "总数量")
        long total;

        @ApiModelProperty(value = "列表")
        List<T> rows;

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public List<T> getRows() {
            return rows;
        }

        public void setRows(List<T> rows) {
            this.rows = rows;
        }

        public TableData(long total, List<T> rows) {
            this.total = total;
            this.rows = rows;
        }

        public TableData() { }
    }
}
