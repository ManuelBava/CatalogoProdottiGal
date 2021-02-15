/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.CatalogoProdottiGal.service;

import it.sirfin.CatalogoProdottiGal.model.Prodotto;
import java.util.List;


public interface CatalogoProdottiService {
    
    List<Prodotto> leggiCatalogo();

    List<Prodotto> inserisciProdotto(Prodotto p);

    List<Prodotto> cancellaProdotto(Prodotto p);
    
    List<Prodotto> svuotaCatalogo();
}
