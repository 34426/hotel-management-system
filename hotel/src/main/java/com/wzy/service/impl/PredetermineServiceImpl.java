package com.wzy.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.wzy.mapper.PredetermineMapper;
import com.wzy.page.Page;
import com.wzy.pojo.PredeterminePo;
import com.wzy.service.PredetermineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service(value="predetermineService")
public class PredetermineServiceImpl implements PredetermineService {

	@Autowired
	private PredetermineMapper predetermineMapper;
	
	@Override
	public int insertAll(PredeterminePo predeterminePo) {
		return predetermineMapper.insertAll(predeterminePo);
	}
	@Override
	public Page<PredeterminePo> pageFuzzyselect(String receiveTeamName,
												String passengerName, int predetermineStateID,
												Page<PredeterminePo> vo) {
		int start=0;
		if (vo.getCurrentPage()>1) {
			start=(vo.getCurrentPage()-1)*vo.getPageSize();
		}
		List<PredeterminePo> list= predetermineMapper.pageFuzzyselect(receiveTeamName,
				passengerName, predetermineStateID, start, vo.getPageSize());
		vo.setResult(list);
		int count= predetermineMapper.countFuzzyselect(receiveTeamName, passengerName, predetermineStateID);
		vo.setTotal(count);
		return vo;
	}
	@Override
	public PredeterminePo findById(Integer id) {
		return this.predetermineMapper.findById(id);
	}
	@Override
	public List<PredeterminePo> findLvKeId(Integer id) {
		return this.predetermineMapper.findLvKeId(id);
	}
	@Override
	public List<PredeterminePo> findTeamId(Integer id) {
		return this.predetermineMapper.findTeamId(id);
	}
	@Override
	public int deleteById(Integer id) {
		return this.predetermineMapper.deleteById(id);
	}
	@Override
	public List<PredeterminePo> selectAll() {
		return this.predetermineMapper.selectAll();
	}
	@Override
	public int updateRemind(Timestamp arriveTime,Integer id) {
		return this.predetermineMapper.updateRemind(arriveTime,id);
	}
	@Override
	public int updatePredetermineStateID(Timestamp arriveTime,Integer id) {
		return this.predetermineMapper.updatePredetermineStateID( arriveTime,id);
	}

}
