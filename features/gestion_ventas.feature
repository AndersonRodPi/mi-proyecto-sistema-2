# language: es
Característica: Gestión y Procesamiento del Módulo de Ventas (HU-02 a HU-06)

  # -------------------------------------------------------------------
  # HU-02: Procesar Pago
  # -------------------------------------------------------------------
  Escenario: Procesamiento exitoso del pago de una venta (Camino Feliz - HU-02)
    Dado que el vendedor cuenta con un token JWT válido de sesión
    Y se proporciona una solicitud de pago con monto 150.00 y método "Tarjeta"
    Cuando se realiza una petición "POST /payments/process"
    Entonces el sistema responde con estado 201 Created
    Y confirma la transacción devolviendo el ID de confirmación de pago y recibo.

  Escenario: Procesamiento de pago rechazado por fondos insuficientes (Excepción - HU-02)
    Dado que el vendedor envía la transacción mediante el endpoint "POST /payments/process"
    Pero la tarjeta ingresada no posee fondos suficientes
    Entonces el sistema responde con código 402 Payment Required
    Y devuelve el mensaje de error "Transacción rechazada por el emisor".

  Escenario: Intento de procesamiento de pago sin token JWT (Excepción - HU-02)
    Dado que se envía una petición a "POST /payments/process" sin encabezado Authorization
    Entonces el sistema responde con código 401 Unauthorized
    Y no permite procesar el cobro.

  # -------------------------------------------------------------------
  # HU-03: Historial por Vendedor
  # -------------------------------------------------------------------
  Escenario: Consulta exitosa de historial de ventas por vendedor (Camino Feliz - HU-03)
    Dado que el usuario autorizado consulta el historial del vendedor con ID "VEND-101"
    Cuando ejecuta la petición "GET /sales/rep/VEND-101"
    Entonces el sistema responde con estado 200 OK
    Y muestra la lista de ventas realizadas con sus detalles y montos.

  Escenario: Consulta de vendedor con identificador inexistente (Excepción - HU-03)
    Dado que el usuario intenta consultar el historial del vendedor "VEND-999" inexistente
    Cuando ejecuta la petición "GET /sales/rep/VEND-999"
    Entonces el sistema responde con estado 404 Not Found
    Y presenta el mensaje "Vendedor no encontrado".

  # -------------------------------------------------------------------
  # HU-04: Validación de Garantía
  # -------------------------------------------------------------------
  Escenario: Validación exitosa de garantía vigente (Camino Feliz - HU-04)
    Dado que el personal de soporte consulta la garantía de la venta "VENTA-5001"
    Cuando realiza la consulta mediante "GET /sales/validate-warranty/VENTA-5001"
    Entonces el sistema responde con código 200 OK
    Y confirma que la garantía se encuentra activa indicando la fecha de vencimiento.

  Escenario: Validación de garantía de venta inexistente (Excepción - HU-04)
    Dado que el personal de soporte envía un ID de venta inválido "VENTA-0000"
    Cuando consulta el endpoint "GET /sales/validate-warranty/VENTA-0000"
    Entonces el sistema responde con un código 404 Not Found
    Y muestra el mensaje "Venta no registrada para validación de garantía".

  # -------------------------------------------------------------------
  # HU-05: Historial de Compras de Cliente
  # -------------------------------------------------------------------
  Escenario: Consulta exitosa de compras del cliente (Camino Feliz - HU-05)
    Dado que el cliente con ID "CLI-202" consulta sus compras
    Cuando solicita la información a través de "GET /sales/customer/CLI-202"
    Entonces el sistema devuelve un estado 200 OK
    Y desglosa la lista histórica de facturas y productos adquiridos.

  Escenario: Consulta de cliente sin compras registradas (Excepción - HU-05)
    Dado que se consulta el historial del cliente "CLI-777" sin compras previas
    Cuando se llama al endpoint "GET /sales/customer/CLI-777"
    Entonces el sistema responde con código 200 OK
    Y devuelve una lista vacía con el mensaje "El cliente no registra transacciones".

  # -------------------------------------------------------------------
  # HU-06: Indicadores y Resumen de Ventas
  # -------------------------------------------------------------------
  Escenario: Consulta exitosa de resumen de indicadores por período (Camino Feliz - HU-06)
    Dado que el administrador consulta los indicadores del periodo "2026-Q1"
    Cuando invoca el endpoint "GET /sales/summary?period=2026-Q1"
    Entonces el sistema responde con un código 200 OK
    Y muestra los totales de ventas, margen de ingresos y promedios por período.

  Escenario: Consulta de resumen de ventas con formato de período inválido (Excepción - HU-06)
    Dado que se ingresa un parámetro de período con formato erróneo "PeriodoIncorrecto"
    Cuando se realiza la solicitud "GET /sales/summary?period=PeriodoIncorrecto"
    Entonces el sistema devuelve un código 400 Bad Request
    Y muestra el mensaje de error "Formato de período no válido. Use YYYY-QX o YYYY-MM".