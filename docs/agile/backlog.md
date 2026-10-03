# Backlog Ágil – Módulo de Ventas

## Información general
- **Proyecto:** Requerimientos Ágiles, BDD, UX/UI y Desarrollo Inicial de API
- **Módulo:** Ventas
- **Rol:** Product Owner
- **Priorización:** MoSCoW
- **Estimación:** Story Points, escala Fibonacci
- **Tablero:** [Pendiente: enlace público de Jira o GitHub Projects]

> Este backlog se basa en los endpoints definidos para el módulo de ventas. **No incluye gestión de inventario**, porque dicha funcionalidad no forma parte del alcance establecido.**

## 1. Épicas

### Épica 1 – Autenticación y acceso
Autenticación de usuarios y acceso seguro a las operaciones protegidas.

### Épica 2 – Pagos y transacciones
Procesamiento de cobros de las ventas.

### Épica 3 – Consulta y seguimiento de ventas
Consulta del historial de ventas por vendedor y del historial de compras de clientes.

### Épica 4 – Garantías y soporte
Validación de existencia y vigencia de garantías asociadas a ventas.

### Épica 5 – Indicadores y resumen de ventas
Consulta de información consolidada e indicadores de ventas por período.

## 2. Mínimo Producto Viable (MVP)

El MVP se define a partir de las funcionalidades representadas por los endpoints del módulo:

1. Autenticación y emisión de JWT.
2. Procesamiento de pagos.
3. Historial de ventas por vendedor.
4. Validación de garantía.
5. Historial de compras de cliente.
6. Resumen e indicadores de ventas por período.

**Fuera del alcance:** gestión de inventario y funcionalidades no representadas por los endpoints definidos.

## 3. Historias de Usuario

### HU-01 – Autenticación de usuario
**Endpoint:** `POST /auth/login`

> **Como usuario autorizado, quiero iniciar sesión con mis credenciales para acceder de forma segura a las funcionalidades del módulo de ventas.**

**Prioridad:** Must Have  
**Story Points:** 3

**Justificación:** Necesaria para controlar el acceso y obtener el token JWT.

### HU-02 – Procesamiento de pago
**Endpoint:** `POST /payments/process`

> **Como vendedor, quiero procesar el pago de una venta para completar de forma segura la transacción realizada por el cliente.**

**Prioridad:** Must Have  
**Story Points:** 5

**Justificación:** Permite completar la transacción mediante el servicio de cobros.

### HU-03 – Historial por vendedor
**Endpoint:** `GET /sales/rep/{vendedorId}`

> **Como responsable de recursos humanos, quiero consultar el historial de ventas de un vendedor para dar seguimiento a las ventas realizadas por cada vendedor.**

**Prioridad:** Should Have  
**Story Points:** 5

**Justificación:** Facilita el seguimiento de la actividad comercial del vendedor.

### HU-04 – Validación de garantía
**Endpoint:** `GET /sales/validate-warranty/{saleId}`

> **Como personal de soporte, quiero validar la existencia y vigencia de la garantía asociada a una venta para determinar si el cliente puede recibir atención por garantía.**

**Prioridad:** Should Have  
**Story Points:** 5

**Justificación:** Permite comprobar la vigencia de una garantía antes de atender una solicitud.

### HU-05 – Historial de compras
**Endpoint:** `GET /sales/customer/{clienteId}`

> **Como cliente, quiero consultar mi historial de compras para conocer las ventas y compras que he realizado anteriormente.**

**Prioridad:** Should Have  
**Story Points:** 5

**Justificación:** Permite consultar las operaciones anteriores registradas del cliente.

### HU-06 – Resumen de ventas
**Endpoint:** `GET /sales/summary`

> **Como administrador o responsable de ventas, quiero consultar un resumen de los indicadores de ventas por período para analizar el comportamiento de las ventas realizadas.**

**Prioridad:** Could Have  
**Story Points:** 5

**Justificación:** Aporta análisis consolidado, pero puede incorporarse después de las operaciones principales.

## 4. Matriz consolidada

| ID | Historia | Endpoint | Método | Prioridad | Story Points |
|---|---|---|---|---|---:|
| HU-01 | Autenticación de usuario | `/auth/login` | POST | Must Have | 3 |
| HU-02 | Procesamiento de pago | `/payments/process` | POST | Must Have | 5 |
| HU-03 | Historial por vendedor | `/sales/rep/{vendedorId}` | GET | Should Have | 5 |
| HU-04 | Validación de garantía | `/sales/validate-warranty/{saleId}` | GET | Should Have | 5 |
| HU-05 | Historial de compras | `/sales/customer/{clienteId}` | GET | Should Have | 5 |
| HU-06 | Resumen de ventas | `/sales/summary` | GET | Could Have | 5 |

## 5. Reglas de Negocio

- **RN-01:** Los usuarios deben autenticarse para acceder a operaciones protegidas.
- **RN-02:** Las operaciones protegidas utilizan Bearer JWT.
- **RN-03:** Los pagos se procesan mediante el endpoint definido para cobros.
- **RN-04:** El historial de ventas por vendedor se consulta mediante su identificador.
- **RN-05:** La garantía se valida mediante el identificador de la venta.
- **RN-06:** El historial de compras se consulta mediante el identificador del cliente.
- **RN-07:** El resumen presenta indicadores consolidados por período.
- **RN-08:** La gestión de inventario no forma parte del alcance de este módulo.

## 6. Criterio MoSCoW

- **Must Have:** necesario para acceso y operaciones principales.
- **Should Have:** importante para consulta, seguimiento y soporte.
- **Could Have:** aporta valor adicional y puede posponerse.
- **Won't Have:** fuera del alcance actual.

## 7. Trazabilidad con endpoints

| Historia | Endpoint | Propósito |
|---|---|---|
| HU-01 | `POST /auth/login` | Autenticación de usuario |
| HU-02 | `POST /payments/process` | Procesamiento de pago |
| HU-03 | `GET /sales/rep/{vendedorId}` | Historial por vendedor |
| HU-04 | `GET /sales/validate-warranty/{saleId}` | Validación de garantía |
| HU-05 | `GET /sales/customer/{clienteId}` | Historial de compras |
| HU-06 | `GET /sales/summary` | Resumen de ventas |

## 8. Tablero Ágil

**Enlace:** [Pendiente: insertar enlace público de Jira o GitHub Projects]
