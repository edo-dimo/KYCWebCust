package com.mobipay.customerkycweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.ManyToOne;
import com.mobipay.customerkycweb.model.Status;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private String id;
	
	@Column(name="AgentID")
	private String agentId;
	
	@Column(name="MobileNumber")
	private String mobileNumber;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="Priority")
	private String priority;
	
	@Column(name="TypeID")
	private String typeId;
	
	@Column(name="NumberID")
	private String numberId;
	
	@Column(name="Address1ID")
	private String address1FromID;
	
	@Column(name="Address2ID")
	private String address2FromID;
	
	@Column(name="CityID")
	private String cityFromID;
	
	@Column(name="ProvinceID")
	private String provinceFromID;
	
	@Column(name="PostalCodeID")
	private String postalCodeFromID;
	
	@Column(name="Address1Resident")
	private String address1Resident;
	
	@Column(name="Address2Resident")
	private String address2Resident;
	
	@Column(name="CityResident")
	private String cityResident;
	
	@Column(name="ProvinceResident")
	private String provinceResident;
	
	@Column(name="PostalCodeResident")
	private String postalCodeResident;
	
	@Column(name="HousePhoneNumber")
	private String housePhoneNumber;
	
	@Column(name="PlaceOfBirth")
	private String placeOfBirth;
	
	@Column(name="DateOfBirth")
	private String dateOfBirth;
	
	@Column(name="OccupationID")
	private String occupationFromID;
	
	@Column(name="CitizenshipID")
	private String citizenshipFromID;
	
	@Column(name="MotherMaidenName")
	private String motherMaidenName;
	
	@Column(name="OtherMobileNumber")
	private String otherMobileNumber;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="SignaturePhoto")
	private String signaturePhoto;
	
	@Column(name="CustomerIDPhoto")
	private String customerIDPhoto;
	
	@Column(name="FormPhoto")
	private String formPhoto;
	
	@Column(name="OtherPhoto")
	private String otherPhoto;	

	@Column(name="Status")
	private String status;
	
	@Column(name="ApproverNote")
	private String approverNote;
	
	@Column(name="CreateBy")
	private String createBy;
	
	@Column(name="CreateTime")
	private String createTime;
	
	@Column(name="UpdateBy")
	private String updateBy;
	
	@Column(name="UpdateTime")
	private String updateTime;
	
	@Column(name="FirstApproveBy")
	private String firstApproveBy;
	
	@Column(name="FirstApproveTime")
	private String firstApproveTime;

	@Column(name="SecondApproveBy")
	private String secondApproveBy;
	
	@Column(name="SecondApproveTime")
	private String secondApproveTime;
	
	@Column(name="ApproveDocumentBy")
	private String approveDocumentBy;
	
	@Column(name="ApproveDocumentTime")
	private String approveDocumentTime;

	public String getApproveDocumentBy() {
		return approveDocumentBy;
	}

	public void setApproveDocumentBy(String approveDocumentBy) {
		this.approveDocumentBy = approveDocumentBy;
	}

	public String getApproveDocumentTime() {
		return approveDocumentTime;
	}

	public void setApproveDocumentTime(String approveDocumentTime) {
		this.approveDocumentTime = approveDocumentTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getNumberId() {
		return numberId;
	}

	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}

	public String getAddress1FromID() {
		return address1FromID;
	}

	public void setAddress1FromID(String address1FromID) {
		this.address1FromID = address1FromID;
	}

	public String getAddress2FromID() {
		return address2FromID;
	}

	public void setAddress2FromID(String address2FromID) {
		this.address2FromID = address2FromID;
	}

	public String getCityFromID() {
		return cityFromID;
	}

	public void setCityFromID(String cityFromID) {
		this.cityFromID = cityFromID;
	}

	public String getProvinceFromID() {
		return provinceFromID;
	}

	public void setProvinceFromID(String provinceFromID) {
		this.provinceFromID = provinceFromID;
	}

	public String getPostalCodeFromID() {
		return postalCodeFromID;
	}

	public void setPostalCodeFromID(String postalCodeFromID) {
		this.postalCodeFromID = postalCodeFromID;
	}

	public String getAddress1Resident() {
		return address1Resident;
	}

	public void setAddress1Resident(String address1Resident) {
		this.address1Resident = address1Resident;
	}

	public String getAddress2Resident() {
		return address2Resident;
	}

	public void setAddress2Resident(String address2Resident) {
		this.address2Resident = address2Resident;
	}

	public String getCityResident() {
		return cityResident;
	}

	public void setCityResident(String cityResident) {
		this.cityResident = cityResident;
	}

	public String getProvinceResident() {
		return provinceResident;
	}

	public void setProvinceResident(String provinceResident) {
		this.provinceResident = provinceResident;
	}

	public String getPostalCodeResident() {
		return postalCodeResident;
	}

	public void setPostalCodeResident(String postalCodeResident) {
		this.postalCodeResident = postalCodeResident;
	}

	public String getHousePhoneNumber() {
		return housePhoneNumber;
	}

	public void setHousePhoneNumber(String housePhoneNumber) {
		this.housePhoneNumber = housePhoneNumber;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getOccupationFromID() {
		return occupationFromID;
	}

	public void setOccupationFromID(String occupationFromID) {
		this.occupationFromID = occupationFromID;
	}

	public String getCitizenshipFromID() {
		return citizenshipFromID;
	}

	public void setCitizenshipFromID(String citizenshipFromID) {
		this.citizenshipFromID = citizenshipFromID;
	}

	public String getMotherMaidenName() {
		return motherMaidenName;
	}

	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}

	public String getOtherMobileNumber() {
		return otherMobileNumber;
	}

	public void setOtherMobileNumber(String otherMobileNumber) {
		this.otherMobileNumber = otherMobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSignaturePhoto() {
		return signaturePhoto;
	}

	public void setSignaturePhoto(String signaturePhoto) {
		this.signaturePhoto = signaturePhoto;
	}

	public String getCustomerIDPhoto() {
		return customerIDPhoto;
	}

	public void setCustomerIDPhoto(String customerIDPhoto) {
		this.customerIDPhoto = customerIDPhoto;
	}

	public String getFormPhoto() {
		return formPhoto;
	}

	public void setFormPhoto(String formPhoto) {
		this.formPhoto = formPhoto;
	}

	public String getOtherPhoto() {
		return otherPhoto;
	}

	public void setOtherPhoto(String otherPhoto) {
		this.otherPhoto = otherPhoto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApproverNote() {
		return approverNote;
	}

	public void setApproverNote(String approverNote) {
		this.approverNote = approverNote;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getFirstApproveBy() {
		return firstApproveBy;
	}

	public void setFirstApproveBy(String firstApproveBy) {
		this.firstApproveBy = firstApproveBy;
	}

	public String getFirstApproveTime() {
		return firstApproveTime;
	}

	public void setFirstApproveTime(String firstApproveTime) {
		this.firstApproveTime = firstApproveTime;
	}

	public String getSecondApproveBy() {
		return secondApproveBy;
	}

	public void setSecondApproveBy(String secondApproveBy) {
		this.secondApproveBy = secondApproveBy;
	}

	public String getSecondApproveTime() {
		return secondApproveTime;
	}

	public void setSecondApproveTime(String secondApproveTime) {
		this.secondApproveTime = secondApproveTime;
	}
	
	@Transient
	private String waitingForApproval;
	
	@Transient
	private String requestForDocument;
	
	@Transient
	private String waitingForApproval2;
	
	@Transient
	private String requestForDocument2;
	
	@Transient
	private String invalidData;
	
	@Transient
	private String followUp1;
	
	@Transient
	private String followUp2;
	
	@Transient
	private String followUp3;
	
	@Transient
	private String documentUpdated;
	
	@Transient
	private String approved;
	
	@Transient
	private String rejected;
	
	@Transient
	private String expired;

	@ManyToOne
	@JoinColumn(name = "status", insertable=false, updatable=false)
	private Status stat;

	public Status getStat() {
		return stat;
	}

	public void setStat(Status stat) {
		this.stat = stat;
	}
	
	public String getWaitingForApproval() {
		return waitingForApproval;
	}

	public void setWaitingForApproval(String waitingForApproval) {
		this.waitingForApproval = waitingForApproval;
	}

	public String getRequestForDocument() {
		return requestForDocument;
	}

	public void setRequestForDocument(String requestForDocument) {
		this.requestForDocument = requestForDocument;
	}

	public String getWaitingForApproval2() {
		return waitingForApproval2;
	}

	public void setWaitingForApproval2(String waitingForApproval2) {
		this.waitingForApproval2 = waitingForApproval2;
	}

	public String getRequestForDocument2() {
		return requestForDocument2;
	}

	public void setRequestForDocument2(String requestForDocument2) {
		this.requestForDocument2 = requestForDocument2;
	}

	public String getInvalidData() {
		return invalidData;
	}

	public void setInvalidData(String invalidData) {
		this.invalidData = invalidData;
	}

	public String getFollowUp1() {
		return followUp1;
	}

	public void setFollowUp1(String followUp1) {
		this.followUp1 = followUp1;
	}

	public String getFollowUp2() {
		return followUp2;
	}

	public void setFollowUp2(String followUp2) {
		this.followUp2 = followUp2;
	}

	public String getFollowUp3() {
		return followUp3;
	}

	public void setFollowUp3(String followUp3) {
		this.followUp3 = followUp3;
	}

	public String getDocumentUpdated() {
		return documentUpdated;
	}

	public void setDocumentUpdated(String documentUpdated) {
		this.documentUpdated = documentUpdated;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getRejected() {
		return rejected;
	}

	public void setRejected(String rejected) {
		this.rejected = rejected;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}	
	
	@Transient
	private String startDate;
	
	@Transient
	private String endDate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
