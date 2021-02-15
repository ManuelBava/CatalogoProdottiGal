/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.CatalogoProdottiGal.controller;

import it.sirfin.CatalogoProdottiGal.dto.CatalogoProdottiDto;
import it.sirfin.CatalogoProdottiGal.dto.RichiestaProdottoDto;
import it.sirfin.CatalogoProdottiGal.model.Prodotto;
import it.sirfin.CatalogoProdottiGal.service.CatalogoProdottiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin ("*")
@RestController
public class CatalogoProdottiContoller {
    
    @Autowired
    CatalogoProdottiService catalogoService;
    @RequestMapping("/leggi-catalogo")
    @ResponseBody
    public CatalogoProdottiDto leggiCatalogo() {
        return new CatalogoProdottiDto(catalogoService.leggiCatalogo());
    }

    @RequestMapping("/inserisci")
    @ResponseBody
    public CatalogoProdottiDto inserisciProdotto(@RequestBody RichiestaProdottoDto dto) {
        // estraggo il contatto dal DTO
        Prodotto p = dto.getProdotto();
        // inserisco il contatto su DB e ottengo il DB aggiornato
        List<Prodotto> lista = catalogoService.inserisciProdotto(p);
        // creo un nuovo DTO per la risposta
        CatalogoProdottiDto risp = new CatalogoProdottiDto(lista);
        // ritorno il DTO
        return risp;
    }

    @RequestMapping("/cancella")
    @ResponseBody
    public CatalogoProdottiDto cancellaProdotto(@RequestBody RichiestaProdottoDto dto) {
        return new CatalogoProdottiDto(catalogoService.cancellaProdotto(dto.getProdotto()));
    }

    @RequestMapping("/svuota")
    @ResponseBody
    public CatalogoProdottiDto svuotaCatalogo() {
        return new CatalogoProdottiDto(catalogoService.svuotaCatalogo());
    }
        
}
