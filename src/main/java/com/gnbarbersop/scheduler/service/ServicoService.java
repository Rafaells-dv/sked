package com.gnbarbersop.scheduler.service;

import com.gnbarbersop.scheduler.dto.ServicoDto;
import com.gnbarbersop.scheduler.entity.ServicoEntity;
import com.gnbarbersop.scheduler.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
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


    public Collection<ServicoEntity> getAll(){
        return servicoRepository.findAll();
    }

    public ServicoEntity getById(String servicoId){
        Optional<ServicoEntity> servicoExist = servicoRepository.findById(servicoId);
        if(servicoExist.isEmpty()){
            throw new RuntimeException("Servico nao existe");
        }
        return servicoExist.get();
    }

    public void update(ServicoDto dto, String servicoId) {
        try {
            //Verifica se o Servico desejado existe
            Optional<ServicoEntity> servicoExist = servicoRepository.findById(servicoId);
            if (servicoExist.isEmpty()) {
                throw new RuntimeException("Servico não encontrado");
            }

            //Verifica se algum Servico já possui o nome desejado
            Optional<ServicoEntity> servicoNameAlreadyExist = servicoRepository.findByName(dto.name());
            if (servicoNameAlreadyExist.isPresent()) {
                throw new RuntimeException("Um serviço já possui este nome");
            }


            ServicoEntity servico = servicoExist.get();
            servico.setName(dto.name());
            servico.setDuration(dto.duration());
            servico.setPrice(dto.price());
            servicoRepository.save(servico);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteById(String servicoId) {
        Optional<ServicoEntity> servicoExist = servicoRepository.findById(servicoId);
        if(servicoExist.isEmpty()){
            throw new RuntimeException("Servico não existe");
        }

        servicoRepository.deleteById(servicoId);
    }
}
