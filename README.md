![enter image description here](http://www.javeriana.edu.co/PortalJaveriana-Theme/HomeJaveriana/images/javeriana/logo_puj.png)
> **Facultad de Ingeniería/** 
 **Departamento de Ingeniería de Sistemas** -
 *Especialización en Arquitectura Empresarial de Software*

# Intro!
El taller tiene la finalidad de mostrar la implementación de una solución sencilla, donde se pueda observar una aproximación a la arquitectura orientada a servicios .

# Escenario
El Banco ABC tiene una alianza con diferentes proveedores de servicios públicos (convenios), para permitir que los clientes de éste puedan realizar los pagos a través de sus direfentes canales de servicio. Cada uno de los proveedores de servicios públicos, ofrece los mecanismos de interacción
tecnológica necesarios para que el Banco pueda ejecutar las acciones de pago. Cada proveedor utiliza tecnologías diferentes para ofrecer sus servicios.
El Banco ABC quiere tener la posibilidad de adicionar nuevos convenios con otros
proveedores de servicios de manera ágil, o incluso la posibilidad de terminar/eliminar los
convenios existentes sin que esto represente indisponibilidad del servicio.


## Acuerdo de Funcionalidades Principales:

Se llegó a un acuerdo de las capacidades/primitivas básicas que se deben soportar para cada
convenio:

 - Consulta de saldo a Pagar
 - Pagos del Servicio

# Solución
 La solución planteada esta basada en un **Estilo orientado a servicios** donde éstos, representen cada una de las funcionalidades acordadas en los convenios, como el de consulta de pago y el valor a pagar. Adicional se usó internamente el patrón de microservicios **Microservice Compositor**, utilizado para componer los servicios especializados en tiempo de ejecución para completar colectivamente cada una de las funcionalidades acordadas, de esta forma cubrir la necesidad de manejar diversos proveedores (agregar y eliminar) sin mayor impacto en el sistema.

## Diseño interno

Se crearon los siguientes servicios especializados (microservicios) :

 - Coordinador (**orchestrator**): 
 - Enrrutador (**routing**)
 - Despachador (**dispatcher**)
 - Traductor (**transform**)

Para el estilo *Contract-first Web services* se utilizó **Swagger**,  el *Services Inventory* se realizó a través de un documento en JSON. El enrrutador esta basado en el patrón **Intermediate Routing** enrutamiento basado en datos, que identifca el Id del servicio del proveedor con el cual debe comunicarse (endpoint).

*Desplegar desde Docker hub

