# **UNIVERSIDAD NACIONAL**

## **Licenciatura en Sistemas \- Orientación a Objetos 1**

**Presentación del proyecto:** Crear una carpeta /tuApellidoNombre/DNI\<tuNroDni\> (el nombre del proyecto debe ser DNI\<tuNroDni\>).

**Adjunto:** La carpeta a enviar comprimida es tuApellidoNombre.zip.

**Entrega:** por Campus.

### **Sistema de Actualización de DNI (Tema: Herencia y Polimorfismo)**

Se pide crear un sistema para la actualización de DNI aplicando los conceptos de Herencia, Clases Abstractas y Polimorfismo vistos en la primera parte de la materia. Para lo cual se diseña el siguiente diagrama de clases y se pide resolver y testear los casos de uso detallados a continuación.

### **1\. MODELO DE CLASES (UML)**

\+-----------------------------------------------------------------------------------+  
| \<\<abstract\>\> Persona                                                              |  
\+-----------------------------------------------------------------------------------+  
| \# id: int                                                                         |  
| \# dni: long                                                                       |  
| \# apellido: String                                                                |  
| \# nombre: String                                                                  |  
| \# fechaNacimiento: LocalDate                                                      |  
\+-----------------------------------------------------------------------------------+  
| \+ setFechaNacimiento(fecha: LocalDate): void                                      |  
| \+ calcularEdad(fecha: LocalDate): int                                             |  
| \+ calcularCostoBase(fechaTramite: LocalDate, valorStandar: float,                 |  
|                     valorExtranjero: float): float \<\<abstract\>\>                   |  
\+-----------------------------------------------------------------------------------+  
         ^                                           ^  
         |                                           |  
\+-----------------------------------+   \+-----------------------------------+  
| CiudadanoNacional                 |   | CiudadanoExtranjero               |  
\+-----------------------------------+   \+-----------------------------------+  
| \- provinciaOrigen: String         |   | \- nacionalidad: String            |  
\+-----------------------------------+   \+-----------------------------------+  
| \+ calcularCostoBase(...): float   |   | \+ calcularCostoBase(...): float   |  
\+-----------------------------------+   \+-----------------------------------+

\+-----------------------------------------------------------------------------------+  
| ActualizacionDNI                                                                  |  
\+-----------------------------------------------------------------------------------+  
| \- id: int                                                                         |  
| \- lugarDeTramite: LugarDeTramite                                                  |  
| \- fecha: LocalDate                                                                |  
| \- persona: Persona                                                                |  
| \- costoActualizacion: float                                                       |  
| \- esExpres: boolean                                                               |  
\+-----------------------------------------------------------------------------------+

\+-----------------------------------------------------------------------------------+  
| LugarDeTramite                                                                    |  
\+-----------------------------------------------------------------------------------+  
| \- id: int                                                                         |  
| \- lugarDeTramite: String                                                          |  
\+-----------------------------------------------------------------------------------+

\+-----------------------------------------------------------------------------------+  
| SistemaDNI                                                                        |  
\+-----------------------------------------------------------------------------------+  
| \- valorStandar: float                                                             |  
| \- valorExtranjeros: float                                                         |  
| \- masValorExpres: float                                                           |  
| \- lstPersona: List\<Persona\>                                                       |  
| \- lstLugarDeTramite: List\<LugarDeTramite\>                                         |  
| \- lstActualizacionDNI: List\<ActualizacionDNI\>                                     |  
\+-----------------------------------------------------------------------------------+  
| \+ agregarCiudadanoNacional(dni, apellido, nombre, fechaNac, provincia): boolean   |  
| \+ agregarCiudadanoExtranjero(dni, apellido, nombre, fechaNac, nacionalidad): bool |  
| \+ traerPersona(dni: long): Persona                                                |  
| \+ agregarActualizacionDNI(lugar, fecha, persona, esExpres): boolean               |  
| \+ calcularRecaudacionExtranjeros(fecha: LocalDate): float                         |  
\+-----------------------------------------------------------------------------------+

### **2\. CASOS DE USO**

*IMPORTANTE: En el examen se evalúa de cada caso de uso modelo y test. En el caso de estar resuelto solo el modelo, no acredita puntos a la evaluación.*

*Nota: los id son autoincrementables. Implementar solo la excepción indicada.*

**En la jerarquía de Persona:**

1. \+ setFechaNacimiento(fechaNacimiento: LocalDate) : void  
   * Lanza una excepción si la fechaNacimiento es posterior a la actual con el siguiente mensaje: *Error: YYYY-MM-DD fecha de nacimiento inválida*.  
2. \+ calcularEdad(fecha: LocalDate) : int  
   * Para calcular la edad el día de fecha parámetro: Si ya cumplió años edad \= anioFecha \- anioNac. En caso contrario edad \= anioFecha \- anioNac \- 1\.  
