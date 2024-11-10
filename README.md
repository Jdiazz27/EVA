# Proyecto EVA 🤖✨

**Autores:**
- Juan Diaz 👨‍💻
- Manuela Maiguel 👩‍💻
- Alejandra Sanz 👩‍💻
- Laura Rodriguez 👩‍💻

## Descripción 📚

El proyecto **EVA** es una implementación que hace uso de la API de **Ollama** para interactuar con modelos de lenguaje. Dentro del proyecto, utilizamos el modelo **Llama 3.2** 🦙💡 para procesar y generar texto de manera eficiente. **EVA** es capaz de generar respuestas inteligentes a partir de las interacciones del usuario. Permite a los usuarios comunicarse con el modelo de lenguaje en tiempo real y también gestionar el historial de conversaciones.

## Entregado a:  
- **Curso**: Algoritmia II   
- **Profesor/a**: Katherine Bermejo 👩‍🏫

## Tecnologías 🛠️
- **API**: Ollama API 🌐
- **Lenguaje de modelo**: Llama 3.2 🧠

# 🚀 Dependencias
Para poder ejecutar este proyecto, asegúrate de cumplir con los siguientes requisitos:

## 1️⃣ Instalar la API de Ollama
Es necesario tener la API de Ollama descargada en tu computador. Así que, descarga e instala Ollama desde el sitio web oficial. Una vez instalada, sigue estos pasos:
- Abre una **terminal de Windows**.
- Ingresa el siguiente comando:
  ```bash
  ollama run llama3.2
Esto iniciará el servidor de Ollama y podrás hacer solicitudes a la API de Llama 3.2
  
## 2️⃣ Integrar la dependencia JSON
Si encuentras algún error relacionado con JSON, sigue estos pasos para integrarlo al proyecto:
1. Haz **clic derecho** sobre **Source Packages**  en tu IDE (como NetBeans).
2. Selecciona **Properties**.
3. Ve a la pestaña **Libraries**.
4. Haz clic en **Classpath (+)** y selecciona **Add JAR/Folder**.

## Forma de uso 🦾  
1. **Instala las dependencias necesarias** para ejecutar el proyecto, asegurándote de que tienes acceso a la API de Ollama y al modelo Llama 3.2.  
2. **Configura las credenciales** de la API de Ollama en tu entorno, siguiendo las instrucciones de su documentación.  
3. **Clona el repositorio en tu máquina local**. Si estás usando NetBeans, sigue estos pasos:
   - Ve a **Team > Remote > Clone**.
   - Introduce el siguiente enlace del repositorio:  
     https://github.com/Jdiazz27/EVA.git
4. **Interacción con EVA**: Una vez iniciado, puedes interactuar con el modelo a través de la interfaz que muestra las respuestas generadas en tiempo real.  
5. **Personalización**: Modifica las configuraciones de entrada para ajustar el comportamiento de EVA según tus necesidades.

## 3️⃣ Interacción con EVA

Una vez que hayas instalado y configurado todo, puedes comenzar a interactuar con EVA. La interfaz permite la entrada de texto por parte del usuario y presenta las respuestas generadas por el modelo de lenguaje en tiempo real.

  **- Pasos para interactuar:**

1. Abre la interfaz del chatbot.
2. Escribe un mensaje en el campo de entrada.
3. EVA procesará el mensaje usando el modelo Llama 3.2 y generará una respuesta.
4. La respuesta aparecerá en la pantalla, y el ciclo se repetirá para nuevas interacciones.

## 4️⃣ Historial de Conversaciones

El historial de conversaciones es una funcionalidad esencial que permite a los usuarios revisar interacciones previas con el chatbot. En EVA, cada vez que un usuario envía un mensaje y recibe una respuesta, ambos se almacenan en un registro que puede ser consultado.

  **- Cómo ver el historial:**

1. En la interfaz del chatbot, hay una opción para ver el historial de mensajes anteriores.
2. Puedes revisar todos los mensajes enviados y las respuestas generadas por EVA, dando click a cada chat previamente generado.
3. Así mismo, luego de ver el historial, puedes decidir si crear un nuevo chat o salirte de Eva.

**🖋️ Guía para Colaboradores en GitHub:**

Si deseas colaborar en este proyecto, puedes hacerlo siguiendo estos pasos:

**1️⃣ Clonar el Repositorio:**

Para comenzar a trabajar en el proyecto EVA, primero necesitas clonar el repositorio en tu máquina local. Esto crea una copia del repositorio en tu entorno de desarrollo para que puedas trabajar en el código de manera local.
      
      1. Abre tu terminal o línea de comandos.
      2. Ejecuta el siguiente comando para clonar el repositorio:
      
      ```bash  
      git clone https://github.com/Jdiazz27/EVA.git

