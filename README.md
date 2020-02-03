# TVP_Sociedad
<h1>Pequeño proyecto de 2º de aplicaciones multiplataforma (Interfaces)</h1>
<h2>Como funciona:</h2>
<p>Este proyecto es una simulación de una TPV de una sociedad. En esta tenemos varios productos, en este caso clasificado por 3 categorías: Refrescos, bebidas alcoholicas y tabaco. En un futuro se pueden añadir nuevas categorías fácilmente, como los cafés por ejemplo. El proyecto está hecho a través de Java Swing, que permite trabajar con Java e interfaz gráfica. Para la base de datos he usado MySQL, instalando WAMPP en mi equipo para facilitar el trabajo con la base de datos.</p>
<p>El TPV funciona de la siguiente manera: Tenemos un login con unos usuarios ya creados en la base de datos, nos logeamos y tenemos 2 opciones, comprar un producto o reservar una mesa. Para comprar un producto nos saldrá una lista de productos clasificados por categoría, y ahí podremos ver el stock, la cantidad que queremos coger y su precio. Por otro lado para reservar una mesa, tenemos un calendario para escoger la fecha y un desplegable con las horas disponibles para reservar la mesa.</p>
<p>Para generar los informes de stock de los productos he usado el siguiente tutorial: https://www.ecodeup.com/como-crear-reportes-en-java-con-jasperreports/</p>
<h2>Cosas por hacer:</h2>
<ul>
<li>No poder reservar una mesa dos veces en la misma fecha y hora, para ello crear una relación en la bd</li>
<li>Encriptar las contraseñas de los usuarios con ssh u otro metodo (probar bcrypt)</li>
<li>Poder comprar varios productos de la TVP a la vez en vez de hacerlo de uno en uno, insertarlos en una lista por ejemplo y sumarlos todos.</li>
<li>Mejorar la interfaz gráfica, ahora mismo se ve bastante feo ya que estoy enfocandome en el funcionamiento</li>
