package foe.fuelpass.fuel_quota_service.Dto;

public class AddUserDto {
    private Long vehicleId;
    private int quota; // Fuel quota in liters

    public AddUserDto(Long vehicleId, int quota){
        this.vehicleId = vehicleId;
        this.quota = quota;
    }
}