Esto descargará todo el código fuente del proyecto a tu computadora. Asegúrate de que el repositorio se haya clonado correctamente verificando que la carpeta EVA esté presente en tu directorio de trabajo.

**2️⃣ Crear una Rama Nueva:**

Una de las mejores prácticas de colaboración es trabajar siempre en una rama separada. La rama principal (main o master) debe mantenerse limpia, y cada colaborador debe realizar sus cambios en ramas separadas. De esta manera, puedes hacer modificaciones sin afectar la estabilidad del código en producción. 

  **Pasos para crear una nueva rama:**
  
      1. Navega a la carpeta del proyecto (si aún no lo has hecho):
      
      ```bash
      cd EVA
      
      2. Crea una nueva rama con un nombre descriptivo. Por ejemplo, si estás trabajando en una nueva funcionalidad para mostrar el historial de       conversaciones, puedes llamarla historial-conversaciones:
      
      ```bash
      git checkout -b historial-conversaciones
      
      *Este comando realiza dos acciones:*
      1. Crea la nueva rama (-b).
      2. Cambia a esa nueva rama para que puedas comenzar a trabajar en ella.

Es importante que utilices nombres de ramas descriptivos para que otros colaboradores entiendan de qué trata el trabajo que estás realizando.

**3️⃣ Hacer Cambios en el Código y Realizar un Commit:**
Una vez que hayas realizado los cambios en el código o añadido nuevas funcionalidades, debes guardarlos en tu rama local mediante un commit. Los commits son puntos de control que permiten registrar las modificaciones realizadas.

  **Pasos para hacer un commit:**
  
      1. Verifica los archivos modificados con el siguiente comando:
      ```bash
      git status
Esto te mostrará todos los archivos que has modificado o añadido.
     
      2. Añade los archivos modificados al área de preparación (staging area):
      ```bash
      git add .
      
Este comando añade todos los archivos modificados. Si solo deseas añadir algunos archivos específicos, reemplaza el punto (.) por el nombre del archivo, por ejemplo:

      ```bash
      git add archivo1.java archivo2.java
      
      3. Realiza un commit para guardar los cambios localmente. Asegúrate de que tu mensaje de commit sea claro y descriptivo:
      ```bash
      git commit -m "Agregado historial de conversaciones con funcionalidad de búsqueda"

Los mensajes de commit deben ser breves pero explicativos. En este ejemplo, el mensaje explica qué funcionalidad se ha agregado.

