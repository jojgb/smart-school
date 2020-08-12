package com.example.smartspring.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.smartspring.model.PelajaranModel;
import com.example.smartspring.model.SiswaModel;
import com.example.smartspring.repository.PelajaranRepository;
import com.example.smartspring.service.PelajaranService;

@Controller
public class PelajaranController {

	@Autowired
	private PelajaranService pelajaranService;
	
	@RequestMapping("/pelajaran")
	private String Pelajaran(Model model) {
		this.ListPelajaran(model);
		String html = "/pelajaran/pelajaran";
		return html;
	}
	////  ---  add  -----  ///
	@RequestMapping("/addpelajaran")
	private String AddPelajaran() {
		String html = "/pelajaran/addpelajaran";
		return html;
	}
	////  -----action di add nya  ---- ///// 
	@RequestMapping("/createpelajaran")
	public String CreatePelajaran(HttpServletRequest request , Model model) {
		String kodePelajaran = request.getParameter("kodepelajaran");
		String namaPelajaran = request.getParameter("namapelajaran");
		String tingkat = request.getParameter("tingkat");
		String jamAjar = request.getParameter("jamajar");
		String keterangan = request.getParameter("jamajar");
		
		// instance pelajaranModel
		PelajaranModel pelajaranModel = new PelajaranModel();
		
		pelajaranModel.setKodePelajaran(kodePelajaran);
		pelajaranModel.setNamaPelajaran(namaPelajaran);
		pelajaranModel.setTingkat(tingkat);
		pelajaranModel.setJamAjar(jamAjar);
		pelajaranModel.setKeterangan(keterangan);
		
		this.pelajaranService.createPelajaran(pelajaranModel);
		this.ListPelajaran(model);
		String html = "/pelajaran/pelajaran";
		return html;
	}
	@RequestMapping("detil/pelajaran/{KodePelajaran}")
	public ModelAndView detilPelajaran(@PathVariable(name="KodePelajaran")String KodePelajaran) {
		ModelAndView mav = new ModelAndView("/pelajaran/detilpelajaran");
		PelajaranModel pelajaranModel = pelajaranService.detilPelajaran(KodePelajaran);
		mav.addObject("pelajaranModel", pelajaranModel);
		return mav;
	}
	
	/// --- edit -----
	@RequestMapping("/edit/pelajaran/{KodePelajaran}")
	public ModelAndView EditSiswa(@PathVariable(name = "KodePelajaran") String KodePelajaran) {
		ModelAndView mav = new ModelAndView("/pelajaran/editpelajaran");
		PelajaranModel pelajaranModel = pelajaranService.editPelajaran(KodePelajaran);
		mav.addObject("pelajaranModel", pelajaranModel);
		return mav;
	}
	/// ---  action di form edit nya -----
	@RequestMapping("/updatepelajaran")
	public String updatePelajaran(HttpServletRequest request ,Model model) {
		
		String kodePelajaran = request.getParameter("kodepelajaran");
		String namaPelajaran = request.getParameter("namapelajaran");
		String tingkat = request.getParameter("tingkat");
		String jamAjar = request.getParameter("jamajar");
		String keterangan = request.getParameter("jamajar");
		
		// instance pelajaranModel
		PelajaranModel pelajaranModel = new PelajaranModel();
		
		pelajaranModel.setKodePelajaran(kodePelajaran);
		pelajaranModel.setNamaPelajaran(namaPelajaran);
		pelajaranModel.setTingkat(tingkat);
		pelajaranModel.setJamAjar(jamAjar);
		pelajaranModel.setKeterangan(keterangan);
		
		this.pelajaranService.createPelajaran(pelajaranModel);
		this.ListPelajaran(model);
		String html = "/pelajaran/pelajaran";
		return html;
	}
	/// ----  delete ---- /////
	@RequestMapping("delete/pelajaran/{KodePelajaran}")
	public String deletePelajaran(@PathVariable(name="KodePelajaran")String KodePelajaran) {
		pelajaranService.deletePelajaran(KodePelajaran);
		 return "redirect:/pelajaran"; 
	}
	
	
	public void ListPelajaran(Model model) {
		List<PelajaranModel> pelajaranModelList = new ArrayList<PelajaranModel>();
		pelajaranModelList = pelajaranService.readData();
		model.addAttribute("pelajaranModelList", pelajaranModelList);
	}
}
