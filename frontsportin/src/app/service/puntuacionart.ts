import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IPuntuacionart } from '../model/puntuacionart';
import { IPage } from '../model/plist';
import { serverURL } from '../environment/environment';
import { PayloadSanitizerService } from './payload-sanitizer';

@Injectable({
  providedIn: 'root',
})
export class PuntuacionartService {
  constructor(
    private oHttp: HttpClient,
    private sanitizer: PayloadSanitizerService,
  ) {}

  getPage(
    page: number,
    rpp: number,
    order: string = 'id',
    direction: string = 'asc',
    id_articulo: number = 0,
    id_usuario: number = 0,
  ): Observable<IPage<IPuntuacionart>> {
    if (id_articulo > 0) {
      return this.oHttp.get<IPage<IPuntuacionart>>(
        `${serverURL}/puntuacionart?page=${page}&size=${rpp}&sort=${order},${direction}&id_articulo=${id_articulo}`,
      );
    }
    if (id_usuario > 0) {
      return this.oHttp.get<IPage<IPuntuacionart>>(
        `${serverURL}/puntuacionart?page=${page}&size=${rpp}&sort=${order},${direction}&id_usuario=${id_usuario}`,
      );
    }
    return this.oHttp.get<IPage<IPuntuacionart>>(
      `${serverURL}/puntuacionart?page=${page}&size=${rpp}&sort=${order},${direction}`,
    );
  }

  get(id: number): Observable<IPuntuacionart> {
    return this.oHttp.get<IPuntuacionart>(`${serverURL}/puntuacionart/${id}`);
  }

  create(puntuacionart: Partial<IPuntuacionart>): Observable<IPuntuacionart> {
    const body = this.sanitizer.sanitize(puntuacionart, { nestedIdFields: ['articulo', 'usuario'] });
    return this.oHttp.post<IPuntuacionart>(`${serverURL}/puntuacionart`, body);
  }

  update(puntuacionart: Partial<IPuntuacionart>): Observable<IPuntuacionart> {
    const body = this.sanitizer.sanitize(puntuacionart, { nestedIdFields: ['articulo', 'usuario'] });
    return this.oHttp.put<IPuntuacionart>(`${serverURL}/puntuacionart`, body);
  }

  delete(id: number): Observable<number> {
    return this.oHttp.delete<number>(`${serverURL}/puntuacionart/${id}`);
  }
}
