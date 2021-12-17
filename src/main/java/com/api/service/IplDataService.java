package com.api.service;

import com.api.entity.Ipldata;
import com.api.repository.IplDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IplDataService {
    @Autowired
    IplDataRepository iplDataRepository;

    public String saveIplData(List<Ipldata> listOfIplData) {
        try{
            iplDataRepository.saveAll(listOfIplData);
            return "Successful: Data Saved";
        }catch (Exception e){
            return "Error: saving data";
        }
    }
}
