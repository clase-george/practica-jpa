# 🧩 Actividad: Entidades, Repositorios y Tests con JPA (Proyecto Videoclub)

## [Fecha de entra límite  19 de Diciembre]

[https://github.com/FP-Summa/practica-jpa](https://github.com/FP-Summa/practica-jpa)

## **0. Contexto**

Se os entrega un proyecto **Maven + Spring Boot** ya creado, con:

- Dependencias de Spring Data JPA y H2.
- Ficheros schema.sql y data.sql que crean y rellenan las tablas:
    - director, pelicula, actor, pelicula_actor, cliente, alquiler.

Vuestra misión:

1. Crear las **entidades JPA** a partir de las tablas.
2. Crear las **interfaces de repositorio**.
3. Diseñar **métodos de consulta en los repositorios** (algunos obligatoriamente usando @Query).
4. Crear **tests de repositorio** que usen los datos de data.sql.

---

## **1. Parte 1 — Entidades JPA**

A partir del modelo de tablas que se os entrega (director, pelicula, actor, pelicula_actor, cliente, alquiler), debéis:

1. Crear las clases:
    - DirectorEntity
    - PeliculaEntity
    - ActorEntity
    - ClienteEntity
    - AlquilerEntity
2. Respetar:
    - Nombres, tipos y tamaños de columnas.
    - Restricciones (nullable, unique).
    - Relaciones:
        - Director – Película → **uno a muchos / muchos a uno**
        - Película – Actor → **muchos a muchos**
        - Cliente – Alquiler → **uno a muchos / muchos a uno**
        - Película – Alquiler → **uno a muchos / muchos a uno**
3. Usar las anotaciones adecuadas:
    - @Entity, @Table
    - @Id, @GeneratedValue
    - @Column
    - @ManyToOne, @OneToMany, @ManyToMany, @JoinColumn, @JoinTable, mappedBy, etc.

## **2. Parte 2 — Repositorios**

Debéis crear las interfaces de repositorio para:

- Directores
- Películas
- Actores
- Clientes
- Alquileres

Todas las interfaces deben heredar de JpaRepository.

### **Funcionalidad mínima que debe proporcionar cada repositorio**

### **🔹 Repositorio de Directores**

Debe permitir, como mínimo:

1. Buscar un director por su nombre exacto.
2. Comprobar si existe un director con un determinado nombre.
3. (Obligatorio con @Query) Hacer una consulta JPQL que devuelva un director a partir de su nombre, similar a:
    - “Selecciona el director cuyo nombre sea el valor recibido como parámetro”.
4. Ordenación: obtener la lista de directores ordenados alfabéticamente por nombre (de forma ascendente o descendente).

### **🔹 Repositorio de Películas**

Debe permitir, como mínimo:

1. Obtener todas las películas de un **determinado director**, usando el **nombre del director**.
2. Obtener todas las películas de un **determinado género**.
3. Obtener las películas con una **puntuación mínima** (por ejemplo, todas las que tengan puntuación mayor o igual a un valor dado).
4. (Obligatorio con @Query) Obtener todas las películas en las que participe un **actor** cuyo nombre se pasa como parámetro, usando la relación muchos-a-muchos Película–Actor.
5. Paginación: obtener las películas de un género concreto de forma paginada (por ejemplo, “página X con Y elementos por página”).
6. Ordenación: obtener las películas ordenadas por año de estreno o por puntuación.

### **🔹 Repositorio de Actores**

Debe permitir, como mínimo:

1. Buscar un actor por nombre.
2. Obtener todos los actores que han participado en una película cuyo **título** se pasa como parámetro (podéis hacerlo con método derivado o con @Query).
3. Ordenación: obtener actores ordenados alfabéticamente por nombre.

### **🔹 Repositorio de Clientes**

Debe permitir, como mínimo:

1. Buscar un cliente por email.
2. Comprobar si existe ya un cliente registrado con un determinado email (útil para evitar duplicados).
3. Paginación: obtener la lista de clientes de forma paginada (por ejemplo, para mostrar “página de clientes” en una futura API).

### **🔹 Repositorio de Alquileres**

Debe permitir, como mínimo:

1. Obtener todos los alquileres de un cliente usando su **email**.
2. Obtener todos los alquileres de una película usando su **título**.
3. Obtener todos los **alquileres activos**, es decir, aquellos que aún **no tienen fecha de devolución**.
4. (Obligatorio con @Query) Crear una consulta JPQL que devuelva los alquileres activos de un determinado cliente a partir de su email

## **3. Parte 3 — Tests de Repositorio**

Para cada repositorio debéis crear una clase de tests que:

- Use @DataJpaTest.
- Utilice la base de datos H2 en memoria.
- Se base en los datos cargados desde schema.sql y data.sql (ya proporcionados).

### **Requisitos de los tests**

1. **No insertar datos manualmente en los tests**: usad los datos que ya están en data.sql.
2. Por cada repositorio, debe haber **al menos dos tests**:
    - Uno que pruebe un **método derivado** (findBy..., existsBy..., etc.).
    - Otro que pruebe un **método con @Query**.
3. Las aserciones deben tener sentido con los datos reales. Ejemplos (orientativos):
    - Comprobar que, al buscar las películas de un cierto director, se obtienen X títulos concretos.
    - Comprobar que, al buscar alquileres activos de un cliente, se devuelven solo los que no tienen fecha de devolución.
    - Comprobar que buscar un director inexistente devuelve una colección vacía o un Optional vacío, según cómo hayáis diseñado el método.

---

## **4. Entrega**

Se considerará completa la práctica cuando el proyecto contenga:

1. Las **5 entidades JPA** correctamente mapeadas.
2. Las **interfaces de repositorio** con los métodos de consulta diseñados por vosotros según los requisitos.
3. Las **clases de test** de repositorio, con los tests pasando en verde.

---

## **5. Criterios de evaluación**

- Entidades correctas y coherentes con las tablas → **3 puntos**
- Relaciones JPA bien definidas (ManyToOne, OneToMany, ManyToMany) → **3 puntos**
- Repositorios con métodos de consulta útiles y bien diseñados → **2 puntos**
- Tests de repositorio claros y correctos (métodos derivados + @Query) → **2 puntos**

---

# **Modelo de Base de Datos – Videoclub**

A continuación tienes las **tablas del sistema del videoclub**.

Usa esta información para crear las **entidades JPA** correspondientes, replicando las propiedades indicadas (tipos, tamaños, claves primarias, claves foráneas y relaciones).

# **🟦 Tabla: DIRECTOR**

| **Columna** | **Tipo** | **Tamaño** | **Obligatoria** | **Comentarios** |
| --- | --- | --- | --- | --- |
| **id** | BIGINT | – | ✔️ Sí (PK) | Clave primaria autoincrementada |
| **nombre** | VARCHAR | 100 | ✔️ Sí | Nombre del director |

# **🟦 Tabla: PELICULA**

| **Columna** | **Tipo** | **Tamaño** | **Obligatoria** | **Comentarios** |
| --- | --- | --- | --- | --- |
| **id** | BIGINT | – | ✔️ Sí (PK) | Clave primaria autoincrementada |
| **titulo** | VARCHAR | 200 | ✔️ Sí | Título de la película |
| **genero** | VARCHAR | 50 | ❌ No | Género de la película |
| **anio_estreno** | INT | – | ❌ No | Año de estreno |
| **puntuacion** | DECIMAL | (3,1) | ❌ No | Nota entre 0.0 y 9.9 |
| **director_id** | BIGINT | – | ❌ No | FK hacia **DIRECTOR(id)**, ON DELETE SET NULL |

<aside>
📌

*Relación:* PELÍCULA **muchas → uno** DIRECTOR

</aside>

# **🟦 Tabla: ACTOR**

| **Columna** | **Tipo** | **Tamaño** | **Obligatoria** | **Comentarios** |
| --- | --- | --- | --- | --- |
| **id** | BIGINT | – | ✔️ Sí (PK) | Clave primaria autoincrementada |
| **nombre** | VARCHAR | 100 | ✔️ Sí | Nombre del actor |

# **🟦 Tabla intermedia: PELICULA_ACTOR**

(Relación **Many-to-Many** entre películas y actores)

| **Columna** | **Tipo** | **Obligatoria** | **Comentarios** |
| --- | --- | --- | --- |
| **pelicula_id** | BIGINT | ✔️ Sí (PK, FK) | FK hacia **PELÍCULA(id)**, ON DELETE CASCADE |
| **actor_id** | BIGINT | ✔️ Sí (PK, FK) | FK hacia **ACTOR(id)**, ON DELETE CASCADE |

<aside>
📌

- *Clave primaria compuesta:* (pelicula_id, actor_id)
- *Relación:* PELÍCULA **muchas ↔ muchas** ACTOR
</aside>

# **🟦 Tabla: CLIENT**

| **Columna** | **Tipo** | **Tamaño** | **Obligatoria** | **Comentarios** |
| --- | --- | --- | --- | --- |
| **id** | BIGINT | – | ✔️ Sí (PK) | Autoincremental |
| **nombre** | VARCHAR | 100 | ✔️ Sí | Nombre del cliente |
| **email** | VARCHAR | 150 | ✔️ Sí (UNIQUE) | Email único |

# **🟦 Tabla: ALQUILER**

| **Columna** | **Tipo** | **Tamaño** | **Obligatoria** | **Comentarios** |
| --- | --- | --- | --- | --- |
| **id** | BIGINT | – | ✔️ Sí (PK) | Autoincremental |
| **cliente_id** | BIGINT | – | ✔️ Sí (FK) | FK hacia **CLIENTE(id)** |
| **pelicula_id** | BIGINT | – | ✔️ Sí (FK) | FK hacia **PELÍCULA(id)** |
| **fecha_alquiler** | DATE | – | ✔️ Sí | Fecha del alquiler |
| **fecha_devolucion** | DATE | – | ❌ No | NULL si aún está activo |

<aside>
📌

CLIENTE **uno → muchos** ALQUILER

PELÍCULA **uno → muchos** ALQUILE

</aside>