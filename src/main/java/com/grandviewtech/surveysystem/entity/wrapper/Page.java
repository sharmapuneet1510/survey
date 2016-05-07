package com.grandviewtech.surveysystem.entity.wrapper;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Page<T> implements Serializable
	{
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:52 pm <br>
		 * @Description :
		 */
		private static final long	serialVersionUID	= 4309510781052096864L;

		private int					totalPages;

		private int					currentPage;

		private Set<Integer>		pageNumbers;

		private int					startIndex;

		private int					pageSize;

		private List<T>				pages;

		private boolean				hasNext				= false;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:28 pm <br>
		 * @methodName : getTotalPages <br>
		 * @Description : <br>
		 * @return the totalPages
		 */
		public int getTotalPages()
			{
				return totalPages;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:28 pm <br>
		 * @methodName : setTotalPages <br>
		 * @Description : <br>
		 * @param totalPages
		 *            the totalPages to set
		 */
		public void setTotalPages(int totalPages)
			{
				this.totalPages = totalPages;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:28 pm <br>
		 * @methodName : getCurrentPage <br>
		 * @Description : <br>
		 * @return the currentPage
		 */
		public int getCurrentPage()
			{
				return currentPage;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:28 pm <br>
		 * @methodName : setCurrentPage <br>
		 * @Description : <br>
		 * @param currentPage
		 *            the currentPage to set
		 */
		public void setCurrentPage(int currentPage)
			{
				this.currentPage = currentPage;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:28 pm <br>
		 * @methodName : getStartIndex <br>
		 * @Description : <br>
		 * @return the startIndex
		 */
		public int getStartIndex()
			{
				return startIndex;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:28 pm <br>
		 * @methodName : setStartIndex <br>
		 * @Description : <br>
		 * @param startIndex
		 *            the startIndex to set
		 */
		public void setStartIndex(int startIndex)
			{
				this.startIndex = startIndex;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:28 pm <br>
		 * @methodName : getPageSize <br>
		 * @Description : <br>
		 * @return the pageSize
		 */
		public int getPageSize()
			{
				return pageSize;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:28 pm <br>
		 * @methodName : setPageSize <br>
		 * @Description : <br>
		 * @param pageSize
		 *            the pageSize to set
		 */
		public void setPageSize(int pageSize)
			{
				this.pageSize = pageSize;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:28 pm <br>
		 * @methodName : getPages <br>
		 * @Description : <br>
		 * @return the pages
		 */
		public List<T> getPages()
			{
				return pages;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:31:28 pm <br>
		 * @methodName : setPages <br>
		 * @Description : <br>
		 * @param pages
		 *            the pages to set
		 */
		public void setPages(List<T> pages)
			{
				this.pages = pages;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:52:59 pm <br>
		 * @methodName : isHasNext <br>
		 * @Description : <br>
		 * @return the hasNext
		 */
		public boolean isHasNext()
			{
				return hasNext;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:52:59 pm <br>
		 * @methodName : setHasNext <br>
		 * @Description : <br>
		 * @param hasNext
		 *            the hasNext to set
		 */
		public void setHasNext(boolean hasNext)
			{
				this.hasNext = hasNext;
			}
			
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 10:38:52 pm <br>
		 * @methodName : getPageNumbers <br>
		 * @Description : <br>
		 * @return the pageNumbers
		 */
		public Set<Integer> getPageNumbers()
			{
				return pageNumbers;
			}
			
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 10:38:52 pm <br>
		 * @methodName : setPageNumbers <br>
		 * @Description : <br>
		 * @param pageNumbers the pageNumbers to set
		 */
		public void setPageNumbers(Set<Integer> pageNumbers)
			{
				this.pageNumbers = pageNumbers;
			}
			
	}
