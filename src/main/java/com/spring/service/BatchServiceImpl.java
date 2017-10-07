package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BatchDAO;
import com.spring.model.Batch;

public class BatchServiceImpl implements BatchService {
@Autowired
private BatchDAO batchDAO;
public void setBatchDAO(BatchDAO batchDAO) {
	this.batchDAO = batchDAO;
}

	@Override
	@Transactional
	public void save(Batch batch) {
		batchDAO.save(batch);
	}

	@Override
	@Transactional
	public void updateBatch(Batch batch) {
		batchDAO.updateBatch(batch);
	}

	@Override
	@Transactional
	public void deleteBatch(int id) {
		batchDAO.deleteBatch(id);
	}

	@Override
	@Transactional
	public List<Batch> batchList() {
		
		return batchDAO.batchList();
	}

	@Override
	@Transactional
	public Batch getByBatchID(int id) {
		
		return batchDAO.getByBatchID(id);
	}

}
