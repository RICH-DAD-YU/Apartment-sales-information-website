package com.mycom.happy.service;

import java.sql.SQLException;
import java.util.List;

import com.mycom.happy.dto.*;

public interface HouseService {
	List<Gugun> getGugun(String sido_code) throws SQLException;
	List<Sido> getSido() throws SQLException;
	List<Dong> getDong(String gugun_code) throws SQLException;
	List<HouseInfo> search(String dong) throws SQLException;
	List<HouseDeal> detail(int house_no) throws SQLException;
	List<HouseInfo> NameSearch(String name) throws SQLException;
	HouseInfo houseDetail(int no) throws SQLException;
}
