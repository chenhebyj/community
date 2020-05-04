package com.example.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageInfoDTO {
    private List<PublishDTO> publishDTO;
    private boolean head;
    private boolean tail;
    private boolean next;
    private boolean pre;
    private Integer currentPage;
    private List<Integer> pages;
    private Integer totalPage;

    public void setInfo(int count, Integer pageNumber, Integer pageSize) {
        this.currentPage = pageNumber;
        int  min, max;
        if(count % pageSize == 0){
            this.totalPage = count / pageSize;
        }else{
            this.totalPage = count / pageSize + 1;
        }


        if(currentPage == 1){
            pre = false;
            head = false;
        }else{
            pre = true;
            head = true;
        }

        if(currentPage == totalPage){
            next = false;
            tail = false;
        }else{
            next = true;
            tail = true;
        }

        if(currentPage - (pageSize - 1) / 2 > 0){
            min = currentPage - (pageSize - 1) / 2;
        }else{
            min = 1;
        }

        if(currentPage + (pageSize - 1) / 2 > totalPage){
            max = totalPage;
        }else{
            max = currentPage + (pageSize - 1) / 2;
        }

        for(int k = min; k <= max; k++){

            this.pages.add(k);
        }
    }
}
