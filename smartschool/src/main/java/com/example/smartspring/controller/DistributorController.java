package com.example.smartspring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.smartspring.model.DistributorModel;
import com.example.smartspring.service.DistributorService;

@Controller
public class DistributorController {
	@Autowired
	private DistributorService distributorService;
	
	@RequestMapping("/distributor")
	public String DistributorView(Model model) {
		this.ListDistributor(model);
		String html = "/distributor/distributor";
		return html;
	}
	
	@RequestMapping("/adddistributor")
	public String addDistributor() {
		String html = "/distributor/adddistributor";
		return html;
	}
	
	
	@RequestMapping("/createdistributor")
	public String createDistributor(HttpServletRequest request , Model model) {
		String kodeDistributor = request.getParameter("kodedistributor");
		String namaDistributor = request.getParameter("namadistributor");
		String tipeDistributor = request.getParameter("tipedistributor");
		String telepon = request.getParameter("telepon");
		String alamat = request.getParameter("alamat");
		
		/// instance model ///
		DistributorModel distributorModel =  new DistributorModel();
		
		distributorModel.setKodeDistributor(kodeDistributor);
		distributorModel.setNamaDistributor(namaDistributor);
		distributorModel.setTipeDistributor(tipeDistributor);
		distributorModel.setTelepon(telepon);
		distributorModel.setAlamat(alamat);
		
		this.distributorService.createDistributor(distributorModel);
		this.ListDistributor(model);
		
		
		String html = "/distributor/distributor";
		return html;
	}
	
	@RequestMapping("/updatedistributor")
	public String updateDistributor(HttpServletRequest request , Model model) {
		String kodeDistributor = request.getParameter("kodedistributor");
		String namaDistributor = request.getParameter("namadistributor");
		String tipeDistributor = request.getParameter("tipedistributor");
		String telepon = request.getParameter("telepon");
		String alamat = request.getParameter("alamat");
		
		/// instance model ///
		DistributorModel distributorModel =  new DistributorModel();
		
		distributorModel.setKodeDistributor(kodeDistributor);
		distributorModel.setNamaDistributor(namaDistributor);
		distributorModel.setTipeDistributor(tipeDistributor);
		distributorModel.setTelepon(telepon);
		distributorModel.setAlamat(alamat);
		
		this.distributorService.createDistributor(distributorModel);
		this.ListDistributor(model);
		
		
		String html = "/distributor/distributor";
		return html;
	}
	
	@RequestMapping("/detil/distributor/{kodeDistributor}")
	public ModelAndView detilDistributor(@PathVariable(name="kodeDistributor")String kodeDistributor) {
		ModelAndView mav = new ModelAndView("/distributor/detildistributor");
		DistributorModel distributorModel = distributorService.detilDistributor(kodeDistributor);
		mav.addObject("distributorModel", distributorModel);
		return mav;
	}
	
	@RequestMapping("/edit/distributor/{kodeDistributor}")
	public ModelAndView editDistributor(@PathVariable(name="kodeDistributor")String kodeDistributor) {
		ModelAndView mav = new ModelAndView("/distributor/editdistributor");
		DistributorModel distributorModel = distributorService.detilDistributor(kodeDistributor);
		mav.addObject("distributorModel", distributorModel);
		return mav;
	}
	
	@RequestMapping("/delete/distributor/{kodeDistributor}")
	public String deleteDistributor(String kodeDistributor) {
		distributorService.deleteDistributor(kodeDistributor);
		return "redirect:/distributor";
	}
	
	public void ListDistributor(Model model) {
		List<DistributorModel> distributorModelList = new ArrayList<DistributorModel>();
		distributorModelList = distributorService.readData();
		model.addAttribute("distributorModelList", distributorModelList);
		
	}
}
