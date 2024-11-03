package com.futebol.webapp.service;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import org.springframework.stereotype.Service;

import com.futebol.webapp.dto.PartidaCSV;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class PartidaService {

    public List<PartidaCSV> lerPartidasCSV(String caminhoDoArquivo) {
        try (Reader reader = new FileReader(caminhoDoArquivo)) {
            CsvToBean<PartidaCSV> csvToBean = new CsvToBeanBuilder<PartidaCSV>(reader)
                    .withType(PartidaCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(',') // Use o separador apropriado (ponto e vírgula ou vírgula)
                    .build();

            return csvToBean.parse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
