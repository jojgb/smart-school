package com.example.smartspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.smartspring.model.PelajaranModel;
import com.example.smartspring.repository.PelajaranRepository;

@Service
@Transactional
public class PelajaranService {
	@Autowired
	private PelajaranRepository pelajaranRepository;
	
	public void createPelajaran(PelajaranModel pelajaranModel) {
		this.pelajaranRepository.save(pelajaranModel);
	}
	public PelajaranModel detilPelajaran(String KodePelajaran) {
		return this.pelajaranRepository.findById(KodePelajaran).get();
	}
	public PelajaranModel editPelajaran(String KodePelajaran) {
		return this.pelajaranRepository.findById(KodePelajaran).get();
	}
	public void updatePelajaran(PelajaranModel pelajaranModel) {
		this.pelajaranRepository.save(pelajaranModel);
	}
	public List<PelajaranModel> readData() {
		return this.pelajaranRepository.findAll();
	}
	public void deletePelajaran(String KodePelajaran) {
		this.pelajaranRepository.deleteById(KodePelajaran);
	}
}
