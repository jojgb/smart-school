package com.example.smartspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.smartspring.model.KelasModel;
import com.example.smartspring.repository.KelasRepository;

@Transactional
@Service
public class KelasService {
	@Autowired
	private KelasRepository kelasRepository;
	
	public void createKelas(KelasModel kelasModel) {
		this.kelasRepository.save(kelasModel);
	}
	
	public List<KelasModel> readData() {
		return this.kelasRepository.findAll();
	}
	
	public KelasModel detilKelas(String kodeKelas) {
		return this.kelasRepository.findById(kodeKelas).get();
	}
	
	public KelasModel editKelas(String kodeKelas) {
		return this.kelasRepository.findById(kodeKelas).get();
	}
	
	public void updateKelas(KelasModel kelasModel) {
		this.kelasRepository.save(kelasModel);
	}
	
	public void deleteKelas(String kodeKelas) {
		this.kelasRepository.deleteById(kodeKelas);
	}
}
