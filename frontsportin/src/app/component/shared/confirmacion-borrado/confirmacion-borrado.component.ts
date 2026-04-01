import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-confirmacion-borrado',
  standalone: true,
  template: `
    <div class="alert alert-danger d-flex flex-column m-3" role="alert">
      <div class="m-2">
        <i class="bi bi-exclamation-triangle-fill me-2" aria-hidden="true"></i>
        <strong>{{ title }}</strong>
        <span class="d-block d-sm-inline"> {{ message }}</span>
      </div>
      <div class="d-flex justify-content-end gap-2 m-3">
        <button class="btn btn-danger" (click)="onConfirm()">
          <i class="bi bi-trash me-2"></i>{{ confirmLabel }}
        </button>
        <button class="btn btn-secondary" (click)="onCancel()">
          <i class="bi bi-x-lg me-2"></i>{{ cancelLabel }}
        </button>
      </div>
    </div>
  `,
  styles: [
    `
      .alert .bi { font-size: 1.15rem; vertical-align: middle; }
      .alert { padding: 0.6rem; border-radius: 0.5rem; }
      @media (max-width: 575.98px) {
        .alert { padding: 0.4rem; }
      }
    `,
  ],
})
export class ConfirmacionBorradoComponent {
  @Input() title = '¿Seguro que desea eliminar esta temporada?';
  @Input() message = 'Esta acción no se puede deshacer.';
  @Input() confirmLabel = 'Eliminar';
  @Input() cancelLabel = 'Cancelar';

  @Output() confirm = new EventEmitter<void>();
  @Output() cancel = new EventEmitter<void>();

  onConfirm(): void { this.confirm.emit(); }
  onCancel(): void { this.cancel.emit(); }
}
