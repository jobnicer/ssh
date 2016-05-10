package org.ssh.common;

import java.util.List;

import org.ssh.common.entity.DTO;

/**
* @Package : org.ssh.common
* @FileName : PageModel
* @Description : 分页模型
* @Author : YJ
* @Date : 2015年12月31日 上午9:31:56
*/
@SuppressWarnings("rawtypes")
public class PageModel {

	/** 总记录数 */
	private int totalProperty;
	
	/** 总页数 */
	private int totalPage;

	/** 单store数据 */
	private List datas;

	/** 多store数据 */
	private List datas1;

	/** 多store数据 */
	private List datas2;

	/** 开始页码 */
	private int startPage;

	/** 每页数量 */
	private int limit;

	/** 当前页数 */
	private int currentPage;

	/** 成功与否 */
	private boolean success;

	/** 查询条件 */
	private DTO conditions;

	/** 返回消息 */
	private String message;

	/** 返回页面ID */
	private String pageId;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public List getDatas1() {
		return datas1;
	}

	public void setDatas1(List datas1) {
		this.datas1 = datas1;
	}

	public List getDatas2() {
		return datas2;
	}

	public void setDatas2(List datas2) {
		this.datas2 = datas2;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public DTO getConditions() {
		return conditions;
	}

	public void setConditions(DTO conditions) {
		this.conditions = conditions;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	/**
	* @MethodName ：setTotalPage
	* @Description ：
	* @param total 总记录数
	* @param limit 每页记录数
	*/
	public void setTotalPage(int total,int limit) {
		totalPage = 0;
		if(limit!=0){
			totalPage = (total+limit-1)/limit;
		}
		if(totalPage==0) {
			totalPage = 1;
		}
	}

	public String getPageId() {
		return pageId;
	}
	
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

}
