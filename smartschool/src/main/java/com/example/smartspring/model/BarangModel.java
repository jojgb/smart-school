package com.example.smartspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name="tbl_barang")
public class BarangModel {
	@Id
	@Column(name="Kode_Barang")
	private String kodeBarang ;
	
	@Column(name="Nama_Barang")
	private String namaBarang;
	
	@Column(name="Satuan")
	private String satuan;
	
	public String getKodeBarang() {
		return kodeBarang;
	}

	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	public String getSatuan() {
		return satuan;
	}

	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}

	public String getHargaSiswa() {
		return hargaSiswa;
	}

	public void setHargaSiswa(String hargaSiswa) {
		this.hargaSiswa = hargaSiswa;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	@Column(name="Harga_Siswa")
	private String hargaSiswa;
	
	@Column(name="Keterangan")
	private String keterangan;
}
