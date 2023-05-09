package cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.services;

import cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.dto.SucursalDto;
import cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.exceptions.ResourceNotFoundException;
import cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.model.Sucursal;
import cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.repository.SucursalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    private ModelMapper modelMapper;

    private SucursalRepository sucursalRepository;

    public SucursalServiceImpl(SucursalRepository sucursalRepository) {
        super();
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public List<SucursalDto> getAllSucursal() {
        return sucursalRepository.findAll().stream()
                .map(sucursal -> modelMapper.map(sucursal, SucursalDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SucursalDto getSucursalById(Integer id) {
        Optional<Sucursal> result;
        SucursalDto sucursalResponse;

        result = sucursalRepository.findById(id);

        if (result.isPresent()){
            sucursalResponse = modelMapper.map(result.get(), SucursalDto.class);
        } else {
            throw new ResourceNotFoundException("Sucursal", "id", id);
        }

        return sucursalResponse;

    }

    @Override
    public SucursalDto addSucursal() {
        SucursalDto sucursalDto;
        Sucursal sucursal = new Sucursal();

        sucursalDto = modelMapper.map(sucursal, SucursalDto.class);

        return sucursalDto;

    }

    @Override
    public SucursalDto createSucursal(SucursalDto requestSucursalDto) {
        Sucursal sucursalRequest;

        // converteixes DTO a entity per guardar a bbdd
        sucursalRequest = modelMapper.map(requestSucursalDto, Sucursal.class);

        sucursalRepository.save(sucursalRequest);

        // tornes DTO
        return modelMapper.map(sucursalRequest, SucursalDto.class);

    }

    @Override
    public SucursalDto updateSucursal(SucursalDto sentSucursalDto, Integer id) {
        Sucursal sucursalRequest;

        sucursalRequest = sucursalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal", "id", id));

        sucursalRequest.setName(sentSucursalDto.getName());
        sucursalRequest.setCountry(sentSucursalDto.getCountry());

        sucursalRepository.save(sucursalRequest);

        return modelMapper.map(sucursalRequest, SucursalDto.class);
    }

    @Override
    public void deleteSucursal(Integer id) {

        try {
            sucursalRepository.deleteById(id);
        } catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Sucursal", "id", id);
        }

    }
}
