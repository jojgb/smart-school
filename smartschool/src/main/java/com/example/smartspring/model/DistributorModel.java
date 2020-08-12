package com.example.smartspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name="tbl_distributor")
public class DistributorModel {
	@Id
	@Column(name="Kode_Distributor")
	private String kodeDistributor;
	
	@Column(name="Nama_Distributor")
	private String namaDistributor;
	
	@Column(name="Tipe_Distributor")
	private String tipeDistributor;
	
	@Column(name="Telepon")
	private String telepon;
	
	@Column(name="Alamat")
	private String alamat;

	public String getKodeDistributor() {
		return kodeDistributor;
	}

	public void setKodeDistributor(String kodeDistributor) {
		this.kodeDistributor = kodeDistributor;
	}

	public String getNamaDistributor() {
		return namaDistributor;
	}

	public void setNamaDistributor(String namaDistributor) {
		this.namaDistributor = namaDistributor;
	}

	public String getTipeDistributor() {
		return tipeDistributor;
	}

	public void setTipeDistributor(String tipeDistributor) {
		this.tipeDistributor = tipeDistributor;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
}
