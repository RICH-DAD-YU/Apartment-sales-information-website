package com.mycom.happy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.happy.dto.Dong;
import com.mycom.happy.dto.Gugun;
import com.mycom.happy.dto.HouseDeal;
import com.mycom.happy.dto.HouseInfo;
import com.mycom.happy.dto.Sido;
import com.mycom.happy.service.HouseService;

@RestController
@CrossOrigin(
		// localhost:5500 과 127.0.0.1 구분
		origins = "http://localhost:5500", //allowCredentials = "true" 인 경우, origins="*" 는 X
		allowCredentials = "true",
		allowedHeaders = "*",
		methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS}
)
public class HouseController {
   
   @Autowired
   private HouseService houseService;
   
   @GetMapping("/sido")
   public ResponseEntity<List<Sido>> sido() throws Exception {
      return new ResponseEntity<List<Sido>>(houseService.getSido(), HttpStatus.OK);
   }

   @GetMapping("/gugun/{sido_code}")
   public ResponseEntity<List<Gugun>> gugun(@PathVariable String sido_code) throws Exception {
      return new ResponseEntity<List<Gugun>>(houseService.getGugun(sido_code), HttpStatus.OK);
   }
   
   @GetMapping("/dong/{gugun_code}")
   public ResponseEntity<List<Dong>> dong(@PathVariable String gugun_code) throws Exception {
      return new ResponseEntity<List<Dong>>(houseService.getDong(gugun_code), HttpStatus.OK);
   }
   
   @GetMapping("/search/{dong}")
   public ResponseEntity<List<HouseInfo>> search(@PathVariable String dong) throws Exception {
      return new ResponseEntity<List<HouseInfo>>(houseService.search(dong), HttpStatus.OK);
   }
   
   @GetMapping("/detail/{houseNo}")
   public ResponseEntity<List<HouseDeal>> detail(@PathVariable int houseNo) throws Exception {
      return new ResponseEntity<List<HouseDeal>>(houseService.detail(houseNo), HttpStatus.OK);
   }
   
   @GetMapping("/NameSearch/{name}")
   public ResponseEntity<List<HouseInfo>> NameSearch(@PathVariable String name) throws Exception {
      return new ResponseEntity<List<HouseInfo>>(houseService.NameSearch(name), HttpStatus.OK);
   }
   
   @GetMapping("/houseDetail/{no}")
   public ResponseEntity<HouseInfo> houseDetail(@PathVariable int no) throws Exception {
      return new ResponseEntity<HouseInfo>(houseService.houseDetail(no), HttpStatus.OK);
   }
}