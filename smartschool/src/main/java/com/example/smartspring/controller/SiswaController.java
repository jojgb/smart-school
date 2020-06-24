package com.example.smartspring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.smartspring.model.SiswaModel;
import com.example.smartspring.service.SiswaService;

@Controller

public class SiswaController {
	@Autowired
	private SiswaService siswaService;
	
	@RequestMapping("/siswa")
	public String Siswa(Model model) {
		this.ListSiswa(model);
		String html = "/siswa";
		return html;
	}
	@RequestMapping("/addsiswa")
	public String AddSiswa() {
		String html = "/addsiswa";
		return html;
	}
	@RequestMapping("/createsiswa")
	public String CreateSiswa(HttpServletRequest request ,Model model)throws ParseException {
		String nimSiswa = request.getParameter("nim");
		String namaSiswa = request.getParameter("namasiswa");
		String jenisKelamin = request.getParameter("jeniskelamin");
		
		///---- tanggal lahir ---////
		String tanggalLahir = request.getParameter("tanggallahir");
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Date tanggalLahirDate = formatDate.parse(tanggalLahir);
		System.out.println(tanggalLahirDate);
		///---- tanggal lahir ---////
		
		String tempatLahir = request.getParameter("tempatlahir");
		String waliMurid = request.getParameter("walimurid");
		String pekerjaan = request.getParameter("pekerjaan");
		String teleponWali = request.getParameter("teleponwali");
		String alamatMurid = request.getParameter("alamatmurid");
		String kelas = request.getParameter("kelas");
		
		///// ------instance siswa model --------/////
		SiswaModel siswaModel = new SiswaModel();
		///// ------instance siswa model --------/////
		
		////  ---------- save ------- ////
		siswaModel.setNimSiswa(nimSiswa);
		siswaModel.setNamaSiswa(namaSiswa);
		siswaModel.setGender(jenisKelamin);
		siswaModel.setTanggalLahir(tanggalLahirDate);
		siswaModel.setTempatLahir(tempatLahir);
		siswaModel.setWaliMurid(waliMurid);
		siswaModel.setPekerjaan(pekerjaan);
		siswaModel.setTelpWaliMurid(teleponWali);
		siswaModel.setAlamatMurid(alamatMurid);
		siswaModel.setKelas(kelas);
		/// ----------- save  -------/////
		
		this.siswaService.createSiswa(siswaModel);
		// listnya
		this.ListSiswa(model);
		
		String html = "/siswa";
		return html;
	}
	
	public void ListSiswa(Model model) {
		List<SiswaModel> siswaModelList = new ArrayList<SiswaModel>();
		siswaModelList = siswaService.readData();
		model.addAttribute("siswaModelList", siswaModelList);
	}
}
