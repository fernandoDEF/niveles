++++CREAR CONTENEDOR PARA LA BASE DE DATOS++++
**crear una imagen de mysql y correr en un contenedor en docker:
docker pull mysql:5.7
docker run --name mysql-docker -e MYSQL_ROOT_PASSWORD=user -e MYSQL_DATABASE=leveldb -e MYSQL_USER=user -e MYSQL_PASSWORD=user -d mysql:5.7

**comprobar contenedor mysql-docker:
docker logs mysql-docker

**comprobar base de datos del contenedor mysql-docker:
docker exec -it mysql-docker bash -l
mysql -uuser -puser
SHOW DATABASES;
exit;


++++CREAR CONTENEDOR PARA EL MICROSERVICIO DE NIVELES++++++
**crear y correr level_ms:
docker build -t level_ms .
docker run -d -p 9000:9000 --name level_ms --link mysql-docker:mysql level_ms


++++CREAR CONTENEDOR PARA EL APIGATEWAY DE NIVELES+++++
**crear y correr level_api:
docker build -t level_api .
docker run -p 5000:5000 level_api