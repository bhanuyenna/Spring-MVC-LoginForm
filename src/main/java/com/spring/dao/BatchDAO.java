package com.spring.dao;

import java.util.List;

import com.spring.model.Batch;

public interface BatchDAO {
	public void save(Batch batch);

	public void updateBatch(Batch batch);

	public void deleteBatch(int id);

	public List<Batch> batchList();

	public Batch getByBatchID(int id);

}
