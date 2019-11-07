package com.fangzhou.asongmanager.utils;


import com.fangzhou.asongmanager.dto.*;
import com.fangzhou.asongmanager.pojo.Admin;
import com.fangzhou.asongmanager.pojo.Asong_order;
import com.fangzhou.asongmanager.pojo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagesMap {
	
	public static Map<String,Object> getpagesUserMaps(List<Admin> list, int pn){
		 List<Admin> newList = new ArrayList<Admin>();
	        if(10*pn>list.size()) {
	        	newList = list.subList(10*pn-9-1,list.size());
	        }else {
	        	newList = list.subList(10*pn-9-1, 10*pn);
	        }
	        
	        Map<String,Object> map = new HashMap<String,Object>();
	        
	        int total = list.size();   
	        int pageNum = pn;          
	        int pages = total%10 == 0 ? (total/10) : (total/10)+1;   
	        int[] navigatepageNums = new int[pages];      
	        for(int i=0;i<navigatepageNums.length;i++) {
	        	navigatepageNums[i]=i+1;	        			
	        }
	        boolean hasNextPage = false;
	        if(pn==pages) {
	        	hasNextPage = false;
	        }else {
	        	hasNextPage = true;
	        }
	        boolean hasPreviousPage = false;
	        if(pn==1) {
	        	hasPreviousPage = false;
	        }else {
	        	hasPreviousPage = true;
	        }
	        map.put("total", total);
	        map.put("pageNum", pageNum);
	        map.put("pages", pages);
	        map.put("navigatepageNums", navigatepageNums);
	        map.put("hasNextPage", hasNextPage);
	        map.put("list", newList);
	        map.put("hasPreviousPage", hasPreviousPage);
	        return map;
	}
	public static Map<String,Object> getUserMaps(List<User> list, int pn){
		 List<User> newList = new ArrayList<User>();
	        if(10*pn>list.size()) {
	        	newList = list.subList(10*pn-9-1,list.size());
	        }else {
	        	newList = list.subList(10*pn-9-1, 10*pn);
	        }

	        Map<String,Object> map = new HashMap<String,Object>();

	        int total = list.size();
	        int pageNum = pn;
	        int pages = total%10 == 0 ? (total/10) : (total/10)+1;
	        int[] navigatepageNums = new int[pages];
	        for(int i=0;i<navigatepageNums.length;i++) {
	        	navigatepageNums[i]=i+1;
	        }
	        boolean hasNextPage = false;
	        if(pn==pages) {
	        	hasNextPage = false;
	        }else {
	        	hasNextPage = true;
	        }
	        boolean hasPreviousPage = false;
	        if(pn==1) {
	        	hasPreviousPage = false;
	        }else {
	        	hasPreviousPage = true;
	        }
	        map.put("total", total);
	        map.put("pageNum", pageNum);
	        map.put("pages", pages);
	        map.put("navigatepageNums", navigatepageNums);
	        map.put("hasNextPage", hasNextPage);
	        map.put("list", newList);
	        map.put("hasPreviousPage", hasPreviousPage);
	        return map;
	}
	public static Map<String,Object> getAuthorMaps(List<AuthorDTO> list, int pn){
		 List<AuthorDTO> newList = new ArrayList<AuthorDTO>();
	        if(10*pn>list.size()) {
	        	newList = list.subList(10*pn-9-1,list.size());
	        }else {
	        	newList = list.subList(10*pn-9-1, 10*pn);
	        }

	        Map<String,Object> map = new HashMap<String,Object>();

	        int total = list.size();
	        int pageNum = pn;
	        int pages = total%10 == 0 ? (total/10) : (total/10)+1;
	        int[] navigatepageNums = new int[pages];
	        for(int i=0;i<navigatepageNums.length;i++) {
	        	navigatepageNums[i]=i+1;
	        }
	        boolean hasNextPage = false;
	        if(pn==pages) {
	        	hasNextPage = false;
	        }else {
	        	hasNextPage = true;
	        }
	        boolean hasPreviousPage = false;
	        if(pn==1) {
	        	hasPreviousPage = false;
	        }else {
	        	hasPreviousPage = true;
	        }
	        map.put("total", total);
	        map.put("pageNum", pageNum);
	        map.put("pages", pages);
	        map.put("navigatepageNums", navigatepageNums);
	        map.put("hasNextPage", hasNextPage);
	        map.put("list", newList);
	        map.put("hasPreviousPage", hasPreviousPage);
	        return map;
	}
	public static Map<String,Object> getProductMaps(List<ProductDTO> list, int pn){
		 List<ProductDTO> newList = new ArrayList<ProductDTO>();
	        if(10*pn>list.size()) {
	        	newList = list.subList(10*pn-9-1,list.size());
	        }else {
	        	newList = list.subList(10*pn-9-1, 10*pn);
	        }

	        Map<String,Object> map = new HashMap<String,Object>();

	        int total = list.size();
	        int pageNum = pn;
	        int pages = total%10 == 0 ? (total/10) : (total/10)+1;
	        int[] navigatepageNums = new int[pages];
	        for(int i=0;i<navigatepageNums.length;i++) {
	        	navigatepageNums[i]=i+1;
	        }
	        boolean hasNextPage = false;
	        if(pn==pages) {
	        	hasNextPage = false;
	        }else {
	        	hasNextPage = true;
	        }
	        boolean hasPreviousPage = false;
	        if(pn==1) {
	        	hasPreviousPage = false;
	        }else {
	        	hasPreviousPage = true;
	        }
	        map.put("total", total);
	        map.put("pageNum", pageNum);
	        map.put("pages", pages);
	        map.put("navigatepageNums", navigatepageNums);
	        map.put("hasNextPage", hasNextPage);
	        map.put("list", newList);
	        map.put("hasPreviousPage", hasPreviousPage);
	        return map;
	}
	public static Map<String,Object> getOrderMaps(List<OrderDTO> list, int pn){
		 List<OrderDTO> newList = new ArrayList<OrderDTO>();
	        if(10*pn>list.size()) {
	        	newList = list.subList(10*pn-9-1,list.size());
	        }else {
	        	newList = list.subList(10*pn-9-1, 10*pn);
	        }

	        Map<String,Object> map = new HashMap<String,Object>();

	        int total = list.size();
	        int pageNum = pn;
	        int pages = total%10 == 0 ? (total/10) : (total/10)+1;
	        int[] navigatepageNums = new int[pages];
	        for(int i=0;i<navigatepageNums.length;i++) {
	        	navigatepageNums[i]=i+1;
	        }
	        boolean hasNextPage = false;
	        if(pn==pages) {
	        	hasNextPage = false;
	        }else {
	        	hasNextPage = true;
	        }
	        boolean hasPreviousPage = false;
	        if(pn==1) {
	        	hasPreviousPage = false;
	        }else {
	        	hasPreviousPage = true;
	        }
	        map.put("total", total);
	        map.put("pageNum", pageNum);
	        map.put("pages", pages);
	        map.put("navigatepageNums", navigatepageNums);
	        map.put("hasNextPage", hasNextPage);
	        map.put("list", newList);
	        map.put("hasPreviousPage", hasPreviousPage);
	        return map;
	}
	public static Map<String,Object> getCityDataMaps(List<CityDataDTO> list, int pn){
		 List<CityDataDTO> newList = new ArrayList<CityDataDTO>();
	        if(10*pn>list.size()) {
	        	newList = list.subList(10*pn-9-1,list.size());
	        }else {
	        	newList = list.subList(10*pn-9-1, 10*pn);
	        }

	        Map<String,Object> map = new HashMap<String,Object>();

	        int total = list.size();
	        int pageNum = pn;
	        int pages = total%10 == 0 ? (total/10) : (total/10)+1;
	        int[] navigatepageNums = new int[pages];
	        for(int i=0;i<navigatepageNums.length;i++) {
	        	navigatepageNums[i]=i+1;
	        }
	        boolean hasNextPage = false;
	        if(pn==pages) {
	        	hasNextPage = false;
	        }else {
	        	hasNextPage = true;
	        }
	        boolean hasPreviousPage = false;
	        if(pn==1) {
	        	hasPreviousPage = false;
	        }else {
	        	hasPreviousPage = true;
	        }
	        map.put("total", total);
	        map.put("pageNum", pageNum);
	        map.put("pages", pages);
	        map.put("navigatepageNums", navigatepageNums);
	        map.put("hasNextPage", hasNextPage);
	        map.put("list", newList);
	        map.put("hasPreviousPage", hasPreviousPage);
	        return map;
	}
	public static Map<String,Object> getMonthDataMaps(List<MonthDataDTO> list, int pn){
		 List<MonthDataDTO> newList = new ArrayList<MonthDataDTO>();
	        if(10*pn>list.size()) {
	        	newList = list.subList(10*pn-9-1,list.size());
	        }else {
	        	newList = list.subList(10*pn-9-1, 10*pn);
	        }

	        Map<String,Object> map = new HashMap<String,Object>();

	        int total = list.size();
	        int pageNum = pn;
	        int pages = total%10 == 0 ? (total/10) : (total/10)+1;
	        int[] navigatepageNums = new int[pages];
	        for(int i=0;i<navigatepageNums.length;i++) {
	        	navigatepageNums[i]=i+1;
	        }
	        boolean hasNextPage = false;
	        if(pn==pages) {
	        	hasNextPage = false;
	        }else {
	        	hasNextPage = true;
	        }
	        boolean hasPreviousPage = false;
	        if(pn==1) {
	        	hasPreviousPage = false;
	        }else {
	        	hasPreviousPage = true;
	        }
	        map.put("total", total);
	        map.put("pageNum", pageNum);
	        map.put("pages", pages);
	        map.put("navigatepageNums", navigatepageNums);
	        map.put("hasNextPage", hasNextPage);
	        map.put("list", newList);
	        map.put("hasPreviousPage", hasPreviousPage);
	        return map;
	}
	public static Map<String,Object> getReferralsDataMaps(List<ReferralsDataDTO> list, int pn){
		 List<ReferralsDataDTO> newList = new ArrayList<ReferralsDataDTO>();
	        if(10*pn>list.size()) {
	        	newList = list.subList(10*pn-9-1,list.size());
	        }else {
	        	newList = list.subList(10*pn-9-1, 10*pn);
	        }

	        Map<String,Object> map = new HashMap<String,Object>();

	        int total = list.size();
	        int pageNum = pn;
	        int pages = total%10 == 0 ? (total/10) : (total/10)+1;
	        int[] navigatepageNums = new int[pages];
	        for(int i=0;i<navigatepageNums.length;i++) {
	        	navigatepageNums[i]=i+1;
	        }
	        boolean hasNextPage = false;
	        if(pn==pages) {
	        	hasNextPage = false;
	        }else {
	        	hasNextPage = true;
	        }
	        boolean hasPreviousPage = false;
	        if(pn==1) {
	        	hasPreviousPage = false;
	        }else {
	        	hasPreviousPage = true;
	        }
	        map.put("total", total);
	        map.put("pageNum", pageNum);
	        map.put("pages", pages);
	        map.put("navigatepageNums", navigatepageNums);
	        map.put("hasNextPage", hasNextPage);
	        map.put("list", newList);
	        map.put("hasPreviousPage", hasPreviousPage);
	        return map;
	}

}