**4️⃣ Subir la Rama a GitHub:**
Una vez que hayas realizado el commit con los cambios, debes subir esa rama a tu repositorio remoto en GitHub para que otros colaboradores puedan ver y trabajar sobre tus modificaciones.

  1. Sube tu rama al repositorio de GitHub:
     
     ```bash
     git push origin historial-conversaciones

Esto sube la rama que creaste (en este caso, historial-conversaciones) al repositorio remoto en GitHub.

**5️⃣ Crear un Pull Request (PR):**
Cuando hayas terminado de trabajar en una funcionalidad o corrección, y hayas subido tus cambios a tu repositorio remoto, el siguiente paso es crear un Pull Request (PR). Este es el proceso de solicitar que tus cambios sean revisados y, eventualmente, fusionados (merge) a la rama principal del proyecto.

  **Pasos para crear un Pull Request:**

      1. Ve a tu repositorio en GitHub (por ejemplo, https://github.com/Jdiazz27/EVA).
      2. En la página principal del repositorio, verás una notificación que dice algo como "Compare & pull request" cuando hayas subido una     
      nueva rama. Haz clic en ese botón.

Si no ves la notificación, también puedes ir a la pestaña Pull requests en el repositorio y hacer clic en New Pull Request.

      4. Selecciona la rama que creaste (por ejemplo, historial-conversaciones) y compárala con la rama principal (main o master).

Asegúrate de que los cambios que has realizado estén reflejados en la comparación.

      5. Escribe un título claro y una descripción detallada del pull request, explicando los cambios que has realizado, cómo se deben probar, y          cualquier otra información relevante.
      6. Haz clic en Create Pull Request.

Una vez que hayas creado el Pull Request, los mantenedores del proyecto revisarán tu código y proporcionarán comentarios o lo fusionarán si todo está correcto.

**6️⃣ Revisión y Resolución de Comentarios:**
Es probable que recibas comentarios o sugerencias de otros colaboradores o mantenedores del proyecto. Cuando esto ocurra:

    1. Lee los comentarios y comprende lo que se requiere para mejorar tu código.
    
    2. Realiza los cambios sugeridos en tu rama local y realiza un nuevo commit.
    
    ```bash
    git add .
    git commit -m "Corregidos comentarios de la revisión"
    
    3. Sube los cambios a GitHub para que se reflejen en el Pull Request:
    
    ```bash
    git push origin historial-conversaciones

Los cambios se añadirán automáticamente al Pull Request que ya has creado.

**7️⃣ Resolver Conflictos de Fusión (Merge Conflicts):**
Un conflicto de fusión ocurre cuando dos personas modifican el mismo archivo en la misma línea o parte del código. Git no puede fusionar estos cambios automáticamente y necesitarás resolver el conflicto manualmente.

  **Cómo resolver un conflicto de fusión:**
  
- Si intentas hacer un merge y hay un conflicto, Git te notificará. 
- Abre los archivos en conflicto. En los archivos, verás las secciones marcadas con <<<<<<, ======, y >>>>>>. Estas marcas indican las dos versiones del código en conflicto.
- Edita los archivos para decidir qué cambios deben mantenerse y elimina las marcas de conflicto (<<<<<<, ======, >>>>>>).
- Después de resolver los conflictos, añade los archivos modificados a la zona de preparación (staging area)
- Realiza un nuevo commit para guardar la resolución del conflicto
- Sube los cambios resueltos:

Tu Pull Request ahora estará listo para revisión nuevamente.

**8️⃣ Mejores Prácticas de Colaboración en GitHub:**

- Realiza commits frecuentes y pequeños: Es mejor hacer commits frecuentes con cambios pequeños y enfocados en una sola tarea en lugar de grandes commits con muchos cambios.
- Mantén tu rama actualizada: Antes de crear un Pull Request, asegúrate de que tu rama esté actualizada con los últimos cambios de la rama principal
- Escribe mensajes de commit claros y descriptivos: Un buen mensaje de commit explica qué cambios se realizaron y por qué. Esto facilita la comprensión del código cuando se revise.
- Revisa el código de otros colaboradores: La colaboración no solo consiste en hacer cambios, sino también en revisar los cambios de otros. Ayudar a otros colaboradores con sus Pull Requests es una parte importante del trabajo en equipo.
- Mantén un flujo de trabajo claro: Siempre crea ramas para nuevas funcionalidades o correcciones y evita hacer cambios directamente en la rama principal (main o master).

**Resolución de Errores Comunes 🛠️**

**Error al conectar con la API de Ollama:** 
- Asegúrate de que la API de Ollama esté en ejecución. Revisa la terminal para confirmar que el servidor se inició correctamente con el comando ollama run llama3.2.
- Verifica que las credenciales de la API sean correctas y estén configuradas correctamente en tu entorno.

**Problemas con JSON:**
- Si hay errores al procesar datos en formato JSON, asegúrate de que la librería JSON esté correctamente incluida en el proyecto.
- Si estás usando Maven o Gradle, revisa que la dependencia esté definida en el archivo pom.xml o build.gradle.

**La aplicación no responde:**
- Verifica si el modelo está correctamente conectado a la API.
- Asegúrate de que no haya errores en el servidor de Ollama.

¡Esperamos que disfruten trabajando con EVA! 😄

Laboratorio II | EVA
