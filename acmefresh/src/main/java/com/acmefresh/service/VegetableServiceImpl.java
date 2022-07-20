package com.acmefresh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.exception.VegetableException;
import com.acmefresh.model.AdminSession;
import com.acmefresh.model.Vegetable;
import com.acmefresh.repository.AdminSessionDao;
import com.acmefresh.repository.VegetableDao;

@Service
public class VegetableServiceImpl implements VegetableService {

	@Autowired
	private VegetableDao vegetableDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;
	
	@Override
	public Vegetable saveVegetable(Vegetable vegetable, String key) throws VegetableException {
		// TODO Auto-generated method stub
		Optional<AdminSession> session  = adminSessionDao.findByUuid(key);
		if(session.isPresent()) {
			return vegetableDao.save(vegetable);
		}
		throw new VegetableException("Only admin can add vegetables.");
	}

	@Override
	public Vegetable updateVegetable(Vegetable vegetable, String key) throws VegetableException {
		// TODO Auto-generated method stub
		Optional<AdminSession> session  = adminSessionDao.findByUuid(key);
		if(session.isPresent()) {
			Optional<Vegetable> existingVegetable= vegetableDao.findByVegetableId(vegetable.getVegetableId());
			if(existingVegetable.isPresent()) {
				return vegetableDao.save(vegetable);
			}
			throw new VegetableException("Vegetable not found with vegetableId: "+vegetable.getVegetableId());
		}
		throw new VegetableException("Only admin can update vegetables.");
	}

	@Override
	public String deleteVegetable(Integer vegetableId, String key) throws VegetableException {
		// TODO Auto-generated method stub
		Optional<AdminSession> session  = adminSessionDao.findByUuid(key);
		if(session.isEmpty()) {
			throw new VegetableException("Only admin can delete vegetables.");
		}
		Optional<Vegetable> vegetable= vegetableDao.findByVegetableId(vegetableId);
		if(vegetable.isEmpty()) {
			throw new VegetableException("Vegetable not found with vegetableId: "+vegetableId);
		}
		vegetableDao.delete(vegetable.get());
		return "Vegetable deleted";
	}

	@Override
	public List<Vegetable> getAllVegetables() throws VegetableException {
		// TODO Auto-generated method stub
		List<Vegetable> vegetables= vegetableDao.findAll();
		if(vegetables.size()>0) {
			return vegetables;
		}
		throw new VegetableException("No vegetables found");
	}

}
