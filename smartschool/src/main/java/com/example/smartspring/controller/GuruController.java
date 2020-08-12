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

import com.example.smartspring.model.GuruModel;
import com.example.smartspring.repository.GuruRepository;
import com.example.smartspring.service.GuruService;

@Controller
public class GuruController {
	@Autowired
	private GuruService guruService;
	
	@RequestMapping("/guru")
	public String GuruView(Model model) {
		this.ListGuru(model);
		String html = "/guru/guru";
		return html;
	}
	//// ---  add guru ---- ////
	@RequestMapping("/addguru")
	public String addGuru() {
		String html = "/guru/addguru";
		return html;
	}
	
	@RequestMapping("/createguru")
	public String createGuru(HttpServletRequest request , Model model) {
		String nip = request.getParameter("nip");
		String namaGuru = request.getParameter("namaguru");
		String telepon = request.getParameter("telepon");
		String gender = request.getParameter("gender");
		String gelar = request.getParameter("gelar");
		String alamat = request.getParameter("alamat");
		
		/// instance guru
		GuruModel guruModel =  new GuruModel();
		
		guruModel.setNip(nip);
		guruModel.setNamaGuru(namaGuru);
		guruModel.setTelepon(telepon);
		guruModel.setGender(gender);
		guruModel.setGelar(gelar);
		guruModel.setAlamat(alamat);
		
		/// -- save  --- //
		guruService.createGuru(guruModel);
		
		this.ListGuru(model);
		
		String html = "/guru/guru";
		return html;
	}
	
	@RequestMapping("/detil/guru/{nip}")
	public ModelAndView detilGuru(@PathVariable(name="nip")String nip) {
		ModelAndView mav = new ModelAndView("/guru/detilguru");
		GuruModel guruModel = guruService.detilGuru(nip);
		mav.addObject("guruModel", guruModel);

		return mav;
	}
	
	@RequestMapping("/edit/guru/{nip}")
	public ModelAndView editGuru(@PathVariable(name="nip")String nip) {
		ModelAndView mav = new ModelAndView("/guru/editguru");
		GuruModel guruModel = guruService.editGuru(nip);
		mav.addObject("guruModel", guruModel);
		return mav;
	}
	
	@RequestMapping("/updateguru")
	public String updateGuru(HttpServletRequest request , Model model) {
		String nip = request.getParameter("nip");
		String namaGuru = request.getParameter("namaguru");
		String telepon = request.getParameter("telepon");
		String gender = request.getParameter("gender");
		String gelar = request.getParameter("gelar");
		String alamat = request.getParameter("alamat");
		
		/// instance guru
		GuruModel guruModel =  new GuruModel();
		
		guruModel.setNip(nip);
		guruModel.setNamaGuru(namaGuru);
		guruModel.setTelepon(telepon);
		guruModel.setGender(gender);
		guruModel.setGelar(gelar);
		guruModel.setAlamat(alamat);
		
		/// -- save  --- //
		guruService.createGuru(guruModel);
		
		this.ListGuru(model);
		
		String html = "/guru/guru";
		return html;
	}
	
	@RequestMapping("/delete/guru/{nip}")
	public String deleteGuru(@PathVariable(name="nip")String nip) {
		guruService.deleteGuru(nip);
		return "redirect:/guru"; 
	}
	
	public void ListGuru(Model model) {
		List<GuruModel> guruModelList = new ArrayList<GuruModel>();
		guruModelList = guruService.readData();
		model.addAttribute("guruModelList", guruModelList);
	}
}
