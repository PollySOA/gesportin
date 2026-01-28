import { Component } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { IPage } from '../../../model/plist';
import { ICuota } from '../../../model/cuota';
import { CuotaService } from '../../../service/cuota';
import { Paginacion } from "../../shared/paginacion/paginacion";
import { BotoneraRpp } from "../../shared/botonera-rpp/botonera-rpp";
import { DatetimePipe } from "../../../pipe/datetime-pipe";

@Component({
  selector: 'app-cuota-plist',
  imports: [Paginacion, BotoneraRpp, DatetimePipe],
  templateUrl: './cuota-plist.html',
  styleUrl: './cuota-plist.css',
})
export class CuotaPlist {
  oPage: IPage<ICuota> | null = null;
  numPage: number = 0;
  numRpp: number = 5;
  rellenaCantidad: number = 20;
  rellenando: boolean = false;
  rellenaOk: number | null = null;
  rellenaError: string | null = null;
  totalElementsCount: number = 0;

  constructor(private oCuotaService: CuotaService) { }

  oBotonera: string[] = [];
  orderField: string = 'id';
  orderDirection: string = 'asc';

  ngOnInit() {
    this.getPage();
  }

  getPage() {
    this.oCuotaService.getPage(this.numPage, this.numRpp, this.orderField, this.orderDirection).subscribe({
      next: (data: IPage<ICuota>) => {
        this.oPage = data;
        this.totalElementsCount = data.totalElements ?? 0;
        this.rellenaOk = this.totalElementsCount;
        if (this.numPage > 0 && this.numPage >= data.totalPages) {
          this.numPage = data.totalPages - 1;
          this.getPage();
        }
      },
      error: (error: HttpErrorResponse) => {
        console.error(error);
      },
    });
  }

  onOrder(order: string) {
    if (this.orderField === order) {
      this.orderDirection = this.orderDirection === 'asc' ? 'desc' : 'asc';
    } else {
      this.orderField = order;
      this.orderDirection = 'asc';
    }
    this.numPage = 0;
    this.getPage();
    return false;
  }

  goToPage(numPage: number) {
    this.numPage = numPage;
    this.getPage();
    return false;
  }

  onRppChange(n: number) {
    this.numRpp = n;
    this.numPage = 0;
    this.getPage();
    return false;
  }

  onCantidadChange(value: string) {
    this.rellenaCantidad = +value;
    return false;
  }

  generarFake() {
    this.rellenaOk = null;
    this.rellenaError = null;
    this.rellenando = true;
    this.oCuotaService.rellenaCuota(this.rellenaCantidad).subscribe({
      next: (count: number) => {
        this.rellenando = false;
        this.rellenaOk = count;
        this.getPage();
      },
      error: (err: HttpErrorResponse) => {
        this.rellenando = false;
        this.rellenaError = 'Error generando datos fake';
        console.error(err);
      }
    });
  }
}
