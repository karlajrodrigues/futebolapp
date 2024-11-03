package com.futebol.webapp.service;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futebol.webapp.dto.PartidaCSV;
import com.futebol.webapp.model.Arena;
import com.futebol.webapp.repository.ArenaRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class ImportacaoService {
    @Autowired
    private ArenaRepository arenaRepository;

    public List<Arena> importarArena(String caminhoDoArquivo) {
        try (Reader reader = new FileReader(caminhoDoArquivo)) {
            CsvToBean<PartidaCSV> csvToBean = new CsvToBeanBuilder<PartidaCSV>(reader)
                    .withType(PartidaCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(',') // Use o separador apropriado (ponto e vírgula ou vírgula)
                    .build();

            for (PartidaCSV partida : csvToBean.parse()) { 
                // Processa a partida
                boolean buscaArena =  arenaRepository.existsByNome(partida.getArena());
                if(partida.getArena() != null && !buscaArena){
                    Arena arena = new Arena();
                    arena.setNome(partida.getArena()); 
                    arena.setEstado(partida.getMandante_estado());

                    arenaRepository.save(arena);
                }
                
            }
            
            return arenaRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
