# DB Directory
Docker Scripts

Postgresql
DB Postgresql

localhost 5432 docker docker

    docker run --rm --name pg \
        -v pgdata:/var/lib/postgresql/data \
        -p 5432:5432 \
        -e POSTGRES_PASSWORD=docker \
        -e "POSTGRES_USER=docker" \
        -e "POSTGRES_DB=docker" \
        -d  \
        postgres:12.6
DB MySQL
DB MySQL

localhost 3306 docker docker docker

    docker run --rm --name my \
        -v myvolume:/var/lib/mysql \
        -p 3306:3306 \
        -e MYSQL_ROOT_PASSWORD=docker \
        -e "MYSQL_DATABASE=docker" \
        -e "MYSQL_USER=docker" \
        -e "MYSQL_PASSWORD=docker" \
        -d  \
        mysql:8

