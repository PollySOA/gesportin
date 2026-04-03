import { IArticulo } from './articulo';
import { IUsuario } from './usuario';

export interface IPuntuacionart {
  id: number;
  puntuacion: number;
  articulo: IArticulo;
  usuario: IUsuario;
}
