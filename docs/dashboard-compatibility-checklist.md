# Dashboard Gesportin - Compatibility Checklist

## Objetivo
- Confirmar que la integracion del dashboard no rompe la base del profesor.
- Dejar claro que los cambios se han hecho con criterio incremental y sin commit.
- Separar lo estable de lo que aun necesita permiso o revision.

## Ya verificado
- El proyecto frontend compila correctamente tras los ultimos ajustes.
- El error de Chart.js por `radialLinear` ya esta corregido.
- Las rutas de entrada conservan compatibilidad con el flujo actual.
- El login sigue usando hash SHA-256 solo en el frontend.
- El backend compara la contraseña recibida directamente contra la almacenada en BD.

## Patrones respetados
- Separacion de responsabilidades con `DashboardService`.
- Uso de `inject()` en componentes y servicios modernos.
- Guards por perfil para proteger rutas.
- Carga diferida de paginas de dashboard por perfil.
- Filtrado de datos sensibles segun rol.

## Riesgos controlados
- No tocar archivos compartidos de configuracion del proyecto.
- No hacer cambios de autenticacion sin permiso del profesor.
- No hacer commit hasta cerrar la revision tecnica.
- No ampliar mas el dashboard sin validar el impacto visual y de bundle.

## Puntos que conviene mencionar en PR
- El dashboard queda como mejora incremental sobre la base existente.
- Los usuarios demo siguen funcionando porque su password coincide con el hash esperado.
- Los demas usuarios de la BD no estan homogeneizados aun, y eso requiere autorizacion.
- La navegacion por perfil usa rutas explicitas para minimizar conflictos.

## Checklist final antes de continuar con otra ampliacion
- [x] Build del frontend sin errores.
- [x] Error de grafica radial corregido.
- [x] Rutas de entrada mantenidas de forma compatible.
- [x] Patron de hash entendido y documentado.
- [ ] Confirmar con profesor si se puede tocar autenticacion.
- [ ] Elegir una sola nueva ampliacion funcional.

## Proxima ampliacion sugerida
1. Filtros por fechas.
2. Exportar CSV o PDF.
3. Mejorar KPI por rol.