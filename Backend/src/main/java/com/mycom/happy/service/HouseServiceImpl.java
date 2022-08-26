package com.mycom.happy.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.happy.dao.HouseDao;
import com.mycom.happy.dto.Dong;
import com.mycom.happy.dto.Gugun;
import com.mycom.happy.dto.HouseDeal;
import com.mycom.happy.dto.HouseInfo;
import com.mycom.happy.dto.Sido;

@Service
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	private HouseDao dao;
	
    @Override
    public List<Sido> getSido() throws SQLException {
        return dao.getSidoList();
    }
	
	@Override
	public List<Gugun> getGugun(String sido_code) throws SQLException {
		return dao.getGugunList(sido_code);
	}

	@Override
	public List<Dong> getDong(String gugun_code) throws SQLException {
		return dao.getDongList(gugun_code);
	}

	@Override
	public List<HouseInfo> search(String dong) throws SQLException {
		return dao.search(dong);
	}

	
	@Override
	public List<HouseDeal> detail(int house_no) throws SQLException {
		return dao.detail(house_no);
	}

	@Override
	public List<HouseInfo> NameSearch(String name) throws SQLException {
		return dao.NameSearch(name);
	}
	
	  @Override
	   public HouseInfo houseDetail(int no) throws SQLException {
	      return dao.houseDetail(no);
	   }
}
