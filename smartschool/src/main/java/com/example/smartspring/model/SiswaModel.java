package com.example.smartspring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_siswa")
public class SiswaModel {
	@Id
	@Column(name="Nim_Siswa")
	private String nimSiswa;
	
	@Column(name="Nama_Siswa")
	private String namaSiswa;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Tanggal_Lahir")
	private Date tanggalLahir;
	
	@Column(name="Tempat_Lahir")
	private String tempatLahir;
	
	@Column(name="Wali_Murid")
	private String waliMurid;
	
	@Column(name="Pekerjaan")
	private String pekerjaan;
	
	@Column(name="Telepon_WaliMurid")
	private String telpWaliMurid;
	
	@Column(name="Alamat_Murid")
	private String alamatMurid;
	
	@Column(name="Kelas")
	private String kelas;

	public String getNimSiswa() {
		return nimSiswa;
	}

	public void setNimSiswa(String nimSiswa) {
		this.nimSiswa = nimSiswa;
	}

	public String getNamaSiswa() {
		return namaSiswa;
	}

	public void setNamaSiswa(String namaSiswa) {
		this.namaSiswa = namaSiswa;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public String getWaliMurid() {
		return waliMurid;
	}

	public void setWaliMurid(String waliMurid) {
		this.waliMurid = waliMurid;
	}

	public String getPekerjaan() {
		return pekerjaan;
	}

	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}

	public String getTelpWaliMurid() {
		return telpWaliMurid;
	}

	public void setTelpWaliMurid(String telpWaliMurid) {
		this.telpWaliMurid = telpWaliMurid;
	}

	public String getAlamatMurid() {
		return alamatMurid;
	}

	public void setAlamatMurid(String alamatMurid) {
		this.alamatMurid = alamatMurid;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	
	
}
