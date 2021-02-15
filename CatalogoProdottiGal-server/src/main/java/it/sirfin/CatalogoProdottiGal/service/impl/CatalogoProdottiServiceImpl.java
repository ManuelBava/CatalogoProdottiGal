/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.CatalogoProdottiGal.service.impl;

import it.sirfin.CatalogoProdottiGal.model.Prodotto;
import it.sirfin.CatalogoProdottiGal.repository.ProdottoRepository;
import it.sirfin.CatalogoProdottiGal.service.CatalogoProdottiService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogoProdottiServiceImpl implements CatalogoProdottiService {

    @Autowired
    ProdottoRepository prodottoRepository;

    @Override
    public List<Prodotto> leggiCatalogo() {
        return prodottoRepository.findAll();
    }

    @Override
    public List<Prodotto> inserisciProdotto(Prodotto p) {
        prodottoRepository.save(p);
        return leggiCatalogo();
    }

    @Override
    public List<Prodotto> cancellaProdotto(Prodotto p) {
        prodottoRepository.delete(p);
        return leggiCatalogo();
    }

    @Override
    public List<Prodotto> svuotaCatalogo() {
        prodottoRepository.deleteAllInBatch();
        return new ArrayList<>();
    }

}
