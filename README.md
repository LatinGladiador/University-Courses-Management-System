# Sistema de Gestión Universitaria

![Licencia MIT](https://img.shields.io/badge/licencia-MIT-blue.svg)
![Estado del Proyecto](https://img.shields.io/badge/estado-finalizado-green.svg)
![Versión](https://img.shields.io/badge/versión-1.0.0-brightgreen.svg)

**Sistema de Gestión Universitaria** es una aplicación en Java para la administración de cursos, estudiantes y profesores en una universidad. La aplicación permite gestionar cursos, inscripciones de estudiantes y asignaciones de profesores de manera eficiente.
![image](https://github.com/user-attachments/assets/1d190833-8b15-4399-8909-d22eb12155c0)


## 🚀 Descripción

El sistema está diseñado para gestionar cursos con capacidad fija, estudiantes que pueden estar inscritos en un número limitado de cursos y profesores que pueden ser asignados a un máximo de cursos. 

### Descripción del Problema

Una universidad de TI desea desarrollar un sistema de gestión de cursos. Los cursos tienen capacidades fijas y los estudiantes solo pueden inscribirse en un número limitado de cursos si la capacidad lo permite.

### Instancias Iniciales

#### Cursos a agregar:

| courseId | courseName           | courseLevel |
|----------|----------------------|-------------|
| 1        | java_beginner        | bachelor    |
| 2        | java_intermediate    | bachelor    |
| 3        | python_basics        | bachelor    |
| 4        | algorithms           | master      |
| 5        | advanced_programming | master      |
| 6        | mathematical_analysis| master      |
| 7        | computer_vision      | master      |

#### Estudiantes a agregar:

| memberId | memberName | enrolledCourses              |
|----------|------------|------------------------------|
| 1        | Alice      | java_beginner, java_intermediate, python_basics |
| 2        | Bob        | java_beginner, algorithms    |
| 3        | Alex       | advanced_programming         |

#### Profesores a agregar:

| memberId | memberName | enrolledCourses              |
|----------|------------|------------------------------|
| 4        | Ali        | java_beginner, java_intermediate |
| 5        | Ahmed      | python_basics, advanced_programming |
| 6        | Andrey     | mathematical_analysis        |

## 🛠️ Tecnologías Utilizadas

- **Java**: Lenguaje de programación utilizado para implementar la lógica del sistema.
- **Scanner**: Para la entrada de datos desde la consola.

## 🏗️ Instalación

Para ejecutar este proyecto en tu máquina local, sigue estos pasos:

1. **Clona el repositorio**:

    ```bash
    git clone https://github.com/LatinGladiador/University-Courses-Management-System.git
    ```

2. **Navega al directorio del proyecto**:

    ```bash
    cd University-Courses-Management-System
    ```

3. **Compila el proyecto**:

    ```bash
    javac Main.java
    ```

4. **Ejecuta la aplicación**:

    ```bash
    java Main
    ```

## 🖥️ Uso

- La aplicación lee comandos desde la entrada estándar.
- Los comandos disponibles incluyen `course`, `student`, `professor`, `enroll`, `drop`, `teach`, y `exempt`.

### Métodos

- **fillInitialData()**: Carga las instancias iniciales con los datos proporcionados en las tablas.
- **teach(Course)**: Asigna un profesor para enseñar un curso si no lo está enseñando ya y no ha alcanzado su límite de carga de cursos.
- **exempt(Course)**: Exime al profesor de enseñar un curso si actualmente lo está enseñando.
- **enroll(Course)**: Inscribe al estudiante en un curso si no está ya inscrito, no ha alcanzado el número máximo de inscripciones y el curso no está lleno.
- **drop(Course)**: Da de baja al estudiante de un curso si está inscrito en él.
- **isFull()**: Verifica si el curso ha alcanzado su capacidad de inscripción.

### Reglas

- Cada curso tiene una capacidad de 3 estudiantes.
- Un estudiante no puede estar inscrito en el mismo curso más de una vez.
- Un estudiante no puede estar inscrito en más de 3 cursos.
- Un estudiante no puede inscribirse en un curso que esté lleno (ya tiene 3 estudiantes inscritos).
- Un profesor no puede ser asignado a un curso que ya está enseñando.
- Un profesor no puede ser asignado para enseñar más de 2 cursos.
- Un profesor no puede ser eximido de un curso si no lo está enseñando.

### Formato de Entrada

Los comandos se representan a través de la entrada estándar. El programa lee la entrada línea por línea. Verifica la corrección de cada línea de entrada; si es correcta, espera la siguiente línea, de lo contrario, imprime un mensaje de error y termina el programa. La ejecución se detiene cuando se encuentra una línea vacía. Los comandos pueden ser múltiples.

#### Comando/Formato de Entrada

- Añadir curso: `course courseName courseLevel`
- Añadir estudiante: `student memberName`
- Añadir profesor: `professor memberName`
- Inscribir a un curso: `enroll memberId courseId`
- Dar de baja de un curso: `drop memberId courseId`
- Asignar a un curso: `teach memberId courseId`
- Eximir de un curso: `exempt memberId courseId`

### Formato de Salida

Cada línea de salida se genera para cada comando de entrada leído y realizado.

#### Mensajes para cada comando:

| Comando   | Mensaje                                        |
|-----------|------------------------------------------------|
| course    | Añadido exitosamente                           |
| student   | Añadido exitosamente                           |
| professor | Añadido exitosamente                           |
| enroll    | Inscrito exitosamente                          |
| drop      | Dado de baja exitosamente                      |
| exempt    | Profesor eximido exitosamente                 |
| teach     | Profesor asignado exitosamente para enseñar este curso |

#### Mensajes de Error

- Curso existe
- Estudiante ya está inscrito en este curso
- Se alcanzó el máximo de inscripciones para el estudiante
- Curso está lleno
- Estudiante no está inscrito en este curso
- Carga del profesor completa
- Profesor ya está enseñando este curso
- Profesor no está enseñando este curso
- Entradas incorrectas

### Ejemplos

#### Entrada

```plaintext
course
Java_advanced
master
```

#### Salida

```plaintext
Añadido exitosamente
```

#### Entrada

```plaintext
enroll
1
1
```

#### Salida

```plaintext
Estudiante ya está inscrito en este curso
```

#### Entrada

```plaintext
student
siba
enroll
7
5
enroll
7
6
enroll
7
4
enroll
7
2
```

#### Salida

```plaintext
Añadido exitosamente
Inscrito exitosamente
Inscrito exitosamente
Inscrito exitosamente
Se alcanzó el máximo de inscripciones para el estudiante
```

### Nota

El uso de `@SuppressWarnings` para el plugin Checkstyle será considerado como una violación de las normas del proyecto.

## 🤝 Contribuciones

Las contribuciones al proyecto son bienvenidas. Si deseas contribuir, sigue estos pasos:

1. **Fork el repositorio**.
2. **Crea una rama** para tus cambios (`git checkout -b mi-rama`).
3. **Haz un commit** de tus cambios (`git commit -am 'Añadí algo'`).
4. **Push** a la rama (`git push origin mi-rama`).
5. **Crea un Pull Request** en GitHub.

## 👤 Autor

Este proyecto fue creado y es mantenido por [LatinGladiador](https://github.com/LatinGladiador).

## 📜 Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

---

[![MIT License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
