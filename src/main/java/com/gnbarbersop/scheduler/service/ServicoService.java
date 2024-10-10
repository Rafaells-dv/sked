package com.gnbarbersop.scheduler.service;

import com.gnbarbersop.scheduler.dto.ServicoDto;
import com.gnbarbersop.scheduler.entity.ServicoEntity;
import com.gnbarbersop.scheduler.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public void create(ServicoDto dto){
        //Verifica se o um Servico com o nome já existe
        Optional<ServicoEntity> servicoAlreadyExist = servicoRepository.findByName(dto.name());
        if(servicoAlreadyExist.isPresent()){
            throw new RuntimeException("Servico already exist");
        }

        //Cria a entidade servico a partir do dto
        ServicoEntity newServico = new ServicoEntity(dto);

        servicoRepository.save(newServico);
    }
}
