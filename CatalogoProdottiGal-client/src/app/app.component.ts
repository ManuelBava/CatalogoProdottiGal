import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Prodotto } from './prodotto';
import { RichiestaAServerDto } from './richiesta-a-server-dto';
import { RispostaDaServerDto } from './risposta-da-server-dto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  prodott = new Prodotto();
  prodotti: Prodotto[] = [];
  url = "http://localhost:8080/";

  constructor(private http: HttpClient) {
    // carica i dati della rubrica all'avvio
    this.aggiorna();
  }

  aggiungi() {
    // metto il contatto da inserire nel DTO
    let req = new RichiestaAServerDto();
    req.prodotto = this.prodott;

    // preparo la richiesta POST verso il server
    let ox: Observable<RispostaDaServerDto> = this.http
      .post<RispostaDaServerDto>(this.url + "inserisci", req);
    // invio la richiesta, avendole dato la callback
    ox.subscribe(r => {
      this.prodotti = r.catalogoProdotti;
    });
    // resetto l'oggetto associato al campo di input
    this.prodott = new Prodotto();
  }

  aggiorna() {
    // preparo la richiesta GET verso il server
    let ox: Observable<RispostaDaServerDto> = this.http
      .get<RispostaDaServerDto>(this.url + "leggi-catalogo");
    // invio la richiesta, avendole dato la callback
    ox.subscribe(r => {
      this.prodotti = r.catalogoProdotti;
    });
  }

  svuota() {
    // preparo la richiesta GET verso il server
    let ox: Observable<RispostaDaServerDto> = this.http
      .get<RispostaDaServerDto>(this.url + "svuota");
    // invio la richiesta, avendole dato la callback
    ox.subscribe(r => {
      this.prodotti = r.catalogoProdotti;
    });
   }

  cancella(p: Prodotto) {
    // metto il contatto da cancellare nel DTO
    let req = new RichiestaAServerDto();
    req.prodotto = p;

    // preparo la richiesta POST verso il server
    let ox: Observable<RispostaDaServerDto> = this.http
      .post<RispostaDaServerDto>(this.url + "cancella", req);
    // invio la richiesta, avendole dato la callback
    ox.subscribe(r => {
      this.prodotti = r.catalogoProdotti;
    });
   }
}
