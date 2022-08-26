package com.mycom.happy.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.happy.dto.Dong;
import com.mycom.happy.dto.Gugun;
import com.mycom.happy.dto.HouseDeal;
import com.mycom.happy.dto.HouseInfo;
import com.mycom.happy.dto.Sido;


@Mapper
public interface HouseDao {
	
	List<HouseInfo> search(String dong) throws SQLException;
	List<Sido> getSidoList() throws SQLException;
	List<Gugun> getGugunList(String sido_code) throws SQLException;
	List<Dong> getDongList(String gugun_code) throws SQLException;
	List<HouseDeal> detail(int houseNo) throws SQLException;
	List<HouseInfo> NameSearch(String name) throws SQLException;
	HouseInfo houseDetail(int no) throws SQLException;
}
