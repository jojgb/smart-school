package com.example.smartspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartspring.model.SiswaModel;
import com.example.smartspring.repository.SiswaRepository;

@Service
@Transactional
public class SiswaService {
	@Autowired
	private SiswaRepository siswaRepository;
	
	public void createSiswa(SiswaModel siswaModel) {
		this.siswaRepository.save(siswaModel);
	}
	public List<SiswaModel> readData() {
		return this.siswaRepository.findAll();
	}
	public SiswaModel detilSiswa(String nimSiswa) {
		return this.siswaRepository.findById(nimSiswa).get();
	}
	public SiswaModel editSiswa(String nimSiswa) {
		return this.siswaRepository.findById(nimSiswa).get();
	}
	public void updateSiswa(SiswaModel siswaModel) {
		this.siswaRepository.save(siswaModel);
	}
	public void deleteSiswa(String nimSiswa) {
		this.siswaRepository.deleteById(nimSiswa);
	}
}
