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

import com.example.smartspring.model.KelasModel;
import com.example.smartspring.service.KelasService;

@Controller
public class KelasController {
	@Autowired
	private KelasService kelasService;
	
	@RequestMapping("/kelas")
	public String KelasView(Model model) {
		this.ListKelas(model);
		String html = "/kelas/kelas";
		return html;
	}
	
	@RequestMapping("/addkelas")
	public String addKelas() {
		String html = "/kelas/addkelas";
		return html;
	}
	
	@RequestMapping("/createkelas")
	public String createKelas(HttpServletRequest request , Model model) {
		String kodeKelas = request.getParameter("kodekelas");
		String namaKelas = request.getParameter("namakelas");
		String waliKelas = request.getParameter("walikelas");
		String tingkat  = request.getParameter("tingkat");
		String ruang  = request.getParameter("ruang");
		
		//// instance kelas model ///
		
		KelasModel kelasModel = new KelasModel();
		
		kelasModel.setKodeKelas(kodeKelas);
		kelasModel.setNamaKelas(namaKelas);
		kelasModel.setRuang(ruang);
		kelasModel.setTingkat(tingkat);
		kelasModel.setWaliKelas(waliKelas);
		
		kelasService.createKelas(kelasModel);
		this.ListKelas(model);
		
		String html = "/kelas/kelas";
		return html;
	}
	
	@RequestMapping("/detil/kelas/{kodeKelas}")
	public ModelAndView detilKelas(@PathVariable(name="kodeKelas")String kodeKelas) {
		ModelAndView mav =  new ModelAndView("/kelas/detilkelas");
		KelasModel kelasModel = kelasService.detilKelas(kodeKelas);
		mav.addObject("kelasModel", kelasModel);
		return mav;
		
	}
	
	@RequestMapping("/edit/kelas/{kodeKelas}")
	public ModelAndView editKelas(@PathVariable(name="kodeKelas")String kodeKelas) {
		ModelAndView mav =  new ModelAndView("/kelas/editkelas");
		KelasModel kelasModel = kelasService.editKelas(kodeKelas);
		mav.addObject("kelasModel", kelasModel);
		return mav;
		
	}
	
	@RequestMapping("/updatekelas")
	public String updateKelas(HttpServletRequest request , Model model) {
		String kodeKelas = request.getParameter("kodekelas");
		String namaKelas = request.getParameter("namakelas");
		String waliKelas = request.getParameter("walikelas");
		String tingkat  = request.getParameter("tingkat");
		String ruang  = request.getParameter("ruang");
		
		//// instance kelas model ///
		
		KelasModel kelasModel = new KelasModel();
		
		kelasModel.setKodeKelas(kodeKelas);
		kelasModel.setNamaKelas(namaKelas);
		kelasModel.setRuang(ruang);
		kelasModel.setTingkat(tingkat);
		kelasModel.setWaliKelas(waliKelas);
		
		kelasService.createKelas(kelasModel);
		this.ListKelas(model);
		
		String html = "/kelas/kelas";
		return html;
	}
	
	public String deleteKelas(String kodeKelas) {
		kelasService.deleteKelas(kodeKelas);
		return "redirect:/kelas";
	}
	
	public void ListKelas(Model model) {
		List<KelasModel> kelasModelList = new ArrayList<KelasModel>();
		kelasModelList = kelasService.readData();
		model.addAttribute("kelasModelList", kelasModelList);
	}
}
