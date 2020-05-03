package com.dong.domain;

public class DormBuild {
	private Integer dormBuildId;
	private String dormBuildName;
	private String dormBuildDetail;
	@Override
	public String toString() {
		return "DormBuild [dormBuildId=" + dormBuildId + ", dormBuildName=" + dormBuildName + ", dormBuildDetail="
				+ dormBuildDetail + "]";
	}
	public Integer getDormBuildId() {
		return dormBuildId;
	}
	public void setDormBuildId(Integer dormBuildId) {
		this.dormBuildId = dormBuildId;
	}
	public String getDormBuildName() {
		return dormBuildName;
	}
	public void setDormBuildName(String dormBuildName) {
		this.dormBuildName = dormBuildName;
	}
	public String getDormBuildDetail() {
		return dormBuildDetail;
	}
	public void setDormBuildDetail(String dormBuildDetail) {
		this.dormBuildDetail = dormBuildDetail;
	}
}
