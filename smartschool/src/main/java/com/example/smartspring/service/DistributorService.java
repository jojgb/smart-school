package com.example.smartspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartspring.model.DistributorModel;
import com.example.smartspring.repository.DistributorRepository;

@Transactional
@Service
public class DistributorService {
	@Autowired
	private DistributorRepository distributorRepository ;
	
	public void createDistributor(DistributorModel distributorModel) {
		this.distributorRepository.save(distributorModel);
	}
	
	public void updateDistributor(DistributorModel distributorModel) {
		this.distributorRepository.save(distributorModel);
	}
	
	public List<DistributorModel> readData() {
		return this.distributorRepository.findAll();
	}
	
	public DistributorModel detilDistributor(String kodeDistributor) {
		return this.distributorRepository.findById(kodeDistributor).get();
	}
	
	public DistributorModel editDistributor(String kodeDistributor) {
		return this.distributorRepository.findById(kodeDistributor).get();
	}
	
	public void deleteDistributor(String kodeDistributor) {
		this.distributorRepository.deleteById(kodeDistributor);
	}
	
}
