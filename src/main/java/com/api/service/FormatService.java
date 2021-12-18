package com.api.service;

import com.api.entity.Format;
import com.api.repository.FormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormatService {
    @Autowired
    FormatRepository formatRepository;


    public List<Format> getAllFormats() {
        return formatRepository.findAll();
    }

    public Format getFormatById(int formatId) {
        Optional<Format> format = formatRepository.findById(formatId);
        if(format.isEmpty()) return null;
        return format.get();
    }

    public String addFormats(Format format) {
        try {
            formatRepository.save(format);
            return "Format Created";
        }catch (Exception e){
            return "Format Creation failed";
        }
    }

    public String addFormatsList(List<Format> formats) {
        try {
            formatRepository.saveAll(formats);
            return "Formats Created";
        }catch (Exception e){
            return "Format Creation failed";
        }
    }

    public String deleteFormat(int formatId) {
        Optional<Format> format = formatRepository.findById(formatId);
        if (format.isEmpty()) return "Format not found";
        try {
            formatRepository.delete(format.get());
            return "Format Deleted";
        }catch (Exception e){
            return "Format Delete Failed";
        }
    }

    public String updateFormat(int formatId, Format format) {
        Optional<Format> updateFormat = formatRepository.findById(formatId);
        if (updateFormat.isEmpty()) return "Format not found";
        try {
            updateFormat.get().setFormatName(format.getFormatName());
            updateFormat.get().setLimitedOvers(format.isLimitedOvers());
            updateFormat.get().setOvers(format.getOvers());
            formatRepository.save(updateFormat.get());
            return "Format Updated";
        }catch (Exception e){
            return "Format Update failed";
        }
    }
}
