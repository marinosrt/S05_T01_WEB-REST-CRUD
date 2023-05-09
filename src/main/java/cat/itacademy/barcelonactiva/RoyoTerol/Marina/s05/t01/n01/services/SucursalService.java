package cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.services;

import cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.dto.SucursalDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SucursalService {

    List<SucursalDto> getAllSucursal();

    SucursalDto addSucursal();

    SucursalDto getSucursalById(Integer id);

    SucursalDto createSucursal(SucursalDto requestSucursalDto);

    SucursalDto updateSucursal(SucursalDto sentSucursalDto, Integer id);

    void deleteSucursal(Integer id);

}
