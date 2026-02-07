package com.mytask.taskmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "crops")
public class Crop {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crop_seq_gen")
	@SequenceGenerator(
	        name = "crop_seq_gen",
	        sequenceName = "CROPS_SEQ",
	        allocationSize = 1
	)
	@Column(name = "crop_id")
	private Long cropId;


    @Column(name = "crop_name")
    private String cropName;

    private Double quantity;
    private Double price;

    @Column(name = "farmer_id")
    private Long farmerId;

    // ===== GETTERS & SETTERS =====

    public Long getCropId() {
        return cropId;
    }

    public void setCropId(Long cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }
}
