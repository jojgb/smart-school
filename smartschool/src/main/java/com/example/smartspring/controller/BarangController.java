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

import com.example.smartspring.model.BarangModel;
import com.example.smartspring.service.BarangService;

@Controller
public class BarangController {
	@Autowired
	private BarangService barangService;
	
	@RequestMapping("/barang")
	public String BarangView(Model model) {
		this.ListBarang(model);
		String html = "/barang/barang";
		return html;
	}
	
	@RequestMapping("/addbarang")
	public String addBarang() {
		String html = "/barang/addbarang";
		return html;
	}
	
	@RequestMapping("/createbarang")
	public String createBarang(HttpServletRequest request , Model model) {
		String kodeBarang = request.getParameter("kodebarang");
		String namaBarang = request.getParameter("namabarang");
		String satuan = request.getParameter("satuan");
		String hargaSiswa = request.getParameter("hargasiswa");
		String keterangan = request.getParameter("keterangan");
		
		// instance barang model
		BarangModel barangModel =  new BarangModel();
		
		barangModel.setKodeBarang(kodeBarang);
		barangModel.setNamaBarang(namaBarang);
		barangModel.setSatuan(satuan);
		barangModel.setHargaSiswa(hargaSiswa);
		barangModel.setKeterangan(keterangan);
		
		this.barangService.createBarang(barangModel);
		
		this.ListBarang(model);
		
		
		String html = "barang/barang";
		return html;
	}
	
	@RequestMapping("/detil/barang/{kodeBarang}")
	public ModelAndView detilBarang(@PathVariable(name="kodeBarang")String kodeBarang) {
		ModelAndView mav = new ModelAndView("/barang/detilbarang");
		BarangModel barangModel = barangService.detilBarang(kodeBarang);
		mav.addObject("barangModel", barangModel);
		return mav;
	}
	
	@RequestMapping("/edit/barang/{kodeBarang}")
	public ModelAndView editBarang(@PathVariable(name="kodeBarang")String kodeBarang) {
		ModelAndView mav = new ModelAndView("/barang/editbarang");
		BarangModel barangModel = barangService.editBarang(kodeBarang);
		mav.addObject("barangModel", barangModel);
		return mav;
	}
	
	
	
	@RequestMapping("/updatebarang")
	public String updateBarang(HttpServletRequest request , Model model) {
		String kodeBarang = request.getParameter("kodebarang");
		String namaBarang = request.getParameter("namabarang");
		String satuan = request.getParameter("satuan");
		String hargaSiswa = request.getParameter("hargasiswa");
		String keterangan = request.getParameter("keterangan");
		
		// instance barang model
		BarangModel barangModel =  new BarangModel();
		
		barangModel.setKodeBarang(kodeBarang);
		barangModel.setNamaBarang(namaBarang);
		barangModel.setSatuan(satuan);
		barangModel.setHargaSiswa(hargaSiswa);
		barangModel.setKeterangan(keterangan);
		
		this.barangService.createBarang(barangModel);
		
		this.ListBarang(model);
		
		
		String html = "barang/barang";
		return html;
	}
	
	@RequestMapping("/delete/barang/{kodeBarang}")
	public String deleteBarang(String kodeBarang) {
		barangService.deleteBarang(kodeBarang);
		return "redirect:/barang";
	}
	
	public void ListBarang(Model model) {
		List<BarangModel> barangModelList = new ArrayList<BarangModel>();
		barangModelList = barangService.readData();
		model.addAttribute("barangModelList", barangModelList);
	}
}

