package com.grandviewtech.surveysystem.entity.enums;

public enum Status
	{
	ACTIVE("ACTIVE"), INACTIVE("INACTIVE"), INPROGRESS("IN PROGRESS");

		private String status;

		private Status(String status)
			{
				this.status = status;
			}

		public String getStatus()
			{
				return status;
			}
	}
