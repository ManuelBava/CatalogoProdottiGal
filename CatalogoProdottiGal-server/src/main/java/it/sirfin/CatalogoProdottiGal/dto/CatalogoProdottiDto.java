/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.sirfin.CatalogoProdottiGal.dto;

import it.sirfin.CatalogoProdottiGal.model.Prodotto;
import java.util.List;


public class CatalogoProdottiDto {
    private List<Prodotto> CatalogoProdotti;

    public CatalogoProdottiDto() {
    }

    public CatalogoProdottiDto(List<Prodotto> CatalogoProdotti) {
        this.CatalogoProdotti = CatalogoProdotti;
    }

    public List<Prodotto> getCatalogoProdotti() {
        return CatalogoProdotti;
    }

    public void setCatalogoProdotti(List<Prodotto> CatalogoProdotti) {
        this.CatalogoProdotti = CatalogoProdotti;
    }

    @Override
    public String toString() {
        return "CatalogoProdottoDto{" + "CatalogoProdotti=" + CatalogoProdotti + '}';
    }  
}
