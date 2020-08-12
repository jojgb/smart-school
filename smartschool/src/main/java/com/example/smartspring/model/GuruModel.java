package com.example.smartspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_guru")
public class GuruModel {
	@Id
	@Column(name="NIP")
	private String nip;
	
	@Column(name="Nama_Guru")
	private String namaGuru;
	
	@Column(name="Telepon")
	private String telepon;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Gelar")
	private String gelar;
	
	@Column(name="Alamat")
	private String alamat;

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNamaGuru() {
		return namaGuru;
	}

	public void setNamaGuru(String namaGuru) {
		this.namaGuru = namaGuru;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGelar() {
		return gelar;
	}

	public void setGelar(String gelar) {
		this.gelar = gelar;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	
}
