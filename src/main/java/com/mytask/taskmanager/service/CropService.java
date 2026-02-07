package com.mytask.taskmanager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mytask.taskmanager.model.Crop;
import com.mytask.taskmanager.repository.CropRepository;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public Crop saveCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public List<Crop> getCropsByFarmer(Long farmerId) {
        return cropRepository.findByFarmerId(farmerId);
    }
    
    public Crop updateCrop(Long cropId, Crop updatedCrop) {

        Crop existing = cropRepository.findById(cropId)
                .orElseThrow(() -> new RuntimeException("Crop not found"));

        existing.setCropName(updatedCrop.getCropName());
        existing.setQuantity(updatedCrop.getQuantity());
        existing.setPrice(updatedCrop.getPrice());

        return cropRepository.save(existing);
    }

    public void deleteCrop(Long cropId) {
        cropRepository.deleteById(cropId);
    }

    
}
