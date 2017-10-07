package com.spring.service;

import java.util.List;

import com.spring.model.Batch;

public interface BatchService{
	public void save(Batch batch);
	public void updateBatch(Batch batch);
	public void deleteBatch(int id);
	public List<Batch> batchList();
	public Batch getByBatchID(int id);
}
