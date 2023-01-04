package org.zerock.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/sample")
public class SampleController {

	/*
	 * @RequestMapping("") public void <String> basic() {
	 * log.info("basic..................."); }
	 */
	
	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGetOrPost() {
		log.info("basic get or post...................");
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get2...................");
	}

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("nName")String name, @RequestParam("nAge")String age) {
		
		log.info("/ex02 - name : "+name+" / "+"age : "+age);
		
		return "ex02";
	}
	
	@GetMapping("/ex03List")
	public String ex03(@RequestParam("ids")ArrayList<String> ids) {
		
		log.info("/ex03List - ids : "+ ids);
		
		return "ex03";
	}
	
	@GetMapping("/ex04Array")
	public String ex04(@RequestParam("ids")String[] ids) {
		
		log.info("/ex04Array - ids :"+Arrays.toString(ids));
		
		return "ex04";
	}
	
	@GetMapping("/ex05Bean")
	public String ex04(SampleDTOList list) {
		
		log.info("/ex05Bean - list :"+list);
		
		return "ex05Bean";
	}
	
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateFormat, false)); }
	 */
	@GetMapping("/ex06")
	public String ex06(TodoDTO todo) {
		
		log.info("/ex06 - todo :"+todo);
		
		return "ex06";
	}
	
	@GetMapping("/ex07")
	public String ex07(TodoDTO todo) {
		
		log.info("/ex07 - todo :"+todo);
		
		return "ex07";
	}
	
	@GetMapping("/ex08")
	public String ex08(SampleDTO dto,int page) {
		
		log.info("/ex08 -SampleDTO todo :"+dto);
		log.info("/ex08 - int page :"+page);
		
		return "sample/ex08";
	}
	
	@GetMapping("/ex08_2")
	public String ex082(SampleDTO dto,@ModelAttribute("page")int page) {
		
		log.info("/ex08_2 -SampleDTO todo :"+dto);
		log.info("/ex08_2 - int page :"+page);
		
		return "simple/ex08";
	}
	
	@GetMapping("/jacksonBind")
	public @ResponseBody SampleDTO jacksonBind() {	
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto;
	}
	
	@GetMapping("/ResponseEntity")
	public ResponseEntity<String> ResonseEntity() {	
		
		log.info("ResponseEntity");
		String msg = "{\"name\": \"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("content-Type", "application/json;charset=utf-8");
		return new ResponseEntity<>(msg,header,HttpStatus.OK);

	}
	
	@GetMapping("/exUpload")
	public void exUpload() {			
		log.info("exUpload-------");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {			
		log.info("exUploadPost----------------");
		files.forEach(file->{
			log.info("------------------");
			String filename = null;
			try {
				filename = new String(file.getOriginalFilename().getBytes("8859_1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("name: "+ filename);
			log.info("size:" + file.getSize());
		});
	}

}
