package foe.fuelpass.fuel_quota_service.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuelQuotaOutputDto {
    private int availableQuota;

    public FuelQuotaOutputDto(int availableQuota){
        this.availableQuota = availableQuota;
    }
}
