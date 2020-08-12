package com.example.smartspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_pelajaran")
public class PelajaranModel {
	@Id
	@Column(name="Kode_Pelajaran")
	private String KodePelajaran;
	
	@Column(name="Nama_Pelajaran")
	private String NamaPelajaran;
	
	@Column(name="Jam_Ajar")
	private String JamAjar;
	
	@Column(name="Tingkat")
	private String Tingkat;
	
	@Column(name="Keterangan")
	private String Keterangan;

	public String getKodePelajaran() {
		return KodePelajaran;
	}

	public void setKodePelajaran(String kodePelajaran) {
		KodePelajaran = kodePelajaran;
	}

	public String getNamaPelajaran() {
		return NamaPelajaran;
	}

	public void setNamaPelajaran(String namaPelajaran) {
		NamaPelajaran = namaPelajaran;
	}

	public String getJamAjar() {
		return JamAjar;
	}

	public void setJamAjar(String jamAjar) {
		JamAjar = jamAjar;
	}

	public String getTingkat() {
		return Tingkat;
	}

	public void setTingkat(String tingkat) {
		Tingkat = tingkat;
	}

	public String getKeterangan() {
		return Keterangan;
	}

	public void setKeterangan(String keterangan) {
		Keterangan = keterangan;
	}
	
}
