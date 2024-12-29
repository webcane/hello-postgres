# hello-postgres
simple spring boot application with postgresql support.

## env
Define following environment variables. rename sample.env file. to .env

```dotenv
DB_NAME=postgres
DB_HOST=db
SPRING_DATASOURCE_PASSWORD=
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_URL=jdbc:postgresql://$DB_HOST:5432/$DB_NAME
```

## run
use following command to build and run application

```shell
docker compose up
```
