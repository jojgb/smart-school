package com.example.smartspring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartspring.model.SiswaModel;
import com.example.smartspring.service.SiswaService;

@RestController
@RequestMapping("/api/siswa")
public class SiswaApi {
	@Autowired
	private SiswaService siswaService;
	
	@PostMapping("/post")
	@ResponseStatus(code= HttpStatus.CREATED)
	public Map<String, Object> postMap(@RequestBody SiswaModel siswaModel) {
		
		this.siswaService.createSiswa(siswaModel);
		Map<String, Object> mapPost = new HashMap<String, Object>();
		mapPost.put("sukses", Boolean.TRUE);
		mapPost.put("pesan", "data berhasil masuk");
		return mapPost;
	}
	
	@GetMapping("/get")
	@ResponseStatus(code=HttpStatus.OK)
	public List<SiswaModel> getMap() {
		List<SiswaModel> siswaModelList = new ArrayList<SiswaModel>();
		siswaModelList = this.siswaService.readData();
		return siswaModelList;
	}
}
