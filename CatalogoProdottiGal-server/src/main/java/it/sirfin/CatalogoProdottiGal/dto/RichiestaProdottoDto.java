/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.sirfin.CatalogoProdottiGal.dto;

import it.sirfin.CatalogoProdottiGal.model.Prodotto;


public class RichiestaProdottoDto {
    private Prodotto prodotto;

    public RichiestaProdottoDto() {
    }

    public RichiestaProdottoDto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @Override
    public String toString() {
        return "RichiestaProdottiDto{" + "prodotto=" + prodotto + '}';
    }
    
}
