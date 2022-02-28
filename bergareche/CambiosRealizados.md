# Cambios realizados

Lista de modificaciones que he tenido que realizar al código base para realizar el proyecto de forma exitosa.

1. La interfaz del juego base era por consola y tenía casi todo el código dentro del `main`. He extraído dicho código en métodos más específicos así como transformar la clase en un controlador para administrar el estado de las partida.
2. El juego final debía tener una interfaz gráfica y el juego base no disponía de ella. He creado un proyecto en paralelo para crear la interfaz y poder usar la pestaña de diseño dentro de Eclipse para agilizar el proceso e ir moviendo dicho código a este proyecto.
3. Para el modo de un jugador *OponentComputer* he realizado una implementación muy básica en la que se escoge la primera casilla libre del tablero. El algoritmo puede ser fácilmente mejorado con algo más sofisticado, pero esto no es parte del alcance del proyecto.

---

**Nota**: se puede encontrar el código base del que he partido en [este directorio](./bergareche/original), también se puede ir observando la evolución de los cambios por medio de diff entre commits.