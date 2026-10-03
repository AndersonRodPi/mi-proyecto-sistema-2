# language: es
Característica: Autenticación y acceso de usuarios (HU-01)
  Como usuario autorizado
  Quiero iniciar sesión con mis credenciales
  Para acceder de forma segura a las funcionalidades del módulo de ventas

  Regla: RN-01, RN-02 - Los usuarios deben autenticarse mediante JWT.

  Escenario: Inicio de sesión exitoso (Camino Feliz)
    Dado que el usuario envía credenciales válidas con correo "usuario@empresa.com" y contraseña "Clave123*"
    Cuando se procesa la solicitud en el endpoint "POST /auth/login"
    Entonces el sistema responde con un código de estado 200 OK
    Y devuelve un token de acceso JWT válido y los datos básicos del usuario.

  Escenario: Intento de inicio de sesión con contraseña incorrecta (Excepción)
    Dado que el usuario ingresa el correo "usuario@empresa.com" con contraseña errónea "ClaveIncorrecta"
    Cuando se procesa la solicitud en el endpoint "POST /auth/login"
    Entonces el sistema responde con un código de estado 401 Unauthorized
    Y presenta un mensaje de error "Credenciales inválidas".

  Escenario: Solicitud de autenticación con campos obligatorios faltantes (Excepción)
    Dado que el usuario envía una solicitud sin incluir la contraseña
    Cuando se envía la petición al endpoint "POST /auth/login"
    Entonces el sistema responde con un código de estado 400 Bad Request
    Y muestra la validación "El campo contraseña es obligatorio".