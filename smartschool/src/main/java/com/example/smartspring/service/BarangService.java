package com.example.smartspring.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.smartspring.model.BarangModel;
import com.example.smartspring.repository.BarangRepository;

@Service
@Transactional
public class BarangService {
	@Autowired
	private BarangRepository barangRepository;
	
	public void createBarang(BarangModel barangModel) {
		this.barangRepository.save(barangModel);
	}
	
	public void updateBarang(BarangModel barangModel) {
		this.barangRepository.save(barangModel);
	}
	
	public List<BarangModel> readData() {
		return this.barangRepository.findAll();
	}
	
	public BarangModel editBarang(String kodeBarang) {
		return this.barangRepository.findById(kodeBarang).get();
	}
	
	public BarangModel detilBarang(String kodeBarang) {
		return this.barangRepository.findById(kodeBarang).get();
	}
	
	public void deleteBarang(String kodeBarang) {
		this.barangRepository.deleteById(kodeBarang);
	}
}