3. \+ calcularCostoBase(fechaTramite: LocalDate, valorStandar: float, valorExtranjero: float) : float *(Implementación Polimórfica)*  
   * **En CiudadanoNacional**: Si el día del trámite la persona es menor de 18 o mayor de 75 años, el costo base es 0 (gratuito). Si tiene entre 18 y 75 años, el costo base es el valorStandar.  
   * **En CiudadanoExtranjero**: El costo base es siempre el valorExtranjero, sin importar la edad.

**En la clase SistemaDNI:**

4. \+ agregarCiudadanoNacional(...) y \+ agregarCiudadanoExtranjero(...)  
   * Valida que no exista el DNI en la lista general lstPersona. Instancia y agrega a la lista.  
5. \+ traerPersona(dni: long) : Persona  
   * Busca y retorna la persona correspondiente. Retorna null si no existe.  
6. \+ agregarActualizacionDNI(LugarDeTramite lugar, LocalDate fecha, Persona persona, boolean esExpres) : boolean  
   * **Cálculo del atributo costoActualizacion**: Debe resolverse obligatoriamente mediante **Polimorfismo**. El sistema le pide a la persona su costo base pasándole los valores del sistema. Finalmente, si el trámite es exprés (esExpres \== true), al costo de la actualización se le incrementa el valor exprés.  
7. \+ calcularRecaudacionExtranjeros(LocalDate fecha) : float  
   * Recorre la lista de actualizaciones de la fecha parámetro y suma la recaudación **sólo** de aquellos trámites pertenecientes a ciudadanos extranjeros. *(Nota: Utilice el operador instanceof para filtrar).*

### **3\. TESTTEMA2.JAVA (Salidas Esperadas)**

*Nota: Al comenzar cada test indique el número a resolver ej: System.out.println("1) "); y luego la implementación del mismo.*

**1\) Instanciar el objeto SistemaDNI e imprimir toString()**

SistemaDNI \[valorStandar=7500.0, valorExtranjeros=14000.0, masValorExpres=11000.0\]

**2\) Agregar e imprimir las siguientes personas** *(Se agregan a la misma lista polimórfica)*

CiudadanoNacional \[id=1, dni=11111111, nombre=Romero, apellido=Julina, fechaNacimiento=1951-04-01, provinciaOrigen=Buenos Aires\]

CiudadanoNacional \[id=2, dni=22222222, nombre=Lorca, apellido=Marcos, fechaNacimiento=2008-03-02, provinciaOrigen=Cordoba\]

CiudadanoExtranjero \[id=3, dni=33333333, nombre=Gomez, apellido=Juan, fechaNacimiento=1982-03-25, nacionalidad=Uruguaya\]

CiudadanoExtranjero \[id=4, dni=44444444, nombre=Campos, apellido=Maria, fechaNacimiento=2014-04-07, nacionalidad=Chilena\]

**3\) Intentar agregar la persona**

dni=66666666, nombre=Maria apellido=Romero, fecha=2026-09-12, provincia=CABA

Error: 2026-09-12 fecha de nacimiento inválida

**4\) Traer e imprimir la persona con DNI=22222222**

CiudadanoNacional \[id=2, dni=22222222, nombre=Lorca, apellido=Marcos...\]

**5\) Calcular e imprimir la edad el día=2026-05-06 de la persona con DNI=22222222**

Edad: 18

**6\) Agregar e imprimir los siguientes lugares de trámites**

LugarDeTramite \[id=1, lugarDeTramite=Laprida N°642 Lomas de Zamora\]

LugarDeTramite \[id=2, lugarDeTramite=Av. Paseo Colón 1093 CABA\]

**7\) Agregar e imprimir las siguientes actualizaciones** *(fecha de trámite: 2026-04-07)*

ActualizacionDNI \[id=1, lugar=Laprida N°642..., persona=Juan Gomez, costo=25000.0, esExpres=true\] *(14000 \+ 11000 exprés)*

ActualizacionDNI \[id=2, lugar=Laprida N°642..., persona=Julina Romero, costo=0.0, esExpres=false\] *(Nacional \> 75 años \= Gratis)*

ActualizacionDNI \[id=3, lugar=Laprida N°642..., persona=Marcos Lorca, costo=7500.0, esExpres=false\] *(Nacional \> 18 años \= Estándar)*

ActualizacionDNI \[id=4, lugar=Laprida N°642..., persona=Maria Campos, costo=14000.0, esExpres=false\] *(Extranjera \= Valor extranjero fijo)*

**8\) Calcular e imprimir recaudacion por tramite SOLO de extranjeros fecha: 2026-04-07**

Recaudación Extranjeros: $39000.0

### **Observaciones del Docente para la Corrección:**

* **Herencia y Visibilidad:** Asegúrese de usar protected en los atributos de Persona (o en su defecto getters protegidos) para que las subclases puedan usarlos en sus cálculos.  
* **Sobreescritura (Override):** Las firmas del método calcularCostoBase deben ser exactamente iguales en toda la jerarquía para garantizar el polimorfismo.  
* **Casteo (Casting) e InstanceOf:** Son obligatorios para resolver correctamente el requerimiento número 7 (Recaudación de extranjeros).