package com.example.smartspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_kelas")
public class KelasModel {
	@Id
	@Column(name="Kode_Kelas")
	private String kodeKelas;
	
	@Column(name="Nama_kelas")
	private String namaKelas;
	
	@Column(name="Tingkat")
	private String tingkat;
	
	@Column(name="Wali_Kelas")
	private String waliKelas;
	
	@Column(name="Ruang")
	private String ruang;

	public String getKodeKelas() {
		return kodeKelas;
	}

	public void setKodeKelas(String kodeKelas) {
		this.kodeKelas = kodeKelas;
	}

	public String getNamaKelas() {
		return namaKelas;
	}

	public void setNamaKelas(String namaKelas) {
		this.namaKelas = namaKelas;
	}

	public String getTingkat() {
		return tingkat;
	}

	public void setTingkat(String tingkat) {
		this.tingkat = tingkat;
	}

	public String getWaliKelas() {
		return waliKelas;
	}

	public void setWaliKelas(String waliKelas) {
		this.waliKelas = waliKelas;
	}

	public String getRuang() {
		return ruang;
	}

	public void setRuang(String ruang) {
		this.ruang = ruang;
	}
}
