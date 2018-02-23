package com.shetuan.bean;


public class Activity {
	//社团活动Id
	private int activityId;
	//社团名称
	private int communityId;
	//活动名称
	private String activityName;
	//社团名称
	private String communityName;
	//活动日期
	private String activityDate;
	//活动地点
	private String activityPlace;
	//活动详细信息
	private String activityInfo;
	//活动视频存储路径
	private String activityVideo;
	//活动照片存储路径
	private String activityPhoto;
	
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public String getActivityPlace() {
		return activityPlace;
	}
	public void setActivityPlace(String activityPlace) {
		this.activityPlace = activityPlace;
	}
	public String getActivityInfo() {
		return activityInfo;
	}
	public void setActivityInfo(String activityInfo) {
		this.activityInfo = activityInfo;
	}
	public String getActivityPhoto() {
		return activityPhoto;
	}
	public void setActivityPhoto(String activityPhoto) {
		this.activityPhoto = activityPhoto;
	}
	public String getActivityVideo() {
		return activityVideo;
	}
	public void setActivityVideo(String activityVideo) {
		this.activityVideo = activityVideo;
	}

}
