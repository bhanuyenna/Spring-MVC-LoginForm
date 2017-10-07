package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany
	@JoinColumn(name = "batch_id")
	private Batch batch;
	@Column(name = "name")
	private String studentName;
	@Column(name = "email")
	private String email;
	@Column(name = "contact")
	private String contact;
	@Column(name = "visa_status")
	private String visaStatus;
	@Column(name = "cost")
	private int cost;
	@Column(name = "paid")
	private String paid;
	@Column(name = "mode")
	private String mode;
	@Column(name = "comments")
	private String comments;
	@Column(name="batchId")
	private String batchId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getVisaStatus() {
		return visaStatus;
	}

	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", batch=" + batch + ", studentName=" + studentName + ", email=" + email
				+ ", contact=" + contact + ", visaStatus=" + visaStatus + ", cost=" + cost + ", paid=" + paid
				+ ", mode=" + mode + ", comments=" + comments + ", batchId=" + batchId + "]";
	}


	

	

}
