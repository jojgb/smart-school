package com.example.smartspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartspring.model.GuruModel;
import com.example.smartspring.repository.GuruRepository;
@Service
@Transactional
public class GuruService {
	@Autowired
	private GuruRepository guruRepository;
	
	public void createGuru(GuruModel guruModel) {
		this.guruRepository.save(guruModel);
	}
	
	public List<GuruModel> readData() {
		return this.guruRepository.findAll();
	}
	
	public GuruModel  editGuru(String nip) {
		return this.guruRepository.findById(nip).get();
	}
	
	public GuruModel detilGuru(String nip) {
		return this.guruRepository.findById(nip).get();
	}
	
	public void updateGuru(GuruModel guruModel) {
		this.guruRepository.save(guruModel);
	}
	
	public void deleteGuru(String nip) {
		this.guruRepository.deleteById(nip);
	}
}
